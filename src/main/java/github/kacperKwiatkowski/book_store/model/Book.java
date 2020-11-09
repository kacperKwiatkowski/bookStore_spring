package github.kacperKwiatkowski.book_store.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private String iban;
    private int id;
    private String title;
    private String author;
    private String langOfPrint;
    private String langOfOrigin;
    private int numOfPages;
    private double price;
    private int amountInStock;

    public Book() {

    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
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

    public String getLangOfPrint() {
        return langOfPrint;
    }

    public void setLangOfPrint(String langOfPrint) {
        this.langOfPrint = langOfPrint;
    }

    public String getLangOfOrigin() {
        return langOfOrigin;
    }

    public void setLangOfOrigin(String langOfOrigin) {
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
}
