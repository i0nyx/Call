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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("за период с ");
        stringBuilder.append(startDate);
        stringBuilder.append(" по ");
        stringBuilder.append(endDate);
        stringBuilder.append(" : ");
        stringBuilder.append(size);
        stringBuilder.append(" - обьекта(ов)");
        return stringBuilder.toString();
    }
}
