package capitole.classes;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by clemzux on 28/10/16.
 */

@Entity
@NamedQueries(
        @NamedQuery(name = CDate.CDATE_BY_ALL, query = "select date from CDate date order by date.id")
)
public class CDate implements Serializable{

    @TableGenerator(name = "dateGenerator", allocationSize = 1, initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "dateGenerator")
    @Column(name = "date_id")
    private int id;
    private String date;

    public static final String CDATE_BY_ALL = "CDate.findDateAll";


    //////// builder ////////


    public CDate() {}


    //////// methods ////////


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return "CDate{" +
                "id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}
