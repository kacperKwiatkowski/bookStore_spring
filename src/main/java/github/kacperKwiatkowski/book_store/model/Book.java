package github.kacperKwiatkowski.book_store.model;

import github.kacperKwiatkowski.book_store.util.enums.BookGenre;
import github.kacperKwiatkowski.book_store.util.enums.CountryCode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private BookGenre genre;
    @Enumerated(EnumType.STRING)
    private CountryCode langOfPrint;
    @Enumerated(EnumType.STRING)
    private CountryCode langOfOrigin;
    private int numOfPages;
    private double price;
    private int amountInStock;
    private String bookCoverLink;

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public BookGenre getGenre() {
        return genre;
    }

    public void setGenre(BookGenre genre) {
        this.genre = genre;
    }

    public CountryCode getLangOfPrint() {
        return langOfPrint;
    }

    public void setLangOfPrint(CountryCode langOfPrint) {
        this.langOfPrint = langOfPrint;
    }

    public CountryCode getLangOfOrigin() {
        return langOfOrigin;
    }

    public void setLangOfOrigin(CountryCode langOfOrigin) {
        this.langOfOrigin = langOfOrigin;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public Optional<String> getBookCoverLink() {
        return Optional.ofNullable(bookCoverLink);
    }

    public void setBookCoverLink(String bookCoverLink) {
        this.bookCoverLink = bookCoverLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
