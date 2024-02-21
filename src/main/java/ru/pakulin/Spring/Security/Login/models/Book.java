package ru.pakulin.Spring.Security.Login.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @NotEmpty(message = "title name should not be empty")
    @Size(min = 2, max = 100, message = "The book title must be between 2 and 100 characters long")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "title name should not be empty")
    @Size(min = 2, max = 100, message = "Author name must be between 2 and 100 characters long")
    @Column(name = "author")
    private String author;

    @Min(value = 1564, message = "year should be greater then 1564")
    @Column(name = "publication_date")
    private int year;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User reader;
}
