package ru.pakulin.Spring.Security.Login.models;

import java.time.LocalDate;

public class UserCardFactory implements IUserCardFactory{
    @Override
    public UserCard createCard(long bookId, long userId, int days) {
        LocalDate time=LocalDate.now();
        return new UserCard.UserCardBuilder().bookId(bookId).userId(userId).startDate(time).endTime(time.plusDays(days)).build();
    }
}
