package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.repositories.MmsRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

import static by.intexsoft.call.pojo.type.Type.MMS;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

/**
 * This test checks the class performance {@link MmsConvertServiceImpl}
 */
@RunWith(PowerMockRunner.class)
public class MmsConvertServiceImplTest {
    @Mock
    private MmsRepository mmsRepository;
    @InjectMocks
    private MmsConvertServiceImpl service;

    /**
     * Check the receipt of a list of data from the database
     */
    @Test
    public void loadObjectByTime() {
        RequestObject requestObject = mock(RequestObject.class);
        service.loadObjectByTime(requestObject);
        verify(mmsRepository, times(1)).findAllByPeriod(any(), any());
    }

    /**
     * Return type equivalence checking
     */
    @Test
    public void getType() {
        assertEquals(service.getType(), MMS);
    }
}