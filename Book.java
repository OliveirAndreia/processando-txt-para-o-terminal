public class Book extends Item implements IRenewable {
    private String isbn;
    private String author;

    public Book(String isbn, String title, String author, String publisher, int year) {
        super(title, publisher, year);
        this.isbn = isbn;
        this.author = author;
    }


    public void showDetails() {
        System.out.println(
                "Livro '" + title + "' (ISBN: " + isbn + "), autoria de " + author + ", publicado por " + publisher + " em " + year + "."
        );
    }

    public void renew() {
        if (isAvailable) {
            borrow();
        } else {
            System.out.println("Livro " + title + " renovado.");
        }
    }

    @Override
    public String toString() {
        return "Livro ISBN: " + isbn;
    }

}
