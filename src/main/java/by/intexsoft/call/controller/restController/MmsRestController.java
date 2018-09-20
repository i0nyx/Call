package by.intexsoft.call.controller.restController;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.service.MessageService;
import by.intexsoft.call.service.MmsService;
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

import static by.intexsoft.call.constant.RabbitMqConstant.MMS;

@RestController
@RequestMapping(value = "/rest/")
@AllArgsConstructor
@Slf4j
public class MmsRestController {
    public final MmsService mmsService;
    public final SaveToFileService fileService;
    public final MessageService messageService;

    @PostMapping(value = "mms")
    public void mmsInfo(@RequestBody String data) {
        JSONObject json = new JSONObject(data);
        String type = json.getString("type");
        Date startDate = DateConverter.stringToDate(json.getString("start"));
        Date endDate = DateConverter.stringToDate(json.getString("end"));
        List<Mms> mmsList = mmsService.getMmsPeriodTime(type, startDate, endDate);
        fileService.saveToFile(mmsList, type);
        String message = GenerateMessage.createMessage(startDate, endDate, mmsList.size());
        messageService.sendMessageToQueue(MMS, message);
    }
}
