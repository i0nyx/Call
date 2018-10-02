package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.repositories.CallRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static by.intexsoft.call.pojo.type.Type.CALL;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
public class CallServiceImplTest {
    @Mock
    private CallRepository callRepository;
    @InjectMocks
    private CallConvertServiceImpl callService;

    @Test
    public void loadObjectByTime() {
        RequestObject requestObject = mock(RequestObject.class);
        callService.loadObjectByTime(requestObject);
        verify(callRepository, times(1)).findAllByPeriod(any(), any());
    }

    @Test
    public void getType() {
        assertEquals(callService.getType(), CALL);
    }
}