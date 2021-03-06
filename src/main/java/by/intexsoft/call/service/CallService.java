package by.intexsoft.call.service;

import by.intexsoft.call.pojo.Call;

import java.util.List;

/**
 * Description of methods for working with calls
 */
public interface CallService {
    /**
     * Method of returning a list of calls for a period of time
     *
     * @param type  type of object
     * @param start beginning of period
     * @param end   end of period
     * @return {@list List<Call>}
     */
    List<Call> getCallsPeriodTime(String type, int start, int end);
}
