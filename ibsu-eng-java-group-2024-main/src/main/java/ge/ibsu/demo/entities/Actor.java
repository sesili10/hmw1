package ge.ibsu.demo.entities;

import jakarta.persistence.*;

@Entity

public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
}
