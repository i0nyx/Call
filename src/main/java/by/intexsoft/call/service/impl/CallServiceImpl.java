package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Call;
import by.intexsoft.call.repositories.CallRepository;
import by.intexsoft.call.service.CallService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<Call> result = new ArrayList<>();
        if(type.equalsIgnoreCase("call")){
            List<Call> lists = callRepository.findAll();
            for(Call c : lists){
                int currentTime = (int) (c.getDate().getTime() / 1000);
                if(currentTime>=start && currentTime<=end){
                    result.add(c);
                }
            }
        }
        return result;
    }
}
