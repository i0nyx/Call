package by.intexsoft.call.service;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.type.Type;

import java.util.List;

/**
 * Describes methods that return a list of objects by specific parameters
 * and a method that returns a specific type.
 */
public interface ConvertService<T> {
    /**
     * Returns a list of all objects for a specific period of time.
     *
     * @param requestObject object with request info for loading data from DB
     * @return {@link List<T>}
     */
    List<T> loadObjectByTime(RequestObject requestObject);

    /**
     * Returns a specific type of service.
     *
     * @return {@link Type}
     */
    Type getType();
}
