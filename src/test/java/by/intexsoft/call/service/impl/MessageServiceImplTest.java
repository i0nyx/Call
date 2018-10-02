package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * This test checks the class performance {@link MessageServiceImpl}
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MessageService.class, LoggerFactory.class})
public class MessageServiceImplTest {
    private RabbitTemplate template;
    private MessageService messageService;

    /**
     * Initialization of initial parameters
     */
    @Before
    public void setUp() {
        template = mock(RabbitTemplate.class);
        messageService = new MessageServiceImpl(template);
    }

    /**
     * Check sending message
     */
    @Test
    public void testSendMessageToQueue() {
        mockStatic(LoggerFactory.class);
        Logger log = mock(Logger.class);
        messageService.sendMessageToQueue(new RequestObject(), "message");
        verify(template).convertAndSend(any(), (Object) any());
        when(LoggerFactory.getLogger(MessageServiceImpl.class)).thenReturn(log);
        verify(log);
    }
}
