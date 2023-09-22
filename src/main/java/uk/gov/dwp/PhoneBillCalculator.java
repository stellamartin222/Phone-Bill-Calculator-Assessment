package uk.gov.dwp;

import java.util.ArrayList;

public class PhoneBillCalculator {
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
            int callDuration = callDurationCalculator(callLength);
            int callRate = rateModifierCalculator(callDuration);
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

    private int callDurationCalculator(String callDuration){

            String[] durationArray = callDuration.split(":");
            int hours = Integer.parseInt(durationArray[0]);
            int minutes = Integer.parseInt(durationArray[1]);
            int seconds = Integer.parseInt(durationArray[2]);
            int totalSeconds = (hours * 3600) + (minutes * 60) + (seconds);

        return totalSeconds;
    }

    private int rateModifierCalculator(int callDuration){
        int callModifier = 0;
        if(callDuration <= 300){
            callModifier = 3;
        } else{
            callModifier = 150;
            callDuration = (callDuration/60) + 1;
        }
        System.out.print( callDuration + "  ");
        return callDuration * callModifier;
    }
}

// get the length of time for each
// split time?
// compare times

// calculate lowest cost based on cost per second
//return cost
