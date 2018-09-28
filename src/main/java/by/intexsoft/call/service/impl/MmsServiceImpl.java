package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.pojo.type.Type;
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
        if (type.equalsIgnoreCase(getType().toString())) {
            result = mmsRepository.findAllPeriodTime(start, end);
        }
        return result;
    }

    @Override
    public List<Mms> loadByTime(Date start, Date end) {
        return mmsRepository.findAllPeriodTime(start, end);
    }

    @Override
    public Type getType() {
        return Type.MMS;
    }
}
