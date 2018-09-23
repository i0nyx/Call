package by.intexsoft.call.service;

import by.intexsoft.call.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.intexsoft.call.pojo.Type.*;

@Service
public class MapLoaderService {
    private Map<Type, ConvertService> map;

    @Autowired
    public MapLoaderService(CallService callService,
                            SmsService smsService,
                            MmsService mmsService) {
        map = new HashMap<Type, ConvertService>() {{
            map.put(CALL, callService);
            map.put(SMS, smsService);
            map.put(MMS, mmsService);
        }};
    }

    public <T> List<T> get(Type type, Date start, Date end){
        ConvertService converter = map.get(type);
        return converter.loadByTime(start, end);
    }

}
