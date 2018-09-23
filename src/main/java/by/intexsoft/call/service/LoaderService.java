package by.intexsoft.call.service;

import by.intexsoft.call.pojo.Type;

import java.util.Date;
import java.util.List;

public interface LoaderService<T> {
    List<T> load(String type, Date start, Date end);
    Type getType(String type);
}
