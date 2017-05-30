package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.xml.ws.Response;
import java.util.List;

/**
 * Created by ricko on 30-5-2017.
 */

@RestController
@RequestMapping("/concert")
@Transactional
public class ConcertResource {

    private final ConcertRepository repository;

    @Autowired
    public ConcertResource(ConcertRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/artist/{artist}")
    public ResponseEntity<List<Concert>> getConcertByArtist(@PathVariable("artist") final String artist) {
        try {
            List<Concert> concerts = repository.findConcertByArtist(artist);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/genre/{genre}")
    public ResponseEntity<List<Concert>> getConcertByGenre(@PathVariable("genre") final Genre genre) {
        try {
            List<Concert> concerts = repository.findConcertByGenre(genre);
            return ResponseEntity.ok(concerts);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }
}
