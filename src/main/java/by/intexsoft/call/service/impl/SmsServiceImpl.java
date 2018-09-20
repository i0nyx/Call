package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Sms;
import by.intexsoft.call.repositories.SmsRepository;
import by.intexsoft.call.service.SmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static by.intexsoft.call.constant.RabbitMqConstant.SMS;

/**
 * {@inheritDoc}
 */
@Service
@AllArgsConstructor
@Slf4j
public class SmsServiceImpl implements SmsService {
    private final SmsRepository smsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sms> getSmsPeriodTime(String type, Date start, Date end) {
        List<Sms> result = null;
        if (type.equalsIgnoreCase(SMS)) {
            result = smsRepository.findAllPeriodTime(start, end);
        }
        return result;
    }
}
