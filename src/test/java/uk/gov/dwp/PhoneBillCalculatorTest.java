package uk.gov.dwp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBillCalculatorTest {
    @Test
    @DisplayName("Given one call should return zero")
    public void givenOneReturnZero(){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill("00:01:07,400-234-090");
        assertEquals(0, result, "should return 0 when given one call");
    }

    @Test
    @DisplayName("Given two calls, the shortest call being 3 seconds return the rate")
    public void givenTwoReturnLowest(){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill("00:00:01,123-456-789/n00:01:07,400-234-090");
        assertEquals(3, result, "Should return 3 when shortest call is 1 second");
    }
}
