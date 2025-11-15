

// Requires: --add-modules jdk.incubator.vector
// java --enable-preview --add-modules jdk.incubator.vector VectorApiExample.java

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;


private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

void main() {
    int[] a = {1, 2, 3, 4};
    int[] b = {10, 20, 30, 40};
    int[] c = new int[a.length];

    int i = 0;
    int upperBound = SPECIES.loopBound(a.length);
    for (; i < upperBound; i += SPECIES.length()) {
        var va = IntVector.fromArray(SPECIES, a, i);
        var vb = IntVector.fromArray(SPECIES, b, i);
        var vc = va.add(vb);
        vc.intoArray(c, i);
    }
    // tail
    for (; i < a.length; i++) {
        c[i] = a[i] + b[i];
    }

    for (int v : c) {
        IO.println(v);
    }
}
