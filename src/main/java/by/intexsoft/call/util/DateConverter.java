package by.intexsoft.call.util;

import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
@Slf4j
public final class DateConverter {

    public static int stringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        int epoch = 0;
        try {
            Date parseDate = dateFormat.parse(date);
            epoch = (int) (parseDate.getTime() / 1000);
        } catch (ParseException e) {
            log.error("cant convert time " + e);
        }
        return epoch;
    }


}
