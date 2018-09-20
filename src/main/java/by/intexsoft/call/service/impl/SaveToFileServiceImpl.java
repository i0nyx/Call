package by.intexsoft.call.service.impl;

import by.intexsoft.call.service.SaveToFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public <T> void saveToFile(List<T> data, String type) {
        Optional.ofNullable(data).orElseThrow(NullPointerException::new);
        try (FileWriter writer = new FileWriter("D://" + type + ".txt")) {
            for (T t : data) {
                writer.write(String.valueOf(t) + "\r\n");
            }
        } catch (IOException e) {
            log.error("can't write file " + e);
        }
    }
}
