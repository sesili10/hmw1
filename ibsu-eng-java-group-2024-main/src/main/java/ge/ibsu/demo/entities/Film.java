package ge.ibsu.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private int releaseYear;
    private String rating;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
}
