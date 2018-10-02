package by.intexsoft.call.service.impl;

import by.intexsoft.call.pojo.Mms;
import by.intexsoft.call.pojo.type.Type;
import by.intexsoft.call.repositories.MmsRepository;
import by.intexsoft.call.service.ConvertService;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class MmsServiceImplTest {
    private ConvertService service;
    private MmsRepository mmsRepository;

    @Before
    public void setUp() {
        mmsRepository = mock(MmsRepository.class);
        service = new MmsServiceImpl(mmsRepository);
    }

    @Test
    public void loadObjectByTime() {
        Date date = convertStringToDate("2018-09-01 04:27:25");
        List<Mms> listsMms = new ArrayList<>();
        listsMms.add(buildMms());
        service.loadObjectByTime(date, date);
        when(mmsRepository.findAllByPeriod(date, date)).thenReturn(listsMms);
        verify(mmsRepository).findAllByPeriod(date, date);
    }

    @Test
    public void getType() {
    }

    private Mms buildMms(){
        return Mms.builder().type(Type.MMS).date(new Date()).uuid(UUID.randomUUID()).build();
    }
    private Date convertStringToDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date result = null;
        try {
            result = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}