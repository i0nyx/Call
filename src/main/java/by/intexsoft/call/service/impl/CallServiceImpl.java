package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.repositories.CallRepository;
import by.intexsoft.call.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<Call> getCallsPeriodTime(String type, int start, int end) {
        List<Call> result = null;
        if (type.equalsIgnoreCase("call")) {
            List<Call> lists = callRepository.findAll();
            result = lists.stream().
                    filter(c -> ((c.getDate().getTime() / 1000)) >= start && ((c.getDate().getTime() / 1000)) <= end).
                    collect(Collectors.toList());
        }
        return result.size() > 0 ? result : null;
    }
}
