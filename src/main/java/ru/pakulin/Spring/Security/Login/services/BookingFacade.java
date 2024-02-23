package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pakulin.Spring.Security.Login.models.Book;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.models.UserCard;
import ru.pakulin.Spring.Security.Login.models.UserCardFactory;

import java.util.Optional;
@Service
public class BookingFacade implements IBookingFacade {
    private final BookService bookService;
    private final UserService userService;
    private final UserCardFactory userCardFactory;

    @Autowired
    public BookingFacade(BookService bookService, UserService userService, UserCardFactory userCardFactory) {
        this.bookService = bookService;
        this.userService = userService;
        this.userCardFactory = userCardFactory;
    }

    @Override
    public UserCard assign(long bookId, long userId, int days) {
        Optional<Book> book = bookService.findById(bookId);
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            if (book.isPresent() && book.get().isAvailable()) {
                bookService.assign(bookId, userId);
                return userCardFactory.createCard(bookId,userId,days);
            }
        }
        return null;
    }
}
