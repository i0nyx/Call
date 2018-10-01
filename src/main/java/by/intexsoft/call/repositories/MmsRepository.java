package by.intexsoft.call.repositories;

import by.intexsoft.call.pojo.Mms;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * This interface uses methods inherited from the class {@link CassandraRepository}.
 */
@Repository
public interface MmsRepository extends CassandraRepository<Mms, Integer> {
    /**
     * Method returns a list of mms for a period of time
     *
     * @param start initial value
     * @param end   final value
     * @return {@link List<Mms>}
     */
    @Query("select * from mms where date>=?0 and date<=?1 allow filtering")
    List<Mms> findAllByPeriod(Date start, Date end);
}
