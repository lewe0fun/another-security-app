package ru.pakulin.Spring.Security.Login.domain.factory;

import ru.pakulin.Spring.Security.Login.domain.model.UserCard;
import ru.pakulin.Spring.Security.Login.domain.model.UserCardType;

import java.time.LocalDate;

public class UserCardFactoryOrdinary implements IUserCardFactory {
    @Override
    public UserCard createCard(long bookId, long userId, int days) {
        LocalDate time = LocalDate.now();
        return new UserCard
                .UserCardBuilder()
                .bookId(bookId)
                .userId(userId)
                .type(UserCardType.ORDINARY)
                .startDate(time)
                .endTime(time.plusDays(days))
                .build();
    }
}
