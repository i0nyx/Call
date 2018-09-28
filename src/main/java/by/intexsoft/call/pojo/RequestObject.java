package by.intexsoft.call.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 *
 */
@Setter
@Getter
@Builder
public class RequestObject {
    private String type;
    private Date startDate;
    private Date endDate;
}
