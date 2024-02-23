package ru.pakulin.Spring.Security.Login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pakulin.Spring.Security.Login.models.UserCard;
import ru.pakulin.Spring.Security.Login.services.BookingFacade;

@RestController
@RequestMapping("/api/library/")
public class library {

    private final BookingFacade bookingFacade;

    @Autowired
    public library(BookingFacade bookingFacade) {
        this.bookingFacade = bookingFacade;
    }
    @GetMapping("/assign/{bookId}/{userId}/{days}")
    public UserCard  assign(@PathVariable long bookId,@PathVariable long userId,@PathVariable int days){
      return bookingFacade.assign(bookId,userId,days);
    }
}
