package capitole.classes;

import javax.persistence.*;

/**
 * Created by clemzux on 28/10/16.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CReservation.CRESERVATION_BY_ALL, query = "select res from CReservation res order by res.id")
)
public class CReservation {

    @TableGenerator(name = "reservationGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "reservationGenerator")
    @Column(name = "reservation_id")
    private int id;
    private String name;
    private int nbPeople;
    private int nbMeal;
    private String note;

    public static final String CRESERVATION_BY_ALL = "CReservation.findReservationAll";
}
