package by.intexsoft.call.controller.restController;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.service.CallService;
import by.intexsoft.call.service.MessageService;
import by.intexsoft.call.service.SaveToFileService;
import by.intexsoft.call.util.DateConverter;
import by.intexsoft.call.util.GenerateMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static by.intexsoft.call.constant.RabbitMqConstant.CALL;

/**
 * Class controller listens to URL address of rest/calls
 */
@RestController
@RequestMapping(value = "/rest/")
@AllArgsConstructor
@Slf4j
public class CallRestController {
    private final CallService callService;
    private final SaveToFileService fileService;
    private final MessageService messageService;

    /**
     * The method converts the received data. Gets a list of calls for a certain period of time.
     * Saves the resulting list to a file and sends the statistics to the queue
     *
     * @param data json data
     * @see #callService
     * @see #fileService
     * @see #messageService
     */
    @PostMapping(value = "calls")
    public void callInfo(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        String type = json.getString("type");
        Date startDate = DateConverter.stringToDate(json.getString("start"));
        Date endDate = DateConverter.stringToDate(json.getString("end"));
        List<Call> calls = callService.getCallsPeriodTime(type, startDate, endDate);
        fileService.saveToFile(calls, type);
        String message = GenerateMessage.createMessage(startDate, endDate, calls.size());
        messageService.sendMessageToQueue(CALL, message);
    }
}