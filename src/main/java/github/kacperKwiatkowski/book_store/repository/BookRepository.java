package github.kacperKwiatkowski.book_store.repository;

import github.kacperKwiatkowski.book_store.adapter.SQLBookRepository;
import github.kacperKwiatkowski.book_store.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

public interface BookRepository {

    Book save(Book entity);
    
    List<Book> findAll();
    
    Page<Book> findAll(Pageable pageable);
}
