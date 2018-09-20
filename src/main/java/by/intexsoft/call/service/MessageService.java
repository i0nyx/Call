package by.intexsoft.call.service;

/**
 * Describes the method of sending messages to the queue
 */
public interface MessageService {
    /**
     * method send message in queue
     *
     * @param key     routin key
     * @param message string data
     */
    void sendMessageToQueue(String key, String message);
}
