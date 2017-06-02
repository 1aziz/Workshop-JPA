package nl.first8.hu.ticketsale;

import nl.first8.hu.ticketsale.venue.Concert;
import nl.first8.hu.ticketsale.venue.ConcertRepository;
import nl.first8.hu.ticketsale.venue.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

/**
 * Created by aziz on 6/1/17.
 */
@SpringBootApplication
public class TempTest implements CommandLineRunner {

    @Autowired
    private ConcertService service;



    public static void main(String[] args) throws Exception {
        SpringApplication.run(TempTest.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(" check");
        for (Concert concert : service.findConcertByGenre("HIPHOP")) {
            System.out.println(concert.toString());
        }
    }
}

