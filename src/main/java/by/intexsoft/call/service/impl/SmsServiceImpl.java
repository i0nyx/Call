package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Sms;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.repositories.SmsRepository;
import by.intexsoft.call.service.ConvertService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static by.intexsoft.call.pojo.type.Type.SMS;

/**
 * {@inheritDoc}
 */
@Service
@AllArgsConstructor
public class SmsServiceImpl implements ConvertService<Sms> {
    private final SmsRepository smsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Sms> loadObjectByTime(Date start, Date end) {
        return smsRepository.findAllByPeriod(start, end);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType() {
        return SMS;
    }
}
