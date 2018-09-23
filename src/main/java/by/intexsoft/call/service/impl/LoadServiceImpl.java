package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Type;
import by.intexsoft.call.service.LoaderService;
import by.intexsoft.call.service.MapLoaderService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoadServiceImpl<T> implements LoaderService<T> {
    public MapLoaderService mapLoaderService;

    @Override
    public List<T> load(String typeStr, Date start, Date end) {
        Type type = getType(typeStr);
        return mapLoaderService.get(type, start, end);
    }

    @Override
    public Type getType(String type) {
        return Type.valueOf(type);
    }
}
