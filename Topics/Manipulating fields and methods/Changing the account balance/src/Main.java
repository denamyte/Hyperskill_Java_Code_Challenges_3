import java.lang.reflect.Field;

final class AccountUtils {

    private AccountUtils() { }

    public static void increaseBalance(Account account, long amount) {
        try {
            final Field balance = Account.class.getDeclaredField("balance");
            balance.setAccessible(true);
            balance.set(account, (Long) balance.get(account) + amount);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}