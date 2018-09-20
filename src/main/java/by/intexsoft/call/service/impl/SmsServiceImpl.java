package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Sms;
import by.intexsoft.call.repositories.SmsRepository;
import by.intexsoft.call.service.SmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class SmsServiceImpl implements SmsService {
    private final SmsRepository smsRepository;

    @Override
    public List<Sms> getSmsPeriodTime(String type, Date start, Date end) {
        List<Sms> result = null;
        if (type.equalsIgnoreCase("sms")) {
            result = smsRepository.findAllPeriodTime(start, end);
        }
        return result;
    }
}
