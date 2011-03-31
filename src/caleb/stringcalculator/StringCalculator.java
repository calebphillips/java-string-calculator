package caleb.stringcalculator;

import java.util.LinkedList;
import java.util.List;

public class StringCalculator {
    public static Integer add(String s) {
        if ("".equals(s))
            return 0;

        int value = 0;
        List<Integer> numbers = toNumbers(s);
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
