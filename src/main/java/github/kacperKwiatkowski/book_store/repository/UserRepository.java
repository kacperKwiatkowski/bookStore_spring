package github.kacperKwiatkowski.book_store.repository;

import github.kacperKwiatkowski.book_store.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserRepository {

    Page<User> findAll(Pageable pageable);
}
