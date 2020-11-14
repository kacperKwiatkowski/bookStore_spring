/*
package github.kacperKwiatkowski.book_store.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

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

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public double getAmountOfPurchase() {
        return amountOfPurchase;
    }

    public void setAmountOfPurchase(double amountOfPurchase) {
        this.amountOfPurchase = amountOfPurchase;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
*/
