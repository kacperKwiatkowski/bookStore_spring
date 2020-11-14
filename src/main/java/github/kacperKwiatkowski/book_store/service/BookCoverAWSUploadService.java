package github.kacperKwiatkowski.book_store.service;

import github.kacperKwiatkowski.book_store.buckets.BucketName;
import github.kacperKwiatkowski.book_store.fileStore.FileStore;
import github.kacperKwiatkowski.book_store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

import static org.apache.http.entity.ContentType.*;

@Service
public class BookCoverAWSUploadService {

    private final BookRepository bookRepository;
    private final FileStore fileStore;

    @Autowired
    public BookCoverAWSUploadService(BookRepository bookRepository, FileStore fileStore) {
        this.bookRepository = bookRepository;
        this.fileStore = fileStore;
    }

    public void uploadBookCoverImage(MultipartFile file, int bookId){
        isFileEmpty(file);
        isImage(file);
        Map<String, String> metadata = extractMetadata(file);
        uploadImage(file, metadata, bookId);
    }

    private void uploadImage(MultipartFile file, Map<String, String> metadata, int bookId) {
        String path = String.format("%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), bookId);
        //FIXME Filename is not correct
        String filename = String.format("%s-%s", file.getOriginalFilename(), UUID.randomUUID());
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
