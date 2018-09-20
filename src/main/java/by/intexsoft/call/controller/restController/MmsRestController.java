package by.intexsoft.call.controller.restController;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.service.MmsService;
import by.intexsoft.call.service.SaveToFileService;
import by.intexsoft.call.util.DateConverter;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/")
@AllArgsConstructor
public class MmsRestController {
    public final MmsService mmsService;
    public final SaveToFileService fileService;

    @PostMapping(value = "mms")
    public void mmsInfo(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        String type = json.getString("type");
        int dataStart = DateConverter.stringToDate(json.getString("start"));
        int dataEnd = DateConverter.stringToDate(json.getString("end"));
        List<Mms> calls = mmsService.getMmsPeriodTime(type, dataStart, dataEnd);
        fileService.saveToFile(calls, type);
    }
}
