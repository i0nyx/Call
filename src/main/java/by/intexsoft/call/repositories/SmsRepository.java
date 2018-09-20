package by.intexsoft.call.repositories;

import by.intexsoft.call.pojo.Sms;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * This interface uses methods inherited from the class {@link CassandraRepository}.
 */
@Repository
public interface SmsRepository extends CassandraRepository<Sms, Integer> {

    @Query("select * from sms where date>=?0 and date<=?1 allow filtering")
    List<Sms> findAllPeriodTime(Date start, Date end);
}
