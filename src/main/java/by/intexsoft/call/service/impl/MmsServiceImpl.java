package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.repositories.MmsRepository;
import by.intexsoft.call.service.MmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@AllArgsConstructor
@Slf4j
public class MmsServiceImpl implements MmsService {
    private final MmsRepository mmsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mms> getMmsPeriodTime(String type, Date start, Date end) {
        List<Mms> result = null;
        if (type.equalsIgnoreCase("mms")) {
            result = mmsRepository.findAllPeriodTime(start, end);
        }
        return result;
    }
}
