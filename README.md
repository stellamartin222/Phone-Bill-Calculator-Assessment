# Phone Bill Calculator ##

## Exercise 1 ##

This is an assessed exercise. You have from 10am to 3pm on the day to complete
your submission.

The submission will be in the form a git repository, zipped and forwarded or a
shared link to your online repository. Once sent no further submission will be
accepted. Any commits after the time the submission is made will be ignored.

You submission will be scored against the points you have covered in the week's
lessons and katas.

## Introduction ##

The phone bill calculator is a slightly more advanced kata. Not only are the
requirements not cleanly stated but the required solution takes a little more
thought.

* The calculator accepts a list of phone call durations,
* each against a specific phone number.
* The output is the total charge including a discount for the phone number
* with the total longest call duration

## Requirements ##

Phone logs are given as a string S consisting of N lines separated by newline
characters.

Each line describes one phone call using thee following format:

`hh:mm:ss,nnn-nnn-nnn[,r]`, where `hh:mm:ss` denotes the duration of the call (in
"hh" hours, "mm" minutes and "ss" seconds), `nnn-nnn-nnn` denotes the
nine-digit phone number of the recipient (with no leading zeros) and `r` represents
an optional billing rate identifier. The billing rate identifier will always be a
positive integer when provided.

Each call is billed separately. The default billing rules are as follows:

* If the call was up to 5 minutes, then you pay 3 cents for every second of the call (e.g. for duration "00:01:07" you pay 67 * 3 = 201 cents).
* If the call was at over 5 minutes then you pay 150 cents per every minute
  started (e.g. for duration "00:05:01" you pay 6 * 150 = 900 cents).
* All calls to the phone number with the longest total call duration are free
* If two calls to different phone numbers tie on duration then the numerically smallest phone number wins).

Write a function named calculateBill that, given a string describing phone call
logs, returns the amount of money you have to pay in cents.

For example, given string S with N = 3 lines:
```
00:01:07,400-234-090
00:05:01,701-080-080
00:05:00,400-234-090
```
The function should return 900 (the total duration for number 400-234-090 is
6 minutes 7 seconds, and the total duration for number 701-080-080 is 5 minutes
1 second; therefore, the free promotion applies to the former phone number).

Where a billing rate is provided the calculator must make a call to a rate
manager API (see below). The API requires the rateId as input and returns a
set of values that override the default. The values are returned as a simple
data object with fields as follows:

* perSecondRate
* perMinuteTime
* perMinuteRate

perSecondRate changes how much is charged per second (default is 3 cents)

perMinuteTime is the changeover duration of the call (in minutes) at which
it swaps from per second billing to per minute (default is 5 minutes)

perMinuteRate changes how much is charged per minute (default is 150 cents)

The rule for identifying free calls cannot be modified.

Assume that:
* N is an integer within the range [1..100];
* every phone number follows the format "hh:mm:ss" strictly
  (00 <= hh <= 99, 00 <= mm, ss <= 59);
* each line follows the format "hh:mm:ss,nnn-nnn-nnn" strictly; there are no
  empty lines or spaces.

## Rate Manager API ##

The rate manager API is access via an object instance injected into the
phone bill calculator when it is instantiated and forms part of the
class constructor method parameters.

The API has an interface type of ChargeRateInterface.

The API only has a single method that the phone bill calculator has any
interaction with: `getRate(rateId)`. The getRate method returns a RateData
object with four fields of interest:

```
{
  int rateId
  int perSecondRate
  int perMinuteTime
  int perMinuteRate
}
```

If the requested rateId is not recognised the method returns a null value.

### Sample Java Definition ###

**Charge Rate Interface**:

```Java
package uk.gov.dwp.phonebilling.rate_management;

interface ChargeRateInterface {
  RateData getRate(rateId);
}
```

**Rate Data Class**:

```Java
package uk.gov.dwp.phonebilling.rate_management;

public class RateData {
  private int rateId;
  private int perSecondRate;
  private int perMinuteTime;
  private int perMinuteRate;

  public int getRateId() {
    return this.rateId;
  }
  public int getPerSecondRate() {
    return this.perSecondRate;
  }
  public int getPerMinuteRate() {
    return this.perMinuteRate;
  }
  public int getPerMinuteTime() {
    return this.perMinuteTime;
  }
}
```
