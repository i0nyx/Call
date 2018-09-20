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

import java.util.Date;
import java.util.List;

import static by.intexsoft.call.constant.RabbitMqConstant.SMS;

/**
 * Class controller listens to URL address of rest/sms
 */
@RestController
@RequestMapping(value = "/rest/")
@AllArgsConstructor
public class SmsRestController {
    private final SmsService smsService;
    private final SaveToFileService fileService;
    private final MessageService messageService;

    /**
     * The method converts the received data. Gets a list of sms for a certain period of time.
     * Saves the resulting list to a file and sends the statistics to the queue
     *
     * @param data json data
     * @see #smsService
     * @see #fileService
     * @see #messageService
     */
    @PostMapping(value = "sms")
    public void smsInfo(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        String type = json.getString("type");
        Date startDate = DateConverter.stringToDate(json.getString("start"));
        Date endDate = DateConverter.stringToDate(json.getString("end"));
        List<Sms> smsList = smsService.getSmsPeriodTime(type, startDate, endDate);
        fileService.saveToFile(smsList, type);
        String message = GenerateMessage.createMessage(startDate, endDate, smsList.size());
        messageService.sendMessageToQueue(SMS, message);
    }
}
