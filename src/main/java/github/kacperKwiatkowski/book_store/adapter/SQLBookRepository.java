package github.kacperKwiatkowski.book_store.adapter;

import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SQLBookRepository extends BookRepository, JpaRepository<Book, Integer>{
}
