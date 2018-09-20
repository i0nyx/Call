package by.intexsoft.call.service;

import by.intexsoft.call.pojo.Sms;

import java.util.Date;
import java.util.List;

/**
 * Description of methods for working with sms
 */
public interface SmsService {
    /**
     * Method of return a list of sms for a period time
     *
     * @param type  type of object
     * @param start initial value
     * @param end   final value
     * @return {@link List<Sms>}
     */
    List<Sms> getSmsPeriodTime(String type, Date start, Date end);
}
