package by.intexsoft.call.service.impl;

import by.intexsoft.call.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;

/*
@RunWith(PowerMockRunner.class)
@PrepareForTest({MessageService.class})
public class MessageServiceImplTest {
    private MessageService messageService;
    private RabbitTemplate template;

    @Before
    public void setUp(){
        template = mock(RabbitTemplate.class);
        messageService = new MessageServiceImpl(template);
    }

    @Test
    public void testSendMessageToQueue(){
        String type = "call";
        String message = "test message";
        messageService.sendMessageToQueue(type, message);
        verify(template).convertAndSend(anyString(), (Object) any());
    }

}*/
