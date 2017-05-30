package nl.first8.hu.ticketsale.venue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ConcertRepository {

    private final EntityManager entityManager;

    @Autowired
    public ConcertRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Concert> findConcertByArtist(String artist) {
        String jpql = "SELECT DISTINCT nl.first8.hu.ticketsale.venue.Concert(artist.concert.id, artist.name, artist.concert.location) " +
                "FROM Artist artist " +
                "WHERE artist.name = :artist";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("artist", artist);
        return query.getResultList();
    }

    public List<Concert> findConcertByGenre(Genre genre) {
        String jpql = "SELECT DISTINCT NEW nl.first8.hu.ticketsale.venue.Concert(concert.id, concert.artist, concert.location) " +
                "FROM Concert concert " +
                "WHERE concert.artist.genre = :genre";
        TypedQuery<Concert> query = entityManager.createQuery(jpql, Concert.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }
}
