package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.pojo.RequestObject;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.repositories.CallRepository;
import by.intexsoft.call.service.ConvertService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static by.intexsoft.call.pojo.type.Type.CALL;

/**
 * {@inheritDoc}
 */
@Service
@AllArgsConstructor
public class CallConvertServiceImpl implements ConvertService<Call> {
    private CallRepository callRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Call> loadObjectByTime(final RequestObject requestObject) {
        Date startDate = requestObject.getStartDate();
        Date endDate = requestObject.getEndDate();
        return callRepository.findAllByPeriod(startDate, endDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType() {
        return CALL;
    }
}
