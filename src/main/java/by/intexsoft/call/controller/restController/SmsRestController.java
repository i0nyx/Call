package by.intexsoft.call.controller.restController;

import by.intexsoft.call.pojo.Sms;
import by.intexsoft.call.service.MessageService;
import by.intexsoft.call.service.SaveToFileService;
import by.intexsoft.call.service.SmsService;
import by.intexsoft.call.util.DateConverter;
import by.intexsoft.call.util.GenerateMessage;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static by.intexsoft.call.constant.RabbitMqConstant.SMS;

@RestController
@RequestMapping(value = "/rest/")
@AllArgsConstructor
public class SmsRestController {
    private final SmsService smsService;
    private final SaveToFileService fileService;
    private final MessageService messageService;

    @PostMapping(value = "sms")
    public void smsInfo(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        String type = json.getString("type");
        int dataStart = DateConverter.stringToDate(json.getString("start"));
        int dataEnd = DateConverter.stringToDate(json.getString("end"));
        List<Sms> smsList = smsService.getSmsPeriodTime(type, dataStart, dataEnd);
        fileService.saveToFile(smsList, type);
        String message = GenerateMessage.createMessage(json.getString("start"), json.getString("end"), smsList.size());
        messageService.sendMessageToQueue(SMS, message);
    }
}
