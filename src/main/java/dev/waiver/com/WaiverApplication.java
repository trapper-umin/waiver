package dev.waiver.com;

import dev.waiver.com.models.Details;
import dev.waiver.com.services.DB.DetailsDBService;
import dev.waiver.com.services.DB.PeopleDBService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class WaiverApplication implements CommandLineRunner {

    private final DetailsDBService detailsDBService;
    private final PeopleDBService peopleDBService;

    public WaiverApplication(DetailsDBService detailsDBService, PeopleDBService peopleDBService){
        this.detailsDBService=detailsDBService;
        this.peopleDBService = peopleDBService;
    }

    public static void main(String[] args) {
        SpringApplication.run(WaiverApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {

//        Details details=new Details("Tony Stark",peopleDBService.get(1) ,45,"tony@stark.com",100,3,15, LocalDateTime.now(),LocalDateTime.now());
//        detailsDBService.save(details);
    }
}
