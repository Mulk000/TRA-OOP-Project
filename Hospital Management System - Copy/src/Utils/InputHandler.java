package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter dateFormatter =DateTimeFormatter.ofPattern("yyyy-mm-dd");

    public static String getStringInput(String prompt) {
        String input;
        do {
            System.out.print(prompt + ": ");
            input = scanner.nextLine().trim();
            if (HelperUtils.isNull(input)) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (HelperUtils.isNull(input));
        return input;
    }

    public static int getIntInput(String prompt) {
        int result;
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                result = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer. Please try again.");
            }
        }
        return result;
    }

    public static int getIntInput(String prompt, int min, int max) {
        int result;
        while (true) {
            result = getIntInput(prompt);
            if (result < min || result > max) {
                System.out.println("Input must be between " + min + " and " + max + ".");
            } else {
                break;
            }
        }
        return result;
    }

    public static double getDoubleInput(String prompt) {
        double result;
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                result = Double.parseDouble(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
        return result;
    }

    public static LocalDate getDateInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        LocalDate date = null;
        while (date == null) {
            System.out.print(prompt + " (yyyy-MM-dd): ");
            String input = scanner.nextLine().trim();
            try {
                date = LocalDate.parse(input);
            } catch (Exception e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
        return date;
    }
    public static boolean getConfirmation(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt + " (yes/no): ");
            input = scanner.nextLine().trim().toLowerCase();
            if (HelperUtils.isNull(input)) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            } else {
                System.out.println("Please enter yes or no.");
            }
        }
         }

}


