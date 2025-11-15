// ForeignFunctionMemoryExample.java

// El Foreign Function & Memory API es final desde Java 22, pero sigue marcado como restricted: necesitas permitir acceso nativo con un flag de VM.
//
//Sin compilar a class explícito:
//java --enable-native-access=ALL-UNNAMED ForeignFunctionMemoryExample.java
//
//Compilar y luego ejecutar
//javac --release 25 ForeignFunctionMemoryExample.java
//java --enable-native-access=ALL-UNNAMED ForeignFunctionMemoryExample
//
//El flag --enable-native-access=ALL-UNNAMED permite que el código no modular (tu archivo suelto) use APIs restringidas como SymbolLookup.libraryLookup y downcallHandle.

import static java.lang.foreign.ValueLayout.JAVA_INT;

// Linker nativo para el ABI de la plataforma
Linker linker = Linker.nativeLinker();

        void main() throws Throwable {
            // Arena controla la vida de los objetos nativos
            try (Arena arena = Arena.ofConfined()) {
                // Usa la ruta de la librería (relativa o absoluta)
                Path libPath = Path.of("mymath.dylib"); // o la ruta absoluta si quieres
                IO.println("Cargando librería desde: " + libPath.toAbsolutePath());

                SymbolLookup myMathLib = SymbolLookup.libraryLookup(libPath, arena);

                // 2. Buscar la dirección de la función C: int add(int, int)
                MemorySegment addAddr = myMathLib.find("add")
                        .orElseThrow(() -> new UnsatisfiedLinkError("No se encontró 'add' en mymath"));

                // 3. Describir la firma de la función C:
                //    int add(int, int)
                FunctionDescriptor addDesc = FunctionDescriptor.of(
                        JAVA_INT, // return
                        JAVA_INT, // arg 1
                        JAVA_INT  // arg 2
                );

                // 4. Crear el MethodHandle para hacer el "downcall"
                MethodHandle addHandle = linker.downcallHandle(addAddr, addDesc);

                int a = 10;
                int b = 32;

                // 5. Invocar la función C como si fuera Java
                int result = (int) addHandle.invokeExact(a, b);

                IO.println("[Java] " + a + " + " + b + " = " + result);
            }
        }
