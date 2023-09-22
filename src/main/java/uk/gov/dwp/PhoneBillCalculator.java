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

        int callDuration = callDurationCalculator(callDurationList);

        return callDuration * 3;
    }

    private int callDurationCalculator(ArrayList<String> callDurationList){
        int shortestCallDuration = 0;
        for (String callLength : callDurationList) {
            String[] durationArray = callLength.split(":");
            int hours = Integer.parseInt(durationArray[0]);
            int minutes = Integer.parseInt(durationArray[1]);
            int seconds = Integer.parseInt(durationArray[2]);
            int totalSeconds = (hours * 3600) + (minutes * 60) + (seconds);

            if (shortestCallDuration == 0) {
                shortestCallDuration = totalSeconds;
            }
            if (shortestCallDuration > totalSeconds) {
                shortestCallDuration = totalSeconds;
            }
        }
        return shortestCallDuration;
    }
}

// get the length of time for each
// split time?
// compare times

// calculate lowest cost based on cost per second
//return cost

    //int compareTimes = time1.compareTo(time2);