package uk.gov.dwp;

public class PhoneBillCalculator {
    public int calculateBill(String input) {
        String[] inputArr = input.split("/n");
            if (inputArr.length == 1){
                return 0;
            }
        return 3;
    }
}
