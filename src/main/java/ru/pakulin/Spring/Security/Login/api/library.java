package ru.pakulin.Spring.Security.Login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pakulin.Spring.Security.Login.domain.model.UserCard;
import ru.pakulin.Spring.Security.Login.services.BookingFacade;
import ru.pakulin.Spring.Security.Login.services.IBookingFacade;

@RestController
@RequestMapping("/api/library/")
public class library {
    @Autowired
    private IBookingFacade ibookingFacade;

    @GetMapping("/assign/{bookId}/{userId}/{days}")
    public ResponseEntity<UserCard>  assign(@PathVariable long bookId, @PathVariable long userId, @PathVariable int days){
      return ResponseEntity.ok(ibookingFacade.assign(bookId,userId,days));
    }
}
