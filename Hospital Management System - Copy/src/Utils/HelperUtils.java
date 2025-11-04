package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

public class HelperUtils {

    // Null Check Methods
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // String Validation Methods
    public static boolean isValidString(String str) {
        return isNotNull(str);
    }

    public static boolean isValidString(String str, int minLength) {
        return isValidString(str) && str.length() >= minLength;
    }

    public static boolean isValidString(String str, int minLength, int maxLength) {
        return isValidString(str) && str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean isValidString(String str, String regex) {
        return isValidString(str) && Pattern.matches(regex, str);
    }

    // ID Generation Methods
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0,5);
    }

    public static String generateId(String prefix, int length) {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, Math.min(length, 32));
        return prefix + "-" + uuid;
    }

    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + UUID.randomUUID().toString() + "-" + suffix;
    }

    // Date Validation Methods
    public static boolean isValidDate(Date date) {
        return date != null;
    }

    public static boolean isValidDate(String dateStr) {
        if (isNull(dateStr)) return false;
        try {
            new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidDate(Date date, Date minDate, Date maxDate) {
        if (!isValidDate(date)) return false;
        return (minDate == null || !date.before(minDate)) && (maxDate == null || !date.after(maxDate));
    }

    public static boolean isFutureDate(Date date) {
        if (!isValidDate(date)) return false;
        return date.after(new Date());
    }

    public static boolean isPastDate(Date date) {
        if (!isValidDate(date)) return false;
        return date.before(new Date());
    }

    public static boolean isToday(Date date) {
        if (!isValidDate(date)) return false;
        LocalDate given = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return LocalDate.now().equals(given);
    }

    // Numeric Validation Methods
    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isPositive(double num) {
        return num > 0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isNegative(double num) {
        return num < 0;
    }

    public static boolean isValidAge(int age) {
        return age >= 0 && age <= 150;
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (dateOfBirth == null) return false;
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return age >= 0 && age <= 150;
    }
}
