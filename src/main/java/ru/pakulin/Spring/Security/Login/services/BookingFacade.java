package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pakulin.Spring.Security.Login.domain.factory.IUserCardFactory;
import ru.pakulin.Spring.Security.Login.domain.factory.UserCardFactoryEssential;
import ru.pakulin.Spring.Security.Login.domain.factory.UserCardFactoryOrdinary;
import ru.pakulin.Spring.Security.Login.domain.model.Book;
import ru.pakulin.Spring.Security.Login.domain.model.Role;
import ru.pakulin.Spring.Security.Login.domain.model.User;
import ru.pakulin.Spring.Security.Login.domain.model.UserCard;

import java.util.Optional;

@Service
public class BookingFacade implements IBookingFacade {
    private final BookService bookService;
    private final UserService userService;

    @Autowired
    public BookingFacade(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }


    @Override
    public UserCard assign(long bookId, long userId, int days) {
        Optional<Book> book = bookService.findById(bookId);
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            if (book.isPresent() && book.get().isAvailable()) {
                IUserCardFactory iUserCardFactory;
                if (user.get().getRole() == Role.ADMIN) {
                    iUserCardFactory = new UserCardFactoryEssential();
                } else iUserCardFactory = new UserCardFactoryOrdinary();
                bookService.assign(bookId, userId);
                return iUserCardFactory.createCard(bookId, userId, days);
            }
        }
        return null;
    }
}
