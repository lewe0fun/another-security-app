package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.pakulin.Spring.Security.Login.domain.model.User;
import ru.pakulin.Spring.Security.Login.repositories.BookRepository;
import ru.pakulin.Spring.Security.Login.domain.model.Book;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService readerService;

    @Transactional
    public Book update(long id, Book book) {
        Optional<Book> existingBook = findById(id);
        if (existingBook.isEmpty())throw new NoSuchElementException("book with id "+id+" not found");
        existingBook.get().setTitle(book.getTitle());
        existingBook.get().setAuthor(book.getAuthor());
        return bookRepository.save(existingBook.get());
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(long id) {
        return bookRepository.findById(id);
    }

    public List<Book> findBooksByPerson(int id) {
        return bookRepository.findBooksByUser(id);
    }
    public Book findBookByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    @Transactional
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public void delete(long id) {
        bookRepository.deleteById(id);
    }

    @Transactional
    public Book assign(long bookId, long readerId) {
        Book existingBook = findById(bookId).orElseThrow(()->new NoSuchElementException("Book with id " + bookId + " not found"));
        User reader = readerService.findById(readerId).orElseThrow(()-> new UsernameNotFoundException("User with id " + readerId + " not found"));
        existingBook.setReader(reader);
        return bookRepository.save(existingBook);
    }

    @Transactional
    public Book release(long id) {
        Optional<Book> existingBook = findById(id);
        existingBook.orElseThrow(()->new UsernameNotFoundException("user with id "+id+" not found")).setReader(null);
        return bookRepository.save(existingBook.get());
    }
}
