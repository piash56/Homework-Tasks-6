
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task2 {

    public static long daysBetween(
            int year_from,
            int month_from,
            int day_from,
            int year_to,
            int month_to,
            int day_to) {

        LocalDate dateFrom =
                LocalDate.of(year_from, month_from, day_from);

        LocalDate dateTo =
                LocalDate.of(year_to, month_to, day_to);

        return ChronoUnit.DAYS.between(dateFrom, dateTo);
    }

    public static void main(String[] args) {

        long result = daysBetween(2026, 1, 1, 2026, 1, 10);

        System.out.println("Days between dates: " + result);
    }
}
