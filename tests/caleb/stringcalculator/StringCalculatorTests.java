package caleb.stringcalculator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorTests {
    @Test
    public void returnsZeroForTheEmptyString() {
        assertThat(StringCalculator.add(""), is(equalTo(0)));
    }
    
    @Test
    public void returnsTheNumberWhenTheStringConsistsOfASingleNumber() {
        assertThat(StringCalculator.add("5"), is(equalTo(5)));
        assertThat(StringCalculator.add("27"), is(equalTo(27)));
    }

    @Test public void returnsTheSumeWhenTheStringContainsTwoNumber() {
        assertThat(StringCalculator.add("1,2"), is(equalTo(3)));
        assertThat(StringCalculator.add("5,7"), is(equalTo(12)));
    }

    @Test public void returnsTheSumWhenTheStringContainsThreeNumbers() {
        assertThat(StringCalculator.add("1,2,3"), is(equalTo(6)));
    }

}
