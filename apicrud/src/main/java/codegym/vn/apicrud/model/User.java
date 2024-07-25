package codegym.vn.apicrud.model;

import jakarta.persistence.*;

@Entity
@Table
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String username;
    private String password;

}
