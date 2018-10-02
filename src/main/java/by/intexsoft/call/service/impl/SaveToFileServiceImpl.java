package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.service.SaveToFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@Slf4j
public class SaveToFileServiceImpl implements SaveToFileService {
    /**
     * {@inheritDoc}
     */
    @Override
    public void saveToFile(final List data, final RequestObject requestObject) {
        try (FileWriter writer = new FileWriter("D://" + requestObject.getType() + ".txt")) {
            for (Object object : data) {
                writer.write(String.valueOf(object) + "\r\n");
            }
            log.info("file save success");
        } catch (IOException e) {
            log.error("can't write file " + e);
        }
    }
}
