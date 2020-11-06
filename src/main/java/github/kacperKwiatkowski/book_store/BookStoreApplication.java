package github.kacperKwiatkowski.book_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.validation.Validator;

@SpringBootApplication
public class BookStoreApplication implements RepositoryRestConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	Validator validator(){
		return null;
	}

	public void configureValidationRepositoryEventListener(final ValidatingRepositoryEventListener validatingRepositoryEventListener){
		validatingRepositoryEventListener.addValidator("beforeCreate", validator());
		validatingRepositoryEventListener.addValidator("beforeSave", validator());
	}
}
