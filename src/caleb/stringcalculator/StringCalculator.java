package caleb.stringcalculator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {
    private final String string;

    public StringCalculator(String string) {
        this.string = string;
    }

    public Integer add() {
        if ("".equals(string))
            return 0;

        throwIfNegatives();

        return addTheNumbers();
    }

    private void throwIfNegatives() {
        List<Integer> negatives = filterForNegativeNumbers();

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(formatExceptionMessage(negatives));
        }
    }

    private static String formatExceptionMessage(List<Integer> negatives) {
        StringBuilder sb = new StringBuilder("Negatives not allowed: ");

        for (Iterator<Integer> itr = negatives.iterator(); itr.hasNext();) {
            sb.append(itr.next());

            if (itr.hasNext()) sb.append(", ");
        }

        return sb.toString();
    }

    private List<Integer> filterForNegativeNumbers() {
        List<Integer> negatives = new LinkedList<Integer>();
        for (Integer num : toNumbers()) {
            if (num < 0) {
                negatives.add(num);
            }
        }
        return negatives;
    }

    private int addTheNumbers() {
        int sum = 0;
        for (Integer num : toNumbers()) {
            sum += num;
        }
        return sum;
    }

    private final List<Integer> toNumbers() {
        List<Integer> list = new LinkedList<Integer>();
        for (String num : string.replace("\n", delimiter()).split(delimiter())) {
            list.add(toInt(num));
        }

        return list;
    }

    private String delimiter() {
        return hasCustomDelimiter() ? customDelimiter() : ",";
    }

    private String customDelimiter() {
        return string.substring(2, 3);
    }

    private boolean hasCustomDelimiter() {
        return string.startsWith("//");
    }

    private static final Integer toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
