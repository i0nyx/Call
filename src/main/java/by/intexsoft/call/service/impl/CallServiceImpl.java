package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.repositories.CallRepository;
import by.intexsoft.call.service.CallService;
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
public class CallServiceImpl implements CallService {
    private CallRepository callRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Call> loadCallByTime(String type, Date start, Date end) {
        List<Call> result = null;
        if (type.equalsIgnoreCase(getType().toString())) {
            result = callRepository.findAllByPeriod(start, end);
        }
        return result;
    }

    @Override
    public List<Call> loadByTime(Date start, Date end) {
        return callRepository.findAllByPeriod(start, end);
    }

    @Override
    public Type getType() {
        return CALL;
    }
}
