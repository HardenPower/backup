package com.ticket.flight.flightstats;

import java.text.SimpleDateFormat;

/**
 * Created by Алексей Бут on 11.10.2015.
 */
public class Utils {
    public static String getDate(long date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd,mm,yy");
        return dateFormat.format(date);
    }
}
