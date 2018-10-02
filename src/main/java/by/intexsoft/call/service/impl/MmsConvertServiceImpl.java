package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.pojo.RequestObject;
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
public class MmsConvertServiceImpl implements ConvertService<Mms> {
    private final MmsRepository mmsRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Mms> loadObjectByTime(final RequestObject requestObject) {
        Date startDate = requestObject.getStartDate();
        Date endDate = requestObject.getEndDate();
        return mmsRepository.findAllByPeriod(startDate, endDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType() {
        return MMS;
    }
}
