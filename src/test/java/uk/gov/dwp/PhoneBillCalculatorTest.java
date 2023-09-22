package uk.gov.dwp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PhoneBillCalculatorTest {
    @Test
    @DisplayName("Given one call of one second with no rate identifier will return 3")
    public void GivenOneCallWillReturnValue(){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill();
    }
}
