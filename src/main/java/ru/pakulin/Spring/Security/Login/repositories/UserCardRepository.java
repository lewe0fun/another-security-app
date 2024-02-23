package ru.pakulin.Spring.Security.Login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pakulin.Spring.Security.Login.models.UserCard;
@Repository
public interface UserCardRepository extends JpaRepository<UserCard, Long> {
}
