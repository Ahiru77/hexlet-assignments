package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;

// BEGIN
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
	@RequestScope
    @Bean
    public Daytime getTime() {
        return  LocalDateTime.now().getHour() >= 6 && LocalDateTime.now().getHour() <= 22 ? new Day() : new Night();
    }
    // END
}
