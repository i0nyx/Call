package by.intexsoft.call.service;

import by.intexsoft.call.pojo.Mms;

import java.util.Date;
import java.util.List;

/**
 * Description of methods for working with mms
 */
public interface MmsService extends ConvertService{
    /**
     * Method of return a list of mms for a period time
     *
     * @param type  type of object
     * @param start initial value
     * @param end   final value
     * @return {@link List<Mms>}
     */
    List<Mms> getMmsPeriodTime(String type, Date start, Date end);
}
