package codegym.vn.apicrud.model;

import jakarta.persistence.*;

@Entity
public class Hobbies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
//    @OneToMany
//    @JoinColumn(name = "hobbies_id")
//    private Hobbies hobbies;

}
