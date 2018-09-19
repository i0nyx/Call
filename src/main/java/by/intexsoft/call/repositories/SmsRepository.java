package by.intexsoft.call.repositories;

import by.intexsoft.call.pojo.Sms;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface uses methods inherited from the class {@link CassandraRepository}.
 */
@Repository
public interface SmsRepository extends CassandraRepository<Sms, Integer> {
}
