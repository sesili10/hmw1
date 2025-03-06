package ge.ibsu.demo.repositories;

import ge.ibsu.demo.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT f FROM Film f WHERE " +
            "(:title IS NULL OR LOWER(f.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:description IS NULL OR LOWER(f.description) LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
            "(:releaseYear IS NULL OR f.releaseYear = :releaseYear) AND " +
            "(:language IS NULL OR LOWER(f.language.name) = LOWER(:language))")
    Page<Film> searchFilms(String title, String description, Integer releaseYear, String language, Pageable pageable);
}
