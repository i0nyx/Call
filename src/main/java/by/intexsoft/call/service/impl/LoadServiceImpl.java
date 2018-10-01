package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.service.ConvertService;
import by.intexsoft.call.service.LoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

/**
 * {@inheritDoc}
 */
@Service
public class LoadServiceImpl<T> implements LoaderService<T> {
    private final Map<Type, ConvertService> map;

    /**
     * Create object of {@link java.util.HashMap} and loads all types of services
     *
     * @param converters list of all types of services
     */
    @Autowired
    public LoadServiceImpl(List<ConvertService> converters) {
        map = newHashMap();
        converters.forEach(converter -> map.put(converter.getType(), converter));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List load(RequestObject requestObject) {
        Type type = getType(requestObject.getType());
        return map.get(type).loadObjectByTime(requestObject.getStartDate(), requestObject.getEndDate());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType(String typeStr) {
        return Type.valueOf(typeStr.toUpperCase());
    }
}
