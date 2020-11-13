package github.kacperKwiatkowski.book_store.controller;

import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;

    @Autowired
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

    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Book> createBookPosition(
            @RequestBody Book bookPositionToCreate,
            @RequestParam("file")MultipartFile file) {
        Book retrievedBook = bookRepository.save(bookPositionToCreate);
        return ResponseEntity.created(URI.create("/" + retrievedBook.getId())).body(retrievedBook);
    }



}
