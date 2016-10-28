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

@Path("/dates")
@Produces("application/json")
@Consumes("application/json")
public class CDateServices {

    public static ICrudService<CDate> sCrudDate = new CCrudServiceBean<CDate>();


    //////// crud operations


    // retourne toutes les dates
    @GET
    @Produces("application/json")
    public static List<CDate> dateAll(){
        return (List<CDate>) sCrudDate.findWithNamedQuery(CDate.CDATE_BY_ALL);
    }

    @PUT
    @Produces("application/json")
    public void putDate(CDate date){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudDate.update(date);
        transac.commit();
    }

    @POST
    @Produces("application/json")
    public void postDate(CDate date) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        sCrudDate.create(date);
        transac.commit();
    }
}
