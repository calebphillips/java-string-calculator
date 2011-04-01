package caleb.stringcalculator;

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
        List<Integer> negatives = negatives();

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException(formatExceptionMessage(negatives));
        }
    }

    private String formatExceptionMessage(List<Integer> negatives) {
        StringBuilder sb = new StringBuilder("Negatives not allowed: ");
        for (int i=0; i<negatives.size()-1; i++) {
            sb.append(negatives.get(i)).append(", ");
        }
        sb.append(negatives.get(negatives().size() - 1));

        return sb.toString();
    }

    private List<Integer> negatives() {
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
        String withDelimitersReplaced = string.replace("\n", delimiter());

        List<Integer> list = new LinkedList<Integer>();
        for (String num : withDelimitersReplaced.split(delimiter())) {
            list.add(toInt(num));
        }

        return list;
    }

    private String delimiter() {
        if (string.startsWith("//")) {
            return string.substring(2, 3);
        }

        return ",";
    }

    private static final Integer toInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return 0;
        }
    }
}
