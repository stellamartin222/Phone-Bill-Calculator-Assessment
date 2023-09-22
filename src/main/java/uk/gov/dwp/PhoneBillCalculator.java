package uk.gov.dwp;

import java.util.ArrayList;

public class PhoneBillCalculator {

    private static final int LESS_THAN_FIVE_MINUTE_MODIFIER = 3;
    private static final int MORE_THAN_FIVE_MINUTE_MODIFIER = 150;
    private static final int FIVE_MINUTES_IN_SECONDS = 300;
    public int calculateBill(String input) {
        String[] phoneLogArr = input.split("/n");
        if (phoneLogArr.length == 1) {
            return 0;
        }

        ArrayList<String> callDurationList = new ArrayList<>();
        for(String log : phoneLogArr){
         callDurationList.add(log.substring(0, 8));
         }

        int longestCallRate = 0;
        int totalCallDurationLength = 0;
        for(String callLength : callDurationList){
            int callDuration = getCallDuration(callLength);
            int callRate = getCallRate(callDuration);
            if (longestCallRate == 0) {
                longestCallRate = callRate;
            }
            if (longestCallRate < callRate) {
                longestCallRate = callRate;
            }
            totalCallDurationLength+=callRate;
        }

        totalCallDurationLength -= longestCallRate;


        return totalCallDurationLength;
    }

    private int getCallDuration(String callDuration){

            String[] durationArray = callDuration.split(":");
            int hours = Integer.parseInt(durationArray[0]);
            int minutes = Integer.parseInt(durationArray[1]);
            int seconds = Integer.parseInt(durationArray[2]);

        return (hours * 3600) + (minutes * 60) + (seconds);
    }

    private int getCallRate(int callDuration){
        int callModifier;
        if(callDuration <= FIVE_MINUTES_IN_SECONDS){
            callModifier = LESS_THAN_FIVE_MINUTE_MODIFIER;
        } else{
            callModifier = MORE_THAN_FIVE_MINUTE_MODIFIER;
            callDuration = (callDuration/60) + 1;
        }
        System.out.print( callDuration + "  ");
        return callDuration * callModifier;
    }
}
