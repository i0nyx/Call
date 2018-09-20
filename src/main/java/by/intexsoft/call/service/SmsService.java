package by.intexsoft.call.service;

import by.intexsoft.call.pojo.Sms;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface SmsService {
    /**
     *
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<Sms> getSmsPeriodTime(String type, Date start, Date end);
}
