package ru.pakulin.Spring.Security.Login.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.NotFound;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 10)
    private String name;
    @Column(unique = true,nullable = false,length = 40)
    private String email;
    @Column(unique = true,nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
}
