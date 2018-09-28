package by.intexsoft.call.service;

import by.intexsoft.call.pojo.RequestObject;

/**
 * Describes the method of sending messages to the queue
 */
public interface MessageService {
    /**
     * method send message in queue
     *
     * @param requestObject
     * @param message string data
     */
    void sendMessageToQueue(RequestObject requestObject, String message);
}
