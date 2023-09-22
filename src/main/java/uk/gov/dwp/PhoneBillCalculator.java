package uk.gov.dwp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneBillCalculator {
    public int calculateBill(String input) {
        String[] phoneLogArr = input.split("/n");
        if (phoneLogArr.length == 1) {
            return 0;
        }

        ArrayList<String> callDurationList = new ArrayList<String>();
        for(String log : phoneLogArr){
         callDurationList.add(log.substring(0, 8));
         }

        int shortestCallDuration = 0;
        for(int i = 0;i < callDurationList.size(); i++){
            String[] durationArray = callDurationList.get(i).split(":");
            int time = Integer.parseInt(durationArray[2]);
            if(shortestCallDuration == 0){
                shortestCallDuration = time;
            }
            if (shortestCallDuration > time){
                shortestCallDuration = time;
            }
        }

        return shortestCallDuration * 3;
    }
}

//    PhoneCall(List<String> values) {
//        phoneNumber = values.get(1);
//        String[] durationArray = values.get(0).split(":");
//        hours = Integer.valueOf(durationArray[0]);
//        minutes = Integer.valueOf(durationArray[1]);
//        seconds = Integer.valueOf(durationArray[2]);
//        totalSeconds = (hours * 3600) + (minutes * 60) + (seconds);
//    }



// get the length of time for each
// split time?
// compare times

// calculate lowest cost based on cost per second
//return cost

    //int compareTimes = time1.compareTo(time2);