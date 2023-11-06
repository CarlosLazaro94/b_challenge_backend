package pe.bancom.support.util;

import static pe.bancom.support.util.Constants.FORMAT_DATE;
import static pe.bancom.support.util.Constants.FORMAT_DATE_ISO;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * this class contains method utils for used
 *
 * @author carlos lazaro
 * @version 0.0.1-SNAPSHOT
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Utils {
  public static LocalDateTime formatDateTime(String dateTime) {
    return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(FORMAT_DATE));
  }

  public static LocalDateTime formatterIsoDateTime(String dateTime) {
    DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern(FORMAT_DATE_ISO);
    ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateTime, isoFormatter);
    return LocalDateTime.parse(zonedDateTime.format(DateTimeFormatter.ofPattern(FORMAT_DATE)),
        DateTimeFormatter.ofPattern(FORMAT_DATE));
  }
}
