package by.intexsoft.call.pojo;

import lombok.Builder;
import lombok.Setter;

import java.util.Date;

/**
 * Class of ResponseObject with property startDate, endDate, size
 */
@Setter
@Builder
public class ResponseObject {
    private String type;
    private Date startDate;
    private Date endDate;
    private int size;

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "" + type + "за период с " + startDate + " по " + endDate + " : " + size + " - обьекта(ов)";
    }
}