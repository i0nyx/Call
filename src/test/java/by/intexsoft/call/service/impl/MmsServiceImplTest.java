package by.intexsoft.call.service.impl;

import by.intexsoft.call.repositories.MmsRepository;
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
@PrepareForTest({MmsService.class})
public class MmsServiceImplTest {
    private MmsService mmsService;
    private MmsRepository mmsRepository;

    @Before
    public void setUp(){
        mmsRepository = mock(MmsRepository.class);
        mmsService = new MmsServiceImpl(mmsRepository);
    }

    @Test
    public void testGetMms(){
        String type = "mms";
        Date date = mock(Date.class);
        mmsService.getMmsPeriodTime(type, date, date);
        verify(mmsRepository).findAllByPeriod(any(), any());
    }
}*/
