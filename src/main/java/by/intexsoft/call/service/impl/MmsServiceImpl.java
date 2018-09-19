package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.repositories.MmsRepository;
import by.intexsoft.call.service.MmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Service
@AllArgsConstructor
@Slf4j
public class MmsServiceImpl implements MmsService {
    private final MmsRepository mmsRepository;
    @Override
    public List<Mms> getMmsPeriodTime(String type, int start, int end) {
        List<Mms> result = new ArrayList<>();
        if(type.equalsIgnoreCase("mms")){
            List<Mms> lists = mmsRepository.findAll();
            for(Mms c : lists){
                int currentTime = (int) (c.getDate().getTime() / 1000);
                if(currentTime>=start && currentTime<=end){
                    result.add(c);
                }
            }
        }
        return result;
    }
}
