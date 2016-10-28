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


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "date")
    private CDate date;

    public static final String CRESERVATION_BY_ALL = "CReservation.findReservationAll";


    //////// builder ////////


    public CReservation() {}


    //////// methods ////////


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getNbPeople() { return nbPeople; }

    public void setNbPeople(int nbPeople) { this.nbPeople = nbPeople; }

    public int getNbMeal() { return nbMeal; }

    public void setNbMeal(int nbMeal) { this.nbMeal = nbMeal; }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    @Override
    public String toString() {
        return "CReservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nbPeople=" + nbPeople +
                ", nbMeal=" + nbMeal +
                ", note='" + note + '\'' +
                '}';
    }
}
