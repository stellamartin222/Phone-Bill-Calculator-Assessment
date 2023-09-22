package uk.gov.dwp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    @DisplayName("Given two calls, returns the value when the lowest call is 1 second")
    public void givenTwoReturnLowestWhenOneSecond(){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill("00:00:01,123-456-789/n00:01:07,400-234-090");
        assertEquals(3, result, "Should return the shortest call is 1 second");
    }

    @ParameterizedTest
    @CsvSource({"'00:00:15,123-456-789/n00:01:07,400-234-090', 45", "'00:02:33,123-456-789/n00:01:07,400-234-090', 201"})
    @DisplayName("Given two calls, returns the value when the lowest call is les than 5 minutes")
    public void givenTwoReturnLowest(String input, int expected){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill(input);
        assertEquals(expected,result, "Should return the shortest call when less than 5 minutes");
    }

    @Test
    @DisplayName("Given three calls, less than 5 minutes in length made by seperate callers returns total")
    public void givenThreeReturnTotal(){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill("00:00:15,123-456-789/n00:01:07,400-234-090/n00:00:20,123-456-745");
        assertEquals(105, result, "should return the total of 3 seperate calls");
    }

    @Test
    @DisplayName("Given 2 calls over 5 minutes in length, return correct cost")
    public void givenTwoOverFiveMinutesReturnCost(){
        PhoneBillCalculator phoneBillCalculator = new PhoneBillCalculator();
        int result = phoneBillCalculator.calculateBill("00:05:01,123-456-789/n00:07:03,400-234-090");
        assertEquals(900, result, "Should return the correct total when the charged call if over five minutes");
    }
}
