package by.intexsoft.call.service;

import java.util.List;

public interface SaveToFileService {
    <T> void saveToFile(List<T> data, String type);
}
