package dat23b.cars.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="members")
public class Member {

    //Fields
    @Id
    private String username;
    @Column(name="email", length= 50, nullable = false)
    private String email;
    @Column(name="password", length= 50, nullable = false)
    private String password;
    @Column(name="first_name", length= 50, nullable = false)
    private String firstName;
    @Column(name= "last_name", length= 60, nullable = false)
    private String lastName;
    @Column(name="street", length= 50, nullable = false)
    private String street;
    @Column(name="zip", length= 50, nullable = false)
    private String zip;
    @Column(name="city", length= 50, nullable = false)
    private String city;
    @Column(name="approved")
    private boolean approved;
    @Column(name="ranking")
    private int ranking;

    @Column(name="created")
    @CreationTimestamp
    private LocalDateTime created;
    @Column(name="last_updated")
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    //Constructors
    public Member() {

    }

    public Member(String user, String password, String email, String firstName,
                  String lastName, String street, String city, String zip) {
        this.username = user;
        this.password= password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }


}
