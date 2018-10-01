package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.service.SaveToFileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SaveToFileService.class, LoggerFactory.class})
public class SaveToFileServiceImplTest {
    private SaveToFileService fileService;
    private List<Call> lists;

    @Before
    public void setUp() {
        fileService = new SaveToFileServiceImpl();
        lists = new ArrayList<>();
        lists.add(buildCall());
    }

    @Test
    public void saveToFile() throws Exception {
        fileService.saveToFile(lists, buildRequestObject());
        FileWriter writer = mock(FileWriter.class);
        whenNew(FileWriter.class).withArguments(new File(anyString())).thenReturn(null);
        verify(writer);
    }

    private Call buildCall() {
        return Call.builder().uuid(UUID.randomUUID()).date(new Date()).build();
    }
    private RequestObject buildRequestObject(){
        return RequestObject.builder().type("call").build();
    }
}
