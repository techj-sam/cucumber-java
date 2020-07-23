package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertTrue;

public class DateTime {

    public static SimpleDateFormat MMDDFormat = new SimpleDateFormat("MM/dd/yyyy");
    public static SimpleDateFormat taskCompletedUKDateFormat = new SimpleDateFormat("dd MMM yyyy");
    public static SimpleDateFormat taskCompletedUSDateFormat = new SimpleDateFormat("MMM d, yyyy");
    public static SimpleDateFormat batchUploadDateFormat = new SimpleDateFormat("M/d/yyyy");
    public static SimpleDateFormat DDMMFormat = new SimpleDateFormat("dd/mm/yyyy");
    public static SimpleDateFormat DateAndTimeFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a");
    public static SimpleDateFormat TimeFormat = new SimpleDateFormat("hh:mm a");

    static TimeZone PSTTimezone = TimeZone.getTimeZone("PST");

    /**
     * Get Current PST Date in Month dd, yyyy format.
     *
     * @return
     */

    public String getCurrentTaskCompletedUKDateFormat() {
        taskCompletedUKDateFormat.setTimeZone(PSTTimezone);
        return taskCompletedUKDateFormat.format(new Date());
    }


    public String getDateinMMMDYYYYFormat(String date) throws ParseException {
        Date dateinDateFormat = DDMMFormat.parse(date);
        return taskCompletedUSDateFormat.format(dateinDateFormat);
    }


    public String getCurrentTaskCompletedUSDateFormat() {
        taskCompletedUSDateFormat.setTimeZone(PSTTimezone);
        return taskCompletedUSDateFormat.format(new Date());
    }

    public String getBatchUploadDateFormat() {
        batchUploadDateFormat.setTimeZone(PSTTimezone);
        return batchUploadDateFormat.format(new Date());
    }

    /**
     * Get Current Date PST date (MMDDFormat)
     *
     * @return
     */
    public String getCurrentPSTDate() {
        MMDDFormat.setTimeZone(PSTTimezone);
        return MMDDFormat.format(new Date());
    }

    public String getLastWeekDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -7);
        return MMDDFormat.format(cal.getTime());
    }

    public Date convertStringToDate(String date) throws ParseException {
        Date dateinDateFormat = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        return dateinDateFormat;
    }

    public boolean compareBatchUploadDateTime(String batchUploadStartDateTime,
                                              String batchUploadErrorLogDateTime) throws Exception {
        List<String> batchUploadStartDateTimeList = Arrays.asList(batchUploadStartDateTime.split("\\s"));
        List<String> batchUploadErrorLogDateTimeList = Arrays.asList(batchUploadErrorLogDateTime.split("\\s"));

        assertTrue("Date not matches.", batchUploadStartDateTimeList.get(0).equals(batchUploadErrorLogDateTimeList.get(0)));
        List<String> batchUploadStartTimeList = Arrays.asList(batchUploadStartDateTimeList.get(1).split(":"));
        List<String> batchUploadErrorLogTimeList = Arrays.asList(batchUploadErrorLogDateTimeList.get(1).split(":"));

        for (int i = 0; i < batchUploadStartTimeList.size(); i++)
            if (Integer.parseInt(batchUploadStartTimeList.get(i)) <
                    Integer.parseInt(batchUploadErrorLogTimeList.get(i)))
                return true;

            else if (Integer.parseInt(batchUploadStartTimeList.get(i)) ==
                    Integer.parseInt(batchUploadErrorLogTimeList.get(i)) &&
                    Integer.parseInt(batchUploadStartTimeList.get(i + 1)) <
                            Integer.parseInt(batchUploadErrorLogTimeList.get(i + 1)))
                return true;

            else if (Integer.parseInt(batchUploadStartTimeList.get(i)) ==
                    Integer.parseInt(batchUploadErrorLogTimeList.get(i)) &&
                    Integer.parseInt(batchUploadStartTimeList.get(i + 1)) ==
                            Integer.parseInt(batchUploadErrorLogTimeList.get(i + 1)) &&
                    Integer.parseInt(batchUploadStartTimeList.get(i + 2)) <
                            Integer.parseInt(batchUploadErrorLogTimeList.get(i + 2)))
                return true;
        return false;
    }
}