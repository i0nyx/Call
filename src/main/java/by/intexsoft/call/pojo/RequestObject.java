package by.intexsoft.call.pojo;

import lombok.*;

import java.util.Date;

/**
 * Class of RequestObject with property type, startDate, endDate
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestObject {
    private String type;
    private Date startDate;
    private Date endDate;
}
