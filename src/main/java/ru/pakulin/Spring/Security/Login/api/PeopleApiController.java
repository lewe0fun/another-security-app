package ru.pakulin.Spring.Security.Login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/people/")
public class PeopleApiController {

    private final UserService userService;

    @Autowired
    public PeopleApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getAllPersons() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getPerson(@PathVariable("id") int id) {
        return userService.findById(id).map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/age/{age}")
    public List<User>  getPersonByAge(@PathVariable("age") int age) {
        return userService.findByAge(age);
    }
    @GetMapping("/age>/{age}")
    public List<User>  getPersonByAgeMoreThen(@PathVariable("age") int age) {
        return userService.findByAgeMoreThen(age);
    }
    @GetMapping("/age</{age}")
    public List<User>  getPersonByAgeThenLess(@PathVariable("age") int age) {
        return userService.findByAgeLessThen(age);
    }
    @GetMapping("/name/{name}")
    public List<User>  getPersonByName(@PathVariable("age") String name) {
        return userService.findByName(name);
    }
    @PostMapping()
    public User create(@RequestBody User user) {
        return userService.save(user);
    }


    @PutMapping("/{id}")
    public User update(@PathVariable("id") int id,@RequestBody User user) {
            return userService.update(id,user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        userService.delete(id);
    }
}
