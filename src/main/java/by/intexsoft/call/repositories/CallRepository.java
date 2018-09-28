package by.intexsoft.call.repositories;

import by.intexsoft.call.pojo.Call;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * This interface uses methods inherited from the class {@link CassandraRepository}.
 */
@Repository
public interface CallRepository extends CassandraRepository<Call, Integer> {
    /**
     * Method returns a list of calls for a period of time
     *
     * @param start initial value
     * @param end   final value
     * @return {@link List<Call>}
     */
    @Query("select * from call where date>=?0 and date<=?1 allow filtering")
    List<Call> findAllByPeriod(Date start, Date end);
}
