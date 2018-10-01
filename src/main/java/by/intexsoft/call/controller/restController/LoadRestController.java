package by.intexsoft.call.controller.restController;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.ResponseObject;
import by.intexsoft.call.service.LoaderService;
import by.intexsoft.call.service.MessageService;
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
 * Class controller listens to URL address of rest/calls
 */
@RestController
@RequestMapping(value = "/rest/")
@AllArgsConstructor
public class LoadRestController {
    private final SaveToFileService fileService;
    private final MessageService messageService;
    private final LoaderService loaderService;

    /**
     * The method converts the received data. Gets a list of calls for a certain period of time.
     * Saves the resulting list to a file and sends the statistics to the queue
     *
     * @param request json data
     * @see #fileService
     * @see #messageService
     */
    @PostMapping(value = "calls")
    public void requestCall(@RequestBody String request) {
        RequestObject requestObject = buildRequestObject(request);
        List<?> listObjects = loaderService.load(requestObject);
        fileService.saveToFile(listObjects, requestObject);
        ResponseObject a = buildResponseObject(requestObject, listObjects.size());
        messageService.sendMessageToQueue(requestObject, a.toString());
    }

    private RequestObject buildRequestObject(String data){
        JSONObject json = new JSONObject(data);
        return RequestObject.builder().type(json.getString("type"))
                .startDate(DateConverter.stringToDate(json.getString("start")))
                .endDate(DateConverter.stringToDate(json.getString("end")))
                .build();
    }

    private ResponseObject buildResponseObject(RequestObject requestObject, int size){
        return ResponseObject.builder().startDate(requestObject.getStartDate())
                .type(requestObject.getType())
                .endDate(requestObject.getEndDate())
                .size(size)
                .build();
    }



}