package github.kacperKwiatkowski.book_store.controller;

import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import github.kacperKwiatkowski.book_store.service.BookCoverAWSUploadService;
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
    private final BookCoverAWSUploadService bookCoverAWSUploadService;

    @Autowired
    public BookController(BookRepository bookRepository, BookCoverAWSUploadService bookCoverAWSUploadService) {
        this.bookRepository = bookRepository;
        this.bookCoverAWSUploadService = bookCoverAWSUploadService;
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
    )
    ResponseEntity<Book> createBookPosition(
            @RequestBody Book bookPositionToCreate) {
        Book retrievedBook = bookRepository.save(bookPositionToCreate);
        return ResponseEntity.created(URI.create("/" + retrievedBook.getId())).body(retrievedBook);
    }

    @PostMapping(
            path = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity createBookPosition(
            @RequestParam("image")MultipartFile file,
            @RequestParam("details")Book bookDetails) {

        bookCoverAWSUploadService.uploadBookCoverImage(file);
        return ResponseEntity.ok().build();
    }



}
