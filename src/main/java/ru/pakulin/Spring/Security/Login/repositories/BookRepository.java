package ru.pakulin.Spring.Security.Login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pakulin.Spring.Security.Login.domain.model.Book;

import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    @Query(value = "SELECT book.user_id, book.id, book.author, book.title, book.publication_date " +
            "FROM book JOIN users ON book.user_id = users.id WHERE users.id =?",nativeQuery = true)
    List<Book> findBooksByUser(int userId);
    Book findByTitle(String title);
}

