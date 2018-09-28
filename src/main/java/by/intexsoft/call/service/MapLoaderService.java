package by.intexsoft.call.service;

import by.intexsoft.call.pojo.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

@Service
public class MapLoaderService {
    private Map<Type, ConvertService> map;

    @Autowired
    public MapLoaderService(List<ConvertService> converters) {
        map = newHashMap();
        converters.forEach(converter -> map.put(converter.getType(), converter));
    }

    public <T> List<T> getService(Type type, Date start, Date end){
        ConvertService converter = map.get(type);
        return converter.loadByTime(start, end);
    }

}
