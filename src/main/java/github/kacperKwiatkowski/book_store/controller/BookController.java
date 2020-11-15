package github.kacperKwiatkowski.book_store.controller;

import com.google.gson.Gson;
import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import github.kacperKwiatkowski.book_store.service.BookCoverAWSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
@CrossOrigin("*")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final BookRepository bookRepository;
    private final BookCoverAWSService bookCoverAWSService;

    @Autowired
    public BookController(BookRepository bookRepository, BookCoverAWSService bookCoverAWSService) {
        this.bookRepository = bookRepository;
        this.bookCoverAWSService = bookCoverAWSService;
    }

    @GetMapping(params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Book>> readAllBooks(){
        return ResponseEntity.ok(bookRepository.findAll());
    }

    @GetMapping
    ResponseEntity<List<Book>> readAllBookPositions(Pageable pageable){
        return ResponseEntity.ok(bookRepository.findAll(pageable).getContent());
    }

    @GetMapping
            (
                    path = "/download/cover/{bookId}"
            )
    ResponseEntity<byte[]> fetchBookPositionsCovers(@PathVariable("bookId") int bookId){
        return ResponseEntity.ok( bookCoverAWSService
                        .downloadBookCoverImage(bookId));
    }


    @PostMapping(
            path = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity createBookPosition(
            @RequestParam("image")MultipartFile file,
            @RequestParam("details")String bookDetails) {

        Gson g = new Gson();
        Book createdBook = g.fromJson(bookDetails, Book.class);

        bookRepository.save(createdBook);
        bookCoverAWSService.uploadBookCoverImage(file, createdBook);
        return ResponseEntity.ok().build();
    }



}
