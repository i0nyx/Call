package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.service.LoaderService;
import by.intexsoft.call.service.MapLoaderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@AllArgsConstructor
public class LoadServiceImpl<T> implements LoaderService<T> {
    private final MapLoaderService mapLoaderService;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> load(RequestObject requestObject) {
        Type type = getType(requestObject.getType());
        return mapLoaderService.getService(type, requestObject.getStartDate(), requestObject.getEndDate());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType(String typeStr) {
        return Type.valueOf(typeStr.toUpperCase());
    }
}
