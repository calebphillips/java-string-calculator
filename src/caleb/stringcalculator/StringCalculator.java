package caleb.stringcalculator;

import java.util.LinkedList;
import java.util.List;

public class StringCalculator {
    private final String string;

    public StringCalculator(String string) {this.string = string;}

    public Integer add() {
        if ("".equals(string))
            return 0;

        int value = 0;
        List<Integer> numbers = toNumbers(string);
        for (Integer i : numbers) {
            value += i;
        }

        return value;
    }
    
    private static final List<Integer> toNumbers(String s) {
        List<Integer> list = new LinkedList<Integer>();
        for (String num : s.split(",")) {
            list.add(toInt(num));
        }

        return list;
    }

    private static final Integer toInt(String s) {
        return Integer.parseInt(s);
    }
}
