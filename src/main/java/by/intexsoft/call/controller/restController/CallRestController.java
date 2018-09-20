package by.intexsoft.call.controller.restController;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.service.CallService;
import by.intexsoft.call.service.SaveToFileService;
import by.intexsoft.call.util.DateConverter;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class controller listens to URL address of calls
 */
@RestController
@RequestMapping(value = "/rest/")
@AllArgsConstructor
public class CallRestController {
    private final CallService callService;
    private final SaveToFileService fileService;

    /**
     * @param data json data
     */
    @PostMapping(value = "calls")
    public void callInfo(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        String type = json.getString("type");
        int dataStart = DateConverter.stringToDate(json.getString("start"));
        int dataEnd = DateConverter.stringToDate(json.getString("end"));
        List<Call> calls = callService.getCallsPeriodTime(type, dataStart, dataEnd);
        fileService.saveToFile(calls, type);
    }
}