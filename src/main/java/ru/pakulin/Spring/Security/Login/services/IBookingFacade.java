package ru.pakulin.Spring.Security.Login.services;

import ru.pakulin.Spring.Security.Login.models.UserCard;

import java.util.Date;

public interface IBookingFacade {



    UserCard assign(long bookId, long userId, int days);
}
