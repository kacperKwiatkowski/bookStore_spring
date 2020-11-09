package github.kacperKwiatkowski.book_store.controller;

import github.kacperKwiatkowski.book_store.model.User;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import github.kacperKwiatkowski.book_store.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){this.userRepository = userRepository;}

    @GetMapping
    ResponseEntity<List<User>> readAllUsers(Pageable pageable){
        return ResponseEntity.ok(userRepository.findAll(pageable).getContent());
    }
}
