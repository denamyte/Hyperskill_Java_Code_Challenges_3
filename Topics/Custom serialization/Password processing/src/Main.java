import java.io.*;
import java.util.stream.Collectors;

class UserProfile implements Serializable {
    private static final long serialVersionUID = 26292552485L;

    private String login;
    private String email;
    private transient String password;

    public UserProfile(String login, String email, String password) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(encDecString(password, 1));
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        password = encDecString((String) ois.readObject(), -1);
    }

    private static String encDecString(String s, int shift) {
        return s.chars()
                .mapToObj(i -> (char) (i + shift))
                .map(String::valueOf).collect(Collectors.joining(""));
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}