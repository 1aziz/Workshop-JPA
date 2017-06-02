package nl.first8.hu.ticketsale.venue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by aziz on 5/23/17.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Artist  implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Genre genre;
}
