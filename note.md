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

