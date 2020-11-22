package github.kacperKwiatkowski.book_store.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class AmazonConfig {

    @Bean
    public AmazonS3 s3() {

        Properties awsKeys = getProperties();

        AWSCredentials awsCredentials = new BasicAWSCredentials(awsKeys.getProperty("idKey"), awsKeys.getProperty("secretKey"));

        return AmazonS3Client.builder()
                .withRegion("us-east-2")
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .build();
    }

    private Properties getProperties() {
        Properties awsKeys = new Properties();
        try {
            awsKeys.load(new FileInputStream("src/main/resources/awsKeys.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return awsKeys;
    }
}


