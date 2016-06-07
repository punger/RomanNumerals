package name.pju.roman;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * Created by paul on 6/4/2016.
 */
public enum Numeral {
    i(1, null, true), v(5, i, false), x(10, i, true), l(50, x, false),
    c(100, x, true), d(500, c, false), m(1000, c, true), V(5000, m, false),
    X(10000, m, true), L(50000, X, false), C(100000, X, true),
    D(500000, C, false), M(1000000, C, false);

    private static final int MAXMULTIPLE = 4;

    public boolean isAllowMultiple() {
        return allowMultiple;
    }

    public int maxAllowed() {
        if (!isAllowMultiple()) return 1;
        return MAXMULTIPLE;
    }
    public Numeral[] getMultiple() {
        Numeral [] mult = new Numeral[maxAllowed()];
        Arrays.fill(mult, this);
        return mult;
    }

    private final Numeral subtractor;
    private final boolean allowMultiple;
    private final int value;

    Numeral(int value, Numeral subtractor, boolean allowMultiple) {
        this.subtractor = subtractor;
        this.allowMultiple = allowMultiple;
        this.value = value;
    }

    @Nullable
    public static Numeral get(String source) {
        try {
            return valueOf(source);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static void main(String args[]) {
        Numeral abc = Numeral.d;
        abc = Numeral.m;
    }

    public Numeral getSubtractor() {
        return subtractor;
    }

    public int getValue() {
        return value;
    }

    public static Numeral highest() {
        return values()[values().length -1];
    }

    public static Numeral fromInt(int target) {
        return i;
    }
}
