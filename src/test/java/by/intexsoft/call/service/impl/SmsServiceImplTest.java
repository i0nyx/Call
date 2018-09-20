package by.intexsoft.call.service.impl;

import by.intexsoft.call.repositories.SmsRepository;
import by.intexsoft.call.service.SmsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SmsService.class})
public class SmsServiceImplTest {
    private SmsService smsService;
    private SmsRepository smsRepository;

    @Before
    public void setUp(){
        smsRepository = mock(SmsRepository.class);
        smsService = new SmsServiceImpl(smsRepository);
    }

    @Test
    public void testGetSms(){
        String type = "sms";
        Date date = mock(Date.class);
        smsService.getSmsPeriodTime(type, date, date);
        verify(smsRepository).findAllPeriodTime(any(), any());
    }
}