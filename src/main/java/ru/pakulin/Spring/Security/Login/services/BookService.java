package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.repositories.BookRepository;
import ru.pakulin.Spring.Security.Login.models.Book;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService readerService;

    @Transactional
    public Book update(int id, Book book) {
        Book existingBook = findById(id);
        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        return bookRepository.save(existingBook);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new RuntimeException("book not found"));
    }

    public List<Book> findBooksByPerson(int id) {
        return bookRepository.findBooksByUser(id);
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book assign(int book_id, int readerId) {
        Book existingBook = findById(book_id);
        User reader = readerService.findById(readerId).orElseThrow(()-> new UsernameNotFoundException("User with id " + readerId + " not found"));
        existingBook.setReader(reader);
        return bookRepository.save(existingBook);
    }

    @Transactional
    public Book release(int id) {
        Book existingBook = findById(id);
        existingBook.setReader(null);
        return bookRepository.save(existingBook);
    }
}
