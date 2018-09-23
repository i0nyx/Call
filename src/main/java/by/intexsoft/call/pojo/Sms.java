package by.intexsoft.call.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Class of sms with property uuid, date
 */
@Table
@Data
@NoArgsConstructor
public class Sms {
    @PrimaryKey
    private UUID uuid;
    private Date date;
    private Type type;
}
