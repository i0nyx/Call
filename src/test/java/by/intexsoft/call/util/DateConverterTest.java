package by.intexsoft.call.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/*
@RunWith(PowerMockRunner.class)
@PrepareForTest({DateConverter.class, LoggerFactory.class})
public class DateConverterTest {
    private SimpleDateFormat dateFormat;

    @Before
    public void setUp() {
        dateFormat = mock(SimpleDateFormat.class);
    }

    @Test
    public void stringToDate() throws ParseException {
        String dateStr = "2018-09-18 04:28:25";
        Date date = new Date();
        DateConverter.stringToDate(dateStr);
        when(dateFormat.parse(anyString())).thenReturn(date);
        verify(dateFormat);
    }

    @Test
    public void failConvert() {
        mockStatic(LoggerFactory.class);
        Logger log = mock(Logger.class);
        when(LoggerFactory.getLogger(DateConverter.class)).thenReturn(log);
        DateConverter.stringToDate(anyString());
        verify(log);
    }
}*/
