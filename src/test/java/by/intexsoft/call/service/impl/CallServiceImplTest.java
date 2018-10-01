package by.intexsoft.call.service.impl;

import by.intexsoft.call.repositories.CallRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

/*
@RunWith(PowerMockRunner.class)
@PrepareForTest({CallService.class})
public class CallServiceImplTest {
    private CallRepository callRepository;
    private CallService callService;

    @Before
    public void setUp(){
        callRepository = mock(CallRepository.class);
        callService = new CallServiceImpl(callRepository);
    }
    @Test
    public void testGetCalls(){
        String type = "call";
        Date date = mock(Date.class);
        callService.loadCallByTime(type, date, date);
        verify(callRepository).findAllByPeriod(any(), any());
    }
}*/
