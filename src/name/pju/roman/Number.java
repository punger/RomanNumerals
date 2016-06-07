package name.pju.roman;

import java.util.List;

/**
 * Created by paul on 6/4/2016.
 */
public class Number {

    private List<Numeral> value;
    public boolean isValid() {
        Numeral level = Numeral.highest();
        Numeral last = null;
        boolean exactlyOne = false;
        for (Numeral n : value) {
            if (n == last) {
                if (!n.isAllowMultiple()) return false;
                exactlyOne = false;
            } else if (last != null) {
                if (last.compareTo(n) > 0) {
                    continue;
                } else if (last.equals(n.getSubtractor())) {

                } else return false;
            }
            last = n;
        }
    }
}
