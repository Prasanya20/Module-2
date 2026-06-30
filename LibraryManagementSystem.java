class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return bookId + " " + title + " by " + author;
    }
}

public class Main {

    // Linear Search
    static int linearSearch(Book books[], String key) {
        for (int i = 0; i < books.length; i++) {
            if (books[i].title.equalsIgnoreCase(key)) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search (Books must be sorted by title)
    static int binarySearch(Book books[], String key) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = books[mid].title.compareToIgnoreCase(key);

            if (result == 0)
                return mid;
            else if (result < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        // Books are already sorted by title
        Book books[] = {
            new Book(101, "C Programming", "Dennis Ritchie"),
            new Book(102, "Data Structures", "Mark Allen"),
            new Book(103, "Java Programming", "James Gosling"),
            new Book(104, "Python Basics", "Guido van Rossum"),
            new Book(105, "Web Development", "David Flanagan")
        };

        String searchTitle = "Java Programming";

        int index = linearSearch(books, searchTitle);
        if (index != -1)
            System.out.println("Linear Search Found: " + books[index]);
        else
            System.out.println("Book not found.");

        index = binarySearch(books, searchTitle);
        if (index != -1)
            System.out.println("Binary Search Found: " + books[index]);
        else
            System.out.println("Book not found.");
    }
}
