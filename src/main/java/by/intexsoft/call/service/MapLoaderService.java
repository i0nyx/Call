package by.intexsoft.call.service;

import by.intexsoft.call.pojo.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

/**
 * Creates a {@link java.util.HashMap} object in the constructor and loads all types of services
 * and describes a method that returns a list of objects by type for a certain period of time.
 */
@Service
public class MapLoaderService {
    private final Map<Type, ConvertService> map;

    /**
     * Create object of {@link java.util.HashMap} and loads all types of services
     *
     * @param converters list of all types of services
     */
    @Autowired
    public MapLoaderService(List<ConvertService> converters) {
        map = newHashMap();
        converters.forEach(converter -> map.put(converter.getType(), converter));
    }

    /**
     * Method return list objects of specific type
     *
     * @param type  type of service
     * @param start initial value
     * @param end   end value
     * @param <T>   type of service
     * @return {@link List<T>}
     */
    public <T> List<T> getService(Type type, Date start, Date end) {
        ConvertService converter = map.get(type);
        return converter.loadObjectByTime(start, end);
    }

}
