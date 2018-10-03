package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.repositories.CallRepository;
import by.intexsoft.call.service.ConvertService;
import by.intexsoft.call.service.LoaderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.*;

import static by.intexsoft.call.pojo.type.Type.CALL;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * This test checks the class performance {@link LoadServiceImpl}
 */
@RunWith(PowerMockRunner.class)
public class LoadServiceImplTest {
    private List<ConvertService> converters;
    private ConvertService callConvertService;

    /**
     * Setting initial parameters
     */
    @Before
    public void setUp() {
        CallRepository repository = mock(CallRepository.class);
        converters = new ArrayList<>();
        callConvertService = new CallConvertServiceImpl(repository);
        converters.add(callConvertService);
    }

    /**
     * Check of return types when loading data from the DB
     */
    @Test
    public void load() {
        LoaderService loadService = new LoadServiceImpl(converters);
        loadService.load(buildRequestObject());
        assertEquals(loadService.getType("call"), CALL);
        Map<Type, ConvertService> map = new HashMap<>();
        map.put(CALL, callConvertService);
        assertEquals(map.get(CALL), callConvertService);
        when(callConvertService.loadObjectByTime(buildRequestObject())).thenReturn(new ArrayList());
    }

    /**
     * Return type check
     */
    @Test
    public void getType() {
        assertEquals(Type.valueOf("call".toUpperCase()), CALL);
    }

    private RequestObject buildRequestObject() {
        return RequestObject.builder().type("call").startDate(new Date()).endDate(new Date()).build();
    }
}