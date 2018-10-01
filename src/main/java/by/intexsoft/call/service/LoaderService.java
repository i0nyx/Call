package by.intexsoft.call.service;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.type.Type;

import java.util.List;

/**
 * Describes methods for working with returning a type and loading objects by type
 * @param <T> type of service
 */
public interface LoaderService<T> {
    /**
     * Method returns a list of objects by type
     * @param requestObject object with initial parameters
     * @return {@link List<T>}
     * @see #getType(String)
     */
    List<T> load(RequestObject requestObject);

    /**
     * The method converts a string value to a {@link Type}.
     * @param type type as string
     * @return {@link Type}
     */
    Type getType(String type);
}
