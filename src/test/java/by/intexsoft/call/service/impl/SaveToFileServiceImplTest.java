package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.service.SaveToFileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * This test checks the class performance {@link SaveToFileServiceImpl}
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({SaveToFileService.class, LoggerFactory.class})
public class SaveToFileServiceImplTest {
    private SaveToFileService fileService;
    private List<Call> lists;

    /**
     * Setting the initial parameters
     */
    @Before
    public void setUp() {
        fileService = new SaveToFileServiceImpl();
        lists = new ArrayList<>();
        lists.add(buildCall());
    }

    /**
     * Verification of the recording and saving the file
     *
     * @throws Exception IOException Exception thrown when writing file
     */
    @Test
    public void saveToFile() throws Exception {
        FileWriter writer = mock(FileWriter.class);
        whenNew(FileWriter.class).withArguments(new File(anyString())).thenReturn(null);
        verify(writer);
        fileService.saveToFile(lists, buildRequestObject());
    }

    /**
     * Testing the operation of the method when an exception occurs
     *
     * @throws IOException Exception thrown when writing file
     */
    @Test(expected = IOException.class)
    public void failedSaveToFile() throws IOException {
        FileWriter writer = mock(FileWriter.class);
        mockStatic(LoggerFactory.class);
        Logger log = mock(Logger.class);
        doThrow(new IOException("error"))
                .when(writer)
                .write(anyString());
        writer.write("test");
        when(LoggerFactory.getLogger(SaveToFileServiceImpl.class)).thenReturn(log);
        verify(log).error("error");
    }

    private Call buildCall() {
        return Call.builder().uuid(UUID.randomUUID()).date(new Date()).build();
    }

    private RequestObject buildRequestObject() {
        return RequestObject.builder().type("call").build();
    }
}
