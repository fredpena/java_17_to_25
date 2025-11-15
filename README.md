# Java 17–25 Features Demo

This project contains **one small example per feature** mentioned in the talk:

- Sealed Classes
- Records
- Pattern Matching for `switch`
- Foreign Function & Memory API
- Vector API (Incubator)
- Structured Concurrency
- Record Patterns
- Virtual Threads
- Scoped Values (a.k.a. Stable Values in early previews)
- Sequenced Collections
- Generational ZGC (GC config example)
- String Templates (Preview)
- Unnamed Patterns and Variables
- Unnamed Classes and Instance Main Methods (Preview)
- Statements before `super(...)` (Preview)
- Stream Gatherers
- Class-File API (Preview)
- Primitive Types in Patterns, `instanceof`, and `switch`
- Module Import Declarations (Preview)

> ⚠️ **Important**
>
> - Some examples use **preview** or **incubator** features.
> - You must compile and run with the right JDK version and `--enable-preview`
    >   (and sometimes add incubator modules on the command line).
> - Not all files will compile on the same JDK or without extra flags.
>
> This repository is meant as **didactic material** for the talk
> *"A Journey from Java 17 to 25: Nine Versions, One Purpose"*.

## Build

This is a simple Maven project skeleton. You can also just open it in IntelliJ IDEA / VS Code and
run individual examples, adjusting the language level per file.

```bash
mvn -q -DskipTests package
```

Then run individual classes with a JDK that supports the feature.
