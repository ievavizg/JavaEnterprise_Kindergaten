package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.KindergartenGroup;
import lt.vu.entities.Teacher;
import lt.vu.persistence.KindergartenGroupDAO;
import lt.vu.persistence.TeacherDAO;
import lt.vu.rest.contracts.KindergartenGroupDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
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

    @Inject
    @Setter @Getter
    private TeacherDAO teacherDAO;

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
            Teacher teacher = teacherDAO.findOne(kindergartenGroupRequest.getTeacherId());
            newGroup.setTeacher(teacher);

            kindergartenGroupDAO.persist(newGroup);

            return Response.ok().build();

        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer kindergartenGroupId, KindergartenGroupDTO kindergartenGroupDTO) {
        try {
            KindergartenGroup kindergartenGroup = kindergartenGroupDAO.findOne(kindergartenGroupId);
            if (kindergartenGroup == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            kindergartenGroup.setDescription(kindergartenGroupDTO.getDescription());
            kindergartenGroup.setName(kindergartenGroupDTO.getName());
            Teacher teacher = teacherDAO.findOne(kindergartenGroupDTO.getTeacherId());
            kindergartenGroup.setTeacher(teacher);
            kindergartenGroupDAO.update(kindergartenGroup);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

}
