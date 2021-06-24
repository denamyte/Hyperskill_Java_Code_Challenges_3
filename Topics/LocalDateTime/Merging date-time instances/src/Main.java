import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public class Main {

    public static LocalDateTime merge(LocalDateTime dt1, LocalDateTime dt2) {
        return new MaxFieldMerger(dt1, dt2).getMaxFieldInstance();
    }

    static class MaxFieldMerger {
        final LocalDateTime dt1;
        final LocalDateTime dt2;

        public MaxFieldMerger(LocalDateTime dt1, LocalDateTime dt2) {
            this.dt1 = dt1;
            this.dt2 = dt2;
        }

        LocalDateTime getMaxFieldInstance() {
            return LocalDateTime.of(max(LocalDateTime::getYear),
                                    max(LocalDateTime::getMonthValue),
                                    max(LocalDateTime::getDayOfMonth),
                                    max(LocalDateTime::getHour),
                                    max(LocalDateTime::getMinute),
                                    max(LocalDateTime::getSecond));
        }

        int max(ToIntFunction<LocalDateTime> fieldGetter) {
            return Math.max(fieldGetter.applyAsInt(dt1), fieldGetter.applyAsInt(dt2));
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}