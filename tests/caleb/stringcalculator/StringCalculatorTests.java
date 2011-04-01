package caleb.stringcalculator;

import com.sun.tools.corba.se.idl.constExpr.Equal;
import org.junit.Test;

import java.util.AbstractCollection;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTests {
    @Test public void returnsZeroForTheEmptyString() {
        assertThat(new StringCalculator("").add(), is(equalTo(0)));
    }
    
    @Test public void returnsTheNumberWhenTheStringConsistsOfASingleNumber() {
        assertThat(new StringCalculator("5").add(), is(equalTo(5)));
        assertThat(new StringCalculator("27").add(), is(equalTo(27)));
    }

    @Test public void returnsTheSumeWhenTheStringContainsTwoNumber() {
        assertThat(new StringCalculator("1,2").add(), is(equalTo(3)));
        assertThat(new StringCalculator("5,7").add(), is(equalTo(12)));
    }

    @Test public void returnsTheSumWhenTheStringContainsMoreThanTwoNumbers() {
        assertThat(new StringCalculator("1,2,3").add(), is(equalTo(6)));
        assertThat(new StringCalculator(oneHundredTwenties()).add(), is(equalTo(2000)));
    }

    @Test public void allowsTheNewlineAsADelimiter() {
        assertThat(new StringCalculator("1\n2\n3").add(), is(equalTo(6)));
        assertThat(new StringCalculator("4\n6,13").add(), is(equalTo(23)));
    }

    @Test public void allowsCustomDelimiters() {
        assertThat(new StringCalculator("//;\n5;2;3").add(), is(equalTo(10)));
        assertThat(new StringCalculator("//x\n6x3x10x23").add(), is(equalTo(42)));
    }

    private String oneHundredTwenties() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i<100; i++) {
            sb.append("20,");
        }

        return sb.append("20").toString();
    }
}
