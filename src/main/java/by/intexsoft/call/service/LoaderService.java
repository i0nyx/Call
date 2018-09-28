package by.intexsoft.call.service;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.type.Type;

import java.util.List;

public interface LoaderService<T> {
    List<T> load(RequestObject requestObject);

    Type getType(String type);
}
