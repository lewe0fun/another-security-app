package ru.pakulin.Spring.Security.Login.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.pakulin.Spring.Security.Login.domain.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    @Query(value = "SELECT * FROM person WHERE age=?",nativeQuery = true)
    List<User> findByAge(int age);

    @Query(value = "SELECT * FROM person WHERE username=?",nativeQuery = true)
    List<User> findByName(String username);

    @Query(value = "SELECT * FROM person WHERE age > ?",nativeQuery = true)
    List<User> findByAgeMoreThen(int age);

    @Query(value = "SELECT * FROM person WHERE age < ?",nativeQuery = true)
    List<User> findByAgeLessThen(int age);
}
