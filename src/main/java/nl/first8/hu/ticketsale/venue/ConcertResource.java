package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.xml.ws.Response;
import java.lang.management.OperatingSystemMXBean;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * Created by ricko on 30-5-2017.
 */

@RestController
@RequestMapping("/concert")
public class ConcertResource {
@Autowired
    private ConcertService concertService;


    @GetMapping(path = "/artist/{artist}")
    public ResponseEntity<List<Concert>> getConcertByArtist(@PathVariable("artist") final String artist) {

        try {
            return ResponseEntity.ok(concertService.findConcertByName(artist));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/genre/{genre}")
    public ResponseEntity<List<Concert>> getConcertByGenre(@PathVariable("genre") final String genreValue) {
        // TODO
        try {
            return ResponseEntity.ok(concertService.findConcertByGenre(genreValue));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path = "/location/{location}")
    public ResponseEntity<List<Concert>> getConcertbyName(@PathVariable("location") final String location) {
        try {
            return ResponseEntity.ok(concertService.findConcertByLocation(location));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

    @GetMapping(path= "/mindate/{date}")
    public ResponseEntity<List<Concert>> getConcertByMinDate(@PathVariable("date") final String date){
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        Date minDate = null;
        try {
            minDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            return ResponseEntity.ok(concertService.findConcertByMinDate(minDate));
        } catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
