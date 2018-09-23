package by.intexsoft.call.service;

import java.util.Date;
import java.util.List;

public interface ConvertService {
    <T> List<T> loadByTime(Date start, Date end);
}
