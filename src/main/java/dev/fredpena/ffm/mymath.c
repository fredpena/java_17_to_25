// mymath.c
//Linux => gcc -fPIC -shared -o mymath.so mymath.c
//Mac => gcc -fPIC -shared -o mymath.dylib mymath.c
//Windows (MinGW) => gcc -shared -o mymath.dll mymath.c

#include <stdio.h>

int add(int a, int b) {
    int result = a + b;
    printf("[C] add(%d, %d) = %d\n", a, b, result);
    return result;
}
