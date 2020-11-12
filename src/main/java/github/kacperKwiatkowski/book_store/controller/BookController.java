package github.kacperKwiatkowski.book_store.controller;

import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Book>> readAllBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping
    ResponseEntity<List<Book>> readAllBookPositions(Pageable pageable){
        return ResponseEntity.ok(bookRepository.findAll(pageable).getContent());
    }

    @PostMapping
    ResponseEntity<Book> createBookPosition(@RequestBody /*@Valid*/ Book bookPositionToCreate){
        Book retrievedBook = bookRepository.save(bookPositionToCreate);
        return ResponseEntity.created(URI.create("/" + retrievedBook.getId())).body(retrievedBook);
    }

}
