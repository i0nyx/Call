package by.intexsoft.call.service.impl;

import by.intexsoft.call.repositories.CallRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Matchers.anyList;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class CallServiceImplTest {
    private CallServiceImpl callService;
    private CallRepository callRepository;

    @Before
    public void setUp() {
        callRepository = mock(CallRepository.class);
        callService = new CallServiceImpl(callRepository);
    }

    @Test
    public void loadObjectByTime() {
        callService.loadObjectByTime(new Date(), new Date());
        when(callRepository.findAllByPeriod(new Date(), new Date())).thenReturn(anyList());

    }

    @Test
    public void getType() {
        callService.getType();
    }
}