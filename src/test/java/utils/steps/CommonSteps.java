package utils.steps;

import java.util.Random;

import java.text.*;
import java.util.Date;

public class CommonSteps {


    public static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static Boolean compareAscendingOrderOfDates(String firstDate, String secondDate) throws ParseException {
        Boolean orderOfDates = false;
        SimpleDateFormat sdformat = new SimpleDateFormat("MMM dd, yyyy");
        Date d1 = sdformat.parse(firstDate);
        Date d2 = sdformat.parse(secondDate);
//        System.out.println("The date 1 is: " + sdformat.format(d1));
//        System.out.println("The date 2 is: " + sdformat.format(d2));
        if(d1.compareTo(d2) < 0) {
            orderOfDates = true;
//            System.out.println("Date 1 occurs before Date 2");
        }

        return orderOfDates;
    }


    //    public void waitImplicit() {
//        LOGGER.debug("Start waiting 1 second, implicit wait");
//        //implicit
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        LOGGER.debug("Finished waiting 1 second");
//    }

}
