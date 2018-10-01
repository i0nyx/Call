package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.repositories.MmsRepository;
import by.intexsoft.call.service.ConvertService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static by.intexsoft.call.pojo.type.Type.MMS;

/**
 * {@inheritDoc}
 */
@Service
@AllArgsConstructor
@Slf4j
public class MmsServiceImpl implements ConvertService {
    private final MmsRepository mmsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mms> loadObjectByTime(Date start, Date end) {
        return mmsRepository.findAllByPeriod(start, end);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType() {
        return MMS;
    }
}
