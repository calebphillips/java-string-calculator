package caleb.stringcalculator;

import java.nio.channels.Channel;
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

        return addTheNumbers();
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
