package github.kacperKwiatkowski.book_store.service;

import github.kacperKwiatkowski.book_store.adapter.SQLBookRepository;
import github.kacperKwiatkowski.book_store.buckets.BucketName;
import github.kacperKwiatkowski.book_store.fileStore.FileStore;
import github.kacperKwiatkowski.book_store.model.Book;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class BookCoverAWSService {

    private final BookRepository bookRepository;
    private final SQLBookRepository sqlBookRepository;
    private final FileStore fileStore;

    @Autowired
    public BookCoverAWSService(BookRepository bookRepository, SQLBookRepository sqlBookRepository, FileStore fileStore) {
        this.bookRepository = bookRepository;
        this.sqlBookRepository = sqlBookRepository;
        this.fileStore = fileStore;
    }

    public void uploadBookCoverImage(MultipartFile file, Book createdBook){
        isFileEmpty(file);
        isImage(file);
        Map<String, String> metadata = extractMetadata(file);
        uploadImage(file, metadata, createdBook);
    }

    public byte[] downloadBookCoverImage(int bookId){
        Book foundBook = bookRepository.findById(bookId);
        String path = String.format("%s/%s",
                BucketName.PROFILE_IMAGE.getBucketName(),
                foundBook.getId());

        return foundBook.getBookCoverLink()
                .map(key -> fileStore.download(path, key))
                .orElse(new byte[0]);
    }



    private void uploadImage(MultipartFile file, Map<String, String> metadata, Book createdBook) {
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), createdBook.getId());
        //FIXME Filename is not correct
        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
        createdBook.setBookCoverLink(filename);
        bookRepository.save(createdBook);
        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private void isImage(MultipartFile file) {
        if (!Arrays.asList(
                IMAGE_JPEG.getMimeType(),
                IMAGE_PNG.getMimeType(),
                IMAGE_GIF.getMimeType()).contains(file.getContentType()
        )) {
            throw new IllegalStateException("File must be an image! [" + file.getContentType() + "]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if(file.isEmpty()){
            throw new IllegalStateException("Cannot upload an empty file!");
        }
    }
}
