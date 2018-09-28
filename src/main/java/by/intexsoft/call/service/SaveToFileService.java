package by.intexsoft.call.service;

import by.intexsoft.call.pojo.RequestObject;

import java.util.List;

/**
 * Service for work with files
 */
public interface SaveToFileService {
    /**
     * Method writing data in file and save on file system
     *
     * @param data saving object
     * @param requestObject
     * @param <T>  type object
     */
    <T> void saveToFile(List<T> data, RequestObject requestObject);
}
