/*
package github.kacperKwiatkowski.book_store.controller;

import github.kacperKwiatkowski.book_store.model.User;
import github.kacperKwiatkowski.book_store.model.UserPurchase;
import github.kacperKwiatkowski.book_store.repository.UserPurchaseRepository;
import github.kacperKwiatkowski.book_store.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class UserPurchaseController {

    private final UserPurchaseRepository userPurchaseRepository;

    public UserPurchaseController(UserPurchaseRepository userPurchaseRepository){this.userPurchaseRepository = userPurchaseRepository;}

    @GetMapping
    ResponseEntity<List<UserPurchase>> readAllUsers(Pageable pageable){
        return ResponseEntity.ok(userPurchaseRepository.findAll(pageable).getContent());
    }
}
*/
