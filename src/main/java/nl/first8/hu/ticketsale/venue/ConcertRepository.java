package nl.first8.hu.ticketsale.venue;

import nl.first8.hu.ticketsale.registration.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ConcertRepository {

    private final EntityManager entityManager;

    @Autowired
    public ConcertRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    public List<Concert> findConcertByArtist(String artist) {
        try {
            return entityManager.createQuery("SELECT c FROM Concert c WHERE c.artist.name = :artist", Concert.class)
                    .setParameter("artist", artist)
                    .getResultList();
        } catch (NoResultException ex) {
            return Arrays.asList();
        }
    }

    public List<Concert> findConcertByGenre(String genre) {
        try {
            int genreOrdinal = Genre.valueOf(genre.toUpperCase()).ordinal();
            return entityManager.createQuery("SELECT c FROM Concert c WHERE c.artist.genre = " + genreOrdinal, Concert.class)
                    .getResultList();
        } catch (NoResultException ex) {
            return Arrays.asList();
        }
    }

    public List<Concert> findConcertByLocation(String name) {
        try {
            return entityManager.createQuery("SELECT c FROM Concert c WHERE c.location.name = :name", Concert.class)
                    .setParameter("name", name)
                    .getResultList();
        } catch (NoResultException ex) {
            return Arrays.asList();
        }
    }

    public List<Concert> findConcertByMinDate(Date date) {
        try {
            return entityManager.createQuery("SELECT c FROM Concert c WHERE c.date > :date", Concert.class)
                    .setParameter("date", date, TemporalType.DATE)
                    .getResultList();
        } catch (NoResultException ex){
            return Arrays.asList();
        }
    }
}
