package by.intexsoft.call.service;

/**
 *
 */
public interface MessageService {
    /**
     * @param message
     */
    void sendMessageToQueue(String key, String message);
}
