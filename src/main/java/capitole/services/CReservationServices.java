package capitole.services;

import capitole.classes.CDate;
import capitole.classes.CReservation;
import capitole.dao.CCrudServiceBean;
import capitole.dao.ICrudService;

import javax.persistence.EntityTransaction;
import javax.ws.rs.*;
import java.util.List;

import static capitole.dao.CCrudServiceBean.em;

/**
 * Created by clemzux on 28/10/16.
 */

@Path("/reservations")
@Produces("application/json")
@Consumes("application/json")
public class CReservationServices {

    public static ICrudService<CReservation> sCrudReservation = new CCrudServiceBean<CReservation>();


    //////// crud operations ////////


    @GET
    @Produces("application/json")
    public static List<CReservation> reservationAll(){
        return (List<CReservation>) sCrudReservation.findWithNamedQuery(CReservation.CRESERVATION_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putReservation(CReservation cReservation){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudReservation.update(cReservation);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postReservation(CReservation cReservation) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudReservation.create(cReservation);
        transac.commit();
    }
}
