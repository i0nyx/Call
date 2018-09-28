package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Type;
import by.intexsoft.call.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class LoadServiceImpl<T> implements LoaderService<T> {
    private final MapLoaderService mapLoaderService;

    @Override
    public List<T> load(String typeStr, Date start, Date end) {
        Type type = getType(typeStr);
        return mapLoaderService.getService(type, start, end);
    }
    @Override
    public Type getType(String type) {
        return Type.valueOf(type.toUpperCase());
    }
}
