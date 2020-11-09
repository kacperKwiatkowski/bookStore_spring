package github.kacperKwiatkowski.book_store.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    private int id;
    private String email;
    private String nick;
    private String password;
    private String firstname;
    private String lastname;
    private String phoneNum;
    private int houseNum;
    private int flatNum;
    private int street;
    private String town;
    private String postcode;
    private LocalDate dob;
}
