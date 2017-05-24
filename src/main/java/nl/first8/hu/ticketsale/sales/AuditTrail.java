package nl.first8.hu.ticketsale.sales;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nl.first8.hu.ticketsale.registration.Account;

import javax.persistence.*;

/**
 * Created by aziz on 5/23/17.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditTrail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Account account;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Sale sale;
}
