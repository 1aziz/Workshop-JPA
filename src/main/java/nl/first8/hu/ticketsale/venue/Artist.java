package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by aziz on 5/23/17.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Artist {
    private String name;
    private Genre genre;

    @ManyToOne
    @JoinColumn(name = "concert_id", referencedColumnName = "id")
    private Concert concert;
}
