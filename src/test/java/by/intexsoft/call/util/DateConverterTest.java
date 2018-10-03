package by.intexsoft.call.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({DateConverter.class, LoggerFactory.class})
public class DateConverterTest {
    @Mock
    private SimpleDateFormat dateFormat;

    @Test
    public void stringToDate() throws ParseException {
        String dateStr = "2018-09-18 04:28:25";
        Date date = new Date();
        DateConverter.stringToDate(dateStr);
        when(dateFormat.parse(dateStr)).thenReturn(date);
        verify(dateFormat);
    }

    @Test(expected = ParseException.class)
    public void failConvert() throws ParseException {
        String dateStr = "2018-09-18 04:28:25";
        mockStatic(LoggerFactory.class);
        Logger log = mock(Logger.class);
        doThrow(new ParseException("error", 1))
                .when(dateFormat)
                .parse(any());
        dateFormat.parse(dateStr);
        when(LoggerFactory.getLogger(DateConverter.class)).thenReturn(log);
        verify(log).error("error");
    }
}
