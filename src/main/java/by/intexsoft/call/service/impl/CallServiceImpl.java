package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
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
public class CallServiceImpl implements ConvertService<Call> {
    private CallRepository callRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Call> loadObjectByTime(Date start, Date end) {
        return callRepository.findAllByPeriod(start, end);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Type getType() {
        return CALL;
    }
}
