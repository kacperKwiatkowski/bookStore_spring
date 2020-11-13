package github.kacperKwiatkowski.book_store.buckets;

public enum BucketName {
    PROFILE_IMAGE("book-store-book-covers");

    private final String bucketName;

    BucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketName() {
        return bucketName;
    }
}
