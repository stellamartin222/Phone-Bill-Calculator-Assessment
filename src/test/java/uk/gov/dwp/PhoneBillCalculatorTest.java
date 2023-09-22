package uk.gov.dwp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBillCalculatorTest {
    @Test
    @DisplayName("Given one call should return zero")
    public void GivenOneCallWillReturnZero(){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill("00:01:07,400-234-090");
        assertEquals(0, result, "should return 0 when given one call");
    }
}
