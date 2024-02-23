package ru.pakulin.Spring.Security.Login.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class UserCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long bookId;

    @Column
    private UserCardType userCardType;

    @Column
    private LocalDate startTime;

    @Column
    private LocalDate endTime;


    public static class UserCardBuilder {
        private final UserCard userCard = new UserCard();

        public UserCardBuilder userId(long id) {
            userCard.setUserId(id);
            return this;
        }

        public UserCardBuilder bookId(long id) {
            userCard.setBookId(id);
            return this;
        }
        public UserCardBuilder type(UserCardType type) {
            userCard.setUserCardType(type);
            return this;
        }

        public UserCardBuilder startDate(LocalDate date) {
            userCard.setStartTime(date);
            return this;
        }

        public UserCardBuilder endTime(LocalDate date) {
            userCard.setEndTime(date);
            return this;
        }
        public UserCard build(){
            return userCard;
        }
    }
}
