package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.repositories.MmsRepository;
import by.intexsoft.call.service.MmsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if (type.equalsIgnoreCase("mms")) {
            List<Mms> lists = mmsRepository.findAll();
            result = lists.stream().
                    filter(c -> (c.getDate().getTime() / 1000) >= start && (c.getDate().getTime() / 1000) <= end).
                    collect(Collectors.toList());
        }
        return result;
    }
}
