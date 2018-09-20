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
     *
     * @param start
     * @param end
     * @return
     */
    @Query("select * from call where date>=?0 and date<=?1 allow filtering")
    List<Call> findAllPeriodTime(Date start, Date end);
}
