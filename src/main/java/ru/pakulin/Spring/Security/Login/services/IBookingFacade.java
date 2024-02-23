package ru.pakulin.Spring.Security.Login.services;

import ru.pakulin.Spring.Security.Login.domain.model.UserCard;

public interface IBookingFacade {



    UserCard assign(long bookId, long userId, int days);
}
