package by.intexsoft.call.util;

import java.util.Date;

/**
 *
 */
public final class GenerateMessage {
    /**
     * @param startDate
     * @param endDate
     * @param size
     * @return
     */
    public static String createMessage(Date startDate, Date endDate, int size) {
        StringBuilder sb = new StringBuilder();
        sb.append("за период с ");
        sb.append(startDate);
        sb.append(" по ");
        sb.append(endDate);
        sb.append(" : ");
        sb.append(size);
        sb.append(" - обьекта(ов)");
        return sb.toString();
    }
}
