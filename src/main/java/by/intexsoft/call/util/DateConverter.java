package by.intexsoft.call.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class utility for working with dates
 */
@Slf4j
public final class DateConverter {
    /**
     * Method convert string in date
     *
     * @param date date in format string
     * @return {@link Date}
     * @throws ParseException if it is not possible to convert
     */
    public static Date stringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date result = null;
        try {
            result = dateFormat.parse(date);
        } catch (ParseException e) {
            log.error("can't convert time " + e);
        }
        return result;
    }
}
