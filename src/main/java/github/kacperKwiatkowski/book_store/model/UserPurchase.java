package github.kacperKwiatkowski.book_store.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "user's_purchases")
public class UserPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private int id;

    private LocalDate dateOfPurchase;

    private double amountOfPurchase;

    @OneToMany
    private Set<Book> purchasedBooks;

    @ManyToOne()
    @JoinColumn(name = "user's_id")
    private User user;

    public UserPurchase() {

    }

    public UserPurchase(Set<Book> purchasedBooks, User user) {
        this.purchasedBooks = purchasedBooks;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getPurchasedBooks() {
        return purchasedBooks;
    }

    public void setPurchasedBooks(Set<Book> purchasedBooks) {
        this.purchasedBooks = purchasedBooks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
