import java.util.*;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " - " + title + " by " + author;
    }
}

public class LibraryManagementSystem {

    public static Book linearSearch(List<Book> books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) return b;
        }
        return null;
    }

    public static Book binarySearch(List<Book> books, String title) {
        int left = 0, right = books.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books.get(mid).title.compareToIgnoreCase(title);
            if (cmp == 0) return books.get(mid);
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(101, "C Programming", "Dennis Ritchie"));
        books.add(new Book(102, "Java Basics", "James Gosling"));
        books.add(new Book(103, "Python Guide", "Guido van Rossum"));

        System.out.println("Linear Search Result:");
        System.out.println(linearSearch(books, "Java Basics"));

        Collections.sort(books, Comparator.comparing(b -> b.title));
        System.out.println("Binary Search Result:");
        System.out.println(binarySearch(books, "Java Basics"));
    }
}
