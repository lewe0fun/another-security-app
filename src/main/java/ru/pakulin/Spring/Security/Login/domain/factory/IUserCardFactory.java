package ru.pakulin.Spring.Security.Login.domain.factory;

import ru.pakulin.Spring.Security.Login.domain.model.UserCard;

public interface IUserCardFactory {
    UserCard createCard(long bookId, long userId, int time);
}
