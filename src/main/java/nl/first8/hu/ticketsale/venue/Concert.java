package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concert implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id")

    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    @Fetch(FetchMode.SELECT)

    private Location location;



}
