package github.kacperKwiatkowski.book_store.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users_purchases", uniqueConstraints = {
        @UniqueConstraint(columnNames = "purchase_id")
})
public class UserPurchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id", nullable = false)
    private int id;

    private LocalDate dateOfPurchase;

    private double amountOfPurchase;
/*
    @OneToMany
    private Set<Book> purchasedBooks;*/

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public UserPurchase() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
