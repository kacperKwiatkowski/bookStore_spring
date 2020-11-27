package github.kacperKwiatkowski.book_store.controller;

import com.google.gson.Gson;
import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.model.User;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import github.kacperKwiatkowski.book_store.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository){this.userRepository = userRepository;}

    @GetMapping
    ResponseEntity<List<User>> readAllUsers(Pageable pageable){
        return ResponseEntity.ok(userRepository.findAll(pageable).getContent());
    }

    @PostMapping(
            path = "/login"
    )
    void loginRequestVerifier(
            @RequestParam("details")String loginDetails)
    {
        Gson g = new Gson();
        User user = g.fromJson(loginDetails, User.class);
        userRepository.save(user);

    }
}
