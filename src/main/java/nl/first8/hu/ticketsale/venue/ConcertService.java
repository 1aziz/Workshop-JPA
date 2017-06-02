package nl.first8.hu.ticketsale.venue;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by aziz on 6/1/17.
 */
@Service

public class ConcertService {

    private final ConcertRepository repository;

    @Autowired
    public ConcertService(ConcertRepository repository) {
        this.repository = repository;
    }

    public List<Concert> findConcertByName(@NonNull final String artistName) {
        return repository.findConcertByArtist(artistName);
    }

    public List<Concert> findConcertByGenre(@NonNull final String genre) {
        return repository.findConcertByGenre(genre);
    }

    public List<Concert> findConcertByLocation(@NonNull final String location) {
        return repository.findConcertByLocation(location);
    }

    public List<Concert> findConcertByMinDate(@NonNull final Date date){
        return repository.findConcertByMinDate(date);
    }
}

