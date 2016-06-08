package name.pju.roman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Number {
//    enum Numeral { i, v, x, l, c, d, m, V, X, L, C, D, M;
//        public boolean isMultiple() {
//            return this.ordinal() % 2 == 0;
//        }
//        public Numeral getSubtractor() {
//            if (this == i) return null;
//            return Numeral.values()[ordinal() - (2 - ordinal() % 2)];
//        }
//        public int getMaxinstances() { return isMultiple() ? 5 : 1; }
//    }

    private final List<Numeral> value;
    private void normalize() {
        Collections.sort(value);

    }

    public Number(String v) {
        value = new ArrayList<>();
        for (int i = 0; i < v.length(); i++) {
            value.add(Numeral.valueOf(v.substring(i, i)));
        }
        normalize();
    }
    @Override
    public String toString() {
        return value.stream().map(n -> n.name()).collect(Collectors.joining());
    }


}
