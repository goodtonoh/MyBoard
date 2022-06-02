package com.sparta.week02_hw;

import com.sparta.week02_hw.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week02HwApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week02HwApplication.class, args);
    }

    // JPA 실행 코드
    @Bean
    public CommandLineRunner demo(BoardRepository repository) {
        return (args) -> {

//            Board board = new Board();
//
//            System.out.println(board.getTitle());
//            System.out.println(board.getAuthor());
//
//            board.setTitle("웹개발의 봄 스프링");
//
//            System.out.println(board.getTitle());

            // Git testing

        };
    }
}
