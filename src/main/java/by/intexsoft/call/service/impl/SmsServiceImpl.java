package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Sms;
import by.intexsoft.call.repositories.SmsRepository;
import by.intexsoft.call.service.SmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class SmsServiceImpl implements SmsService {
    private final SmsRepository smsRepository;

    @Override
    public List<Sms> getSmsPeriodTime(String type, int start, int end) {
        List<Sms> result = new ArrayList<>();
        if (type.equalsIgnoreCase("sms")) {
            List<Sms> lists = smsRepository.findAll();
            for (Sms s : lists) {
                int currentTime = (int) (s.getDate().getTime() / 1000);
                if (currentTime >= start && currentTime <= end) {
                    result.add(s);
                }
            }
        }
        return result;
    }
}
