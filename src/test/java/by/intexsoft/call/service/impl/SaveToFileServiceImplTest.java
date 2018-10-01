package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/*@RunWith(PowerMockRunner.class)
@PrepareForTest({SaveToFileService.class, LoggerFactory.class})
public class SaveToFileServiceImplTest {
    private SaveToFileService fileService;
    private List<Call> lists;
    private String type;

    @Before
    public void setUp() {
        fileService = new SaveToFileServiceImpl();
        lists = new ArrayList<>();
        lists.add(buildCall());
        type = "call";
    }

    @Test
    public void saveToFile() throws Exception {

        fileService.saveToFile(lists, type);
        mock(FileWriter.class);
        whenNew(FileWriter.class).withArguments(new File("test.txt")).thenReturn(null);
    }

    @Test
    public void failSaveToFile() {
        mockStatic(LoggerFactory.class);
        Logger log = mock(Logger.class);
        when(LoggerFactory.getLogger(SaveToFileServiceImpl.class)).thenReturn(log);
        fileService.saveToFile(lists, type);
        verify(log);
    }*/

/*
    private Call buildCall() {
        return Call.builder().uuid(UUID.randomUUID()).date(new Date()).build();
    }
}*/
