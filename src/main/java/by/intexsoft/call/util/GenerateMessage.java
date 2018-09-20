package by.intexsoft.call.util;

import java.util.Date;

/**
 * Utility class for working with messages
 */
public final class GenerateMessage {
    /**
     * Method of message generation
     *
     * @param startDate initial value
     * @param endDate   final value
     * @param size      size of the list of objects
     * @return {@link String}
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
