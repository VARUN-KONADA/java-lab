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

