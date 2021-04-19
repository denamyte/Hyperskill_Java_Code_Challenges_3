// You can experiment here, it won’t be checked

import java.util.List;

public class Task {
    public static void main(String[] args) {
        // put your code here
    }

  public void upperBoundedMethod(List<? extends Book> books) {
    Book book = books.get(0); // It is fine

    books.add(new Album()); // compile-time error
    books.add(new Book());  // compile-time error
    books.add(null); // also fine, because of null is a special type-independent value
  }
}

class Book {}
class Album extends Book {}

