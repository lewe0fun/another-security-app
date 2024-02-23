package ru.pakulin.Spring.Security.Login.models;

public interface IUserCardFactory {
    UserCard createCard(long bookId,long userId, int days);
}
