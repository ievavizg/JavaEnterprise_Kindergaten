package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.KindergartenGroup;
import lt.vu.persistence.KindergartenGroupDAO;
import lt.vu.rest.contracts.KindergartenGroupDTO;
import org.mybatis.cdi.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/kindergartenGroup")
public class KindergartenGroupController {

    @Inject
    @Setter @Getter
    private KindergartenGroupDAO kindergartenGroupDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        KindergartenGroup kindergartenGroup = kindergartenGroupDAO.findOne(id);

        if (kindergartenGroup == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        KindergartenGroupDTO kindergartenGroupDTO = new KindergartenGroupDTO();
        kindergartenGroupDTO.setDescription(kindergartenGroup.getDescription());
        kindergartenGroupDTO.setName(kindergartenGroup.getName());
        kindergartenGroupDTO.setTeacherName(kindergartenGroup.getTeacher().getFirstName());
        kindergartenGroupDTO.setTeacherName(kindergartenGroup.getTeacher().getLastName());
        return Response.ok(kindergartenGroupDTO).build();
    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<KindergartenGroup> kindergartenGroups = kindergartenGroupDAO.loadAll();

        if (kindergartenGroups == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<KindergartenGroupDTO> kindergartenGroupDTOS = new ArrayList<>();

        for (KindergartenGroup kindergartenGroup : kindergartenGroups) {
            KindergartenGroupDTO kindergartenGroupDTO = new KindergartenGroupDTO();
            kindergartenGroupDTO.setDescription(kindergartenGroup.getDescription());
            kindergartenGroupDTO.setName(kindergartenGroup.getName());
            kindergartenGroupDTO.setTeacherName(kindergartenGroup.getTeacher().getFirstName());
            kindergartenGroupDTO.setTeacherName(kindergartenGroup.getTeacher().getLastName());
            kindergartenGroupDTOS.add(kindergartenGroupDTO);
        }

        return Response.ok(kindergartenGroupDTOS).build();
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(KindergartenGroupDTO kindergartenGroupRequest) {
        try {
            KindergartenGroup newGroup = new KindergartenGroup();
            newGroup.setName(kindergartenGroupRequest.getName());
            newGroup.setDescription(kindergartenGroupRequest.getDescription());

            kindergartenGroupDAO.persist(newGroup);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

}
