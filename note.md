## Key Points to Remember

**1. Immutability vs Reassignment**
- String **objects** can never change (immutable)
- String **variables** (references) can point to any other string (reassignable)
- Old object → orphaned → garbage collected

**2. References are just addresses**
- A variable on the **stack** stores a memory address
- The **object** lives on the **heap**
- Two variables can point to the same object
- `s = "bye"` just changes the address, doesn't touch the old object

**3. Parent reference can hold child object**
- `Shape s = new Rectangle()` ✅ (child → parent, always safe)
- `Rectangle r = new Shape()` ❌ (parent → child, not safe)
- The variable type limits what you can *see*; the object decides what *runs*

**4. Constructor chaining**
- Parent constructor **always** runs before child constructor
- Order: `Object()` → `Shape()` → `Rectangle()`
- Because the parent portion of the object must be initialized first

**5. VTable (the secret of polymorphism)**
- Each class has its own table of method pointers
- Each object has a hidden pointer to its class's vtable
- At runtime, JVM follows: variable → object → vptr → vtable → correct method
- This is why `s.draw()` calls `Rectangle.draw()` even though `s` is declared as `Shape`

**6. `@Override`**
- Compile-time safety check — catches typos and wrong signatures
- No runtime effect, purely a guard against accidental overloading

**7. Static methods**
- Belong to the class, not an object
- No `this`, no access to instance fields
- Called via `ClassName.method()`
- `main` is static because the JVM needs an entry point before any object exists

**8. Packages**
- = folder + namespace + access boundary
- Prevents name conflicts, organizes code, controls visibility
- Must match folder structure

**The one mental model that ties it all together:**

> **Stack** holds references (addresses). **Heap** holds objects. The **declared type** is a compile-time filter. The **actual object** (via its vtable) decides what runs at runtime.

If you remember that one sentence, everything else follows from it.

## 2

Here's everything you learned, in order:

### Interfaces
- **`@Override`** works on interface methods too (Java 6+), catches typos at compile time
- **Why interfaces over classes:** single inheritance is limited, interfaces model *capability* not *identity*, multiple contracts per class, loose coupling
- **What interfaces actually do for you:** they let the **caller** write code once and swap implementations freely — the value is for the consumer, not the implementer
- **Without interfaces:** you duplicate code, use `if-else` chains, and have to hunt down every usage when you add/swap an implementation

### Exceptions
- **Custom exception:** you only write the constructor + `super(message)`; `getMessage()` is inherited from `Throwable`
- **`super(message)` chain:** your class → `Exception` → `Throwable` — each level **explicitly** forwards it; nothing is automatic
- **`throw`:** creates the object, stops the `try` block, hands the object to the matching `catch`
- **No matching catch:** JVM walks up the call stack; if it reaches the top → **program crashes** with a stack trace
- **Why catch matters:** without it the program **dies**; with it, the program **lives** and you control what happens next
- **Catch with parent type** (`Exception e` vs `InvalidAgeException e`): same `getMessage()`, but broader types catch more things (less precision)
- **Memory:** one single object in heap contains fields from all three levels (Throwable → Exception → yours), not three separate objects

### Primitives vs Objects
- **`int`, `double`, etc. are NOT objects** — raw values on the stack, no methods, can't be null
- **Wrapper classes** (`Integer`, `Double`) wrap them into objects for use in collections
- **`ArrayList` needs objects** because internally it's an `Object[]` — each slot holds a **reference** (memory address), and a primitive `int` is a raw value, not an address
- **Autoboxing** silently converts `int` ↔ `Integer` for you

### Strings
- **`String str = null`** works because `str` is a **reference variable** — any reference type can be null
- **`String s = "name"`** — JVM secretly creates the object in the **String Pool** (no `new` needed, reuses existing copy)
- **`new String("name")`** — always creates a **fresh object** in regular heap, ignores the pool, never reuses

## 3
`String s = null;` means `s` points to **nothing** — no object, no characters.

The word `"null"` you see on screen is just Java's **display convention**. When you print or concatenate a null reference, Java *shows* the word `null` so you know it's empty.

Think of it like a name tag:

- `String s = null;` → the tag is **blank** (no name written)
- `System.out.println(s);` → you look at the blank tag and **say** "null" out loud

The tag itself never changed. You just *described* it as "null" when you looked at it.

```java
String s = null;
System.out.println(s == null);   // true  → still empty
System.out.println(s == "null"); // false → not the word "null"
```

## 4

Absolutely. If you understand these points, you understand the core of this program.

# Java Threads — What to Remember

### 1. Threads

A `Thread` is an independent path of execution.

```java
t1.start();
t2.start();
```

starts two threads that can execute concurrently.

**Don't use `run()` to start a new thread.** `start()` creates the new thread.

---

### 2. Shared object

Your program creates **one** `Printer`:

```java
Printer printer = new Printer();
```

and gives the same object to both threads:

```java
new OddThread(printer);
new EvenThread(printer);
```

Therefore both threads share:

```java
private int number = 1;
```

Think:

```text
             Printer
          number = 1
           /       \
          /         \
     OddThread   EvenThread
```

---

### 3. `synchronized`

```java
public synchronized void printOdd()
public synchronized void printEven()
```

Because both methods belong to the **same `Printer` object**, they use the same object's lock.

Therefore:

```text
Thread A → printOdd()
Thread B → printEven()
```

cannot execute those synchronized methods simultaneously on that object.

**`synchronized` = mutual exclusion + acquiring the object's monitor/lock.**

---

### 4. What is the lock?

Every Java object has a monitor/lock associated with it.

For your program:

```text
Printer object
      │
      └── monitor/lock
```

A thread must own that lock to enter a synchronized instance method.

---

### 5. `wait()`

When a thread does:

```java
wait();
```

inside synchronized code:

1. It stops/waits.
2. **It releases the object's lock.**
3. It enters the waiting state.

So:

```text
Thread
  ↓
wait()
  ↓
release lock
  ↓
WAITING
```

This is extremely important:

> **`wait()` releases the lock.**

---

### 6. `notify()`

```java
notify();
```

does **not** release the lock.

It basically says:

> "One thread waiting on this object's monitor can wake up."

But the notifying thread **still owns the lock**.

So:

```text
notify()
   ↓
waiting thread becomes eligible
   ↓
current thread STILL has lock
   ↓
current thread eventually releases lock
   ↓
woken thread competes for lock
   ↓
gets lock
   ↓
continues after wait()
```

Remember:

> **`notify()` wakes; it does not hand over the lock.**

---

### 7. Your loop is important

You correctly noticed this.

After:

```java
notify();
```

your thread doesn't automatically leave the method.

It goes back to:

```java
while (number <= LIMIT)
```

Then it checks whether it's still its turn.

For example:

```text
Odd prints 1
     ↓
number = 2
     ↓
notify()
     ↓
loop again
     ↓
2 is even
     ↓
Odd calls wait()
     ↓
Odd releases lock
     ↓
Even gets lock
```

So:

> **`notify()` does NOT cause the current synchronized method to exit.**

---

### 8. Why `wait()` and `notify()` are in `Object`

They're methods of `Object` because waiting/notification is associated with an **object's monitor**.

Every Java object ultimately inherits from:

```text
Object
  ↑
Printer
```

So conceptually:

```java
wait();
```

inside `Printer` means:

```java
this.wait();
```

And:

```java
notify();
```

means:

```java
this.notify();
```

The coordination is around the **shared object**, not around a particular thread.

---

### 9. Why `while`, not `if`

Use:

```java
while (condition)
{
    wait();
}
```

because when a thread wakes up, it should **check the condition again**.

In your program:

```java
while (number % 2 == 0)
{
    wait();
}
```

means:

> "As long as it isn't my turn, keep waiting."

---

### 10. What happens without `synchronized`?

Two major problems.

#### Problem 1: No mutual exclusion

Both threads could enter the methods simultaneously.

That can cause a **race condition** when accessing shared `number`.

```text
Thread A reads number
Thread B reads number
Thread A changes it
Thread B changes it
```

The result can be incorrect/unpredictable.

#### Problem 2: `wait()`/`notify()` require the monitor

If you call:

```java
wait();
```

without owning that object's monitor, Java throws:

```text
IllegalMonitorStateException
```

So `wait()`/`notify()` are normally used inside synchronized code.

---

# The entire program in one mental model

```text
                 ONE Printer object
              ┌─────────────────────┐
              │     number           │
              │                     │
              │     LOCK            │
              └─────────┬───────────┘
                        │
                 only one at a time
                   /           \
                  /             \
             OddThread       EvenThread
                  │               │
                  │               │
             odd's turn?     even's turn?
                  │               │
                 YES             YES
                  │               │
                print           print
                  │               │
               number++        number++
                  │               │
               notify()        notify()
                  │               │
             loop again      loop again
                  │               │
             not my turn     not my turn
                  │               │
                wait()          wait()
                  │               │
             release lock    release lock
```

## If you remember only 6 lines

> **1. `start()` → starts a new thread.**
> **2. Same object → shared state and same monitor.**
> **3. `synchronized` → only one thread can own that object's lock at a time.**
> **4. `wait()` → pauses the thread AND releases the lock.**
> **5. `notify()` → wakes a waiting thread but does NOT release the lock.**
> **6. The woken thread gets the lock only after the current owner releases it.**

That's the foundation. Once these are clear, the rest of the code is mostly just applying those concepts to **"odd thread waits for odd numbers, even thread waits for even numbers."**
