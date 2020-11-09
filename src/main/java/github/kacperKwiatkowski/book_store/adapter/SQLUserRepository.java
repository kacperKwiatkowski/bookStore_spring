package github.kacperKwiatkowski.book_store.adapter;

import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.model.User;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import github.kacperKwiatkowski.book_store.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLUserRepository extends UserRepository, JpaRepository<User, Integer>{
}
