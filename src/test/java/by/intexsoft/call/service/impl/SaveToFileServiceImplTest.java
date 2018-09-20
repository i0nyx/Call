package by.intexsoft.call.service.impl;

import by.intexsoft.call.service.SaveToFileService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SaveToFileService.class, LoggerFactory.class})
public class SaveToFileServiceImplTest {
    private SaveToFileService fileService;

    @Before
    public void setUp(){
        fileService = new SaveToFileServiceImpl();
    }

    @Test(expected = IOException.class)
    public void saveToFile() throws IOException {
        List<Object> list = new ArrayList<>();
        String type = "call";
        fileService.saveToFile(list, type);
        FileWriter writer = mock(FileWriter.class);
        doThrow(new IOException()).when(writer).close();
        writer.close();
    }
}