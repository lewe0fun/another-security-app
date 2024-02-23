package ru.pakulin.Spring.Security.Login.api;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pakulin.Spring.Security.Login.domain.model.Book;
import ru.pakulin.Spring.Security.Login.domain.model.User;
import ru.pakulin.Spring.Security.Login.services.BookService;
import ru.pakulin.Spring.Security.Login.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/books/")
@Tag(name = "BOOKS API")
public class BookApiController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService readerService;

    @GetMapping()
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable @Parameter(description = "Book id", example = "1") int id) {
        return bookService.findById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/{id}/reader/{readerId}")
    public Book assignReaderToBook(@PathVariable int id, @PathVariable int readerId) {
        return bookService.assign(id, readerId);
    }

    @PutMapping("/{id}")
    public Book releaseBook(@PathVariable int id) {
        return bookService.release(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.delete(id);
    }

    @GetMapping("/readers")
    public List<User> getAllReaders() {
        return readerService.findAll();
    }

    @PostMapping("/readers")
    public User addReader(@RequestBody User reader) {
        return readerService.add(reader);
    }

    @GetMapping("/readers/{id}")
    public List<Book> getAllBooksOfReader(@PathVariable int id) {
        return bookService.findBooksByPerson(id);
    }
}
