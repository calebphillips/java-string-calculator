package caleb.stringcalculator;

import java.util.LinkedList;
import java.util.List;

public class StringCalculator {
    private final String string;

    public StringCalculator(String string) {this.string = string;}

    public Integer add() {
        if ("".equals(string))
            return 0;

        int sum = 0;
        List<Integer> numbers = toNumbers(string);
        for (Integer num : numbers) {
            sum += num;
        }

        return sum;
    }
    
    private static final List<Integer> toNumbers(String s) {
        List<Integer> list = new LinkedList<Integer>();
        for (String num : s.split(",")) {
            list.add(Integer.parseInt(num));
        }

        return list;
    }

}
