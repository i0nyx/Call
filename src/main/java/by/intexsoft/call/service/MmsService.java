package by.intexsoft.call.service;

import by.intexsoft.call.pojo.Mms;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface MmsService {

    /**
     * @param type
     * @param start
     * @param end
     * @return
     */
    List<Mms> getMmsPeriodTime(String type, Date start, Date end);
}
