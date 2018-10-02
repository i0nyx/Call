package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.service.ConvertService;
import by.intexsoft.call.service.LoaderService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
public class LoadServiceImplTest {
    private LoaderService loadService;
    private List<ConvertService> converters;


    @Before
    public void setUp() {
        converters = new ArrayList<>();
        CallConvertServiceImpl callConvertService = mock(CallConvertServiceImpl.class);
        converters.add(callConvertService);
    }

    @Test
    public void load() {
        loadService = new LoadServiceImpl(converters);
        RequestObject requestObject = new RequestObject();
        loadService.load(requestObject);
        verify(loadService, times(1)).getType(any());
    }

    @Test
    public void getType() {

    }
}