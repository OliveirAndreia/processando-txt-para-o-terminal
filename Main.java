import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        double totalPrice = 0.0;
        double highestPrice = 0.0;
        Book mostExpensiveBook = null;

        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length != 6) {
                    System.out.println("*** Formato de linha inválido: " + line);
                    continue;
                }

                String isbn = parts[0];
                String title = parts[1];
                String author = parts[2];
                String publisher = parts[3];
                int year;
                double price;

                try {
                    year = Integer.parseInt(parts[4]);
                } catch (NumberFormatException e) {
                    System.out.println("*** Erro ao converter o ano do livro: " + line);
                    continue;
                }

                try {
                    price = Double.parseDouble(parts[5].replace(",", "."));
                } catch (NumberFormatException e) {
                    System.out.println("*** Erro ao converter o preço do livro: " + line);
                    continue;
                }

                Book book = new Book(isbn, title, author, publisher, year);
                books.add(book);
                totalPrice += price;

                if (price > highestPrice) {
                    highestPrice = price;
                    mostExpensiveBook = book;
                }
            }
        } catch (IOException e) {
            System.out.println("*** Erro ao abrir o arquivo books.txt");
        }

        // Exibe as informações de cada livro
        for (Book book : books) {
            book.showDetails();
        }

        // Exibe a média de preço dos livros
        if (!books.isEmpty()) {
            double averagePrice = totalPrice / books.size();
            System.out.printf("A média de preço dos livros é: R$ %.2f%n", averagePrice);
        }

        // Exibe o livro mais caro
        if (mostExpensiveBook != null) {
            System.out.printf("O livro mais caro é: %s com preço de R$ %.2f%n",
                    mostExpensiveBook.toString(), highestPrice);
        }
    }
}
