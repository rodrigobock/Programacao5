package restful;

import DAO.DaoGeneric;
import DAO.DaoParticipante;
import com.google.gson.Gson;
import entidades.Participante;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

@Path("Participante")
public class ParticipanteResource {

    @Context
    private UriInfo context;

    public ParticipanteResource() {
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson gson = new Gson();
        Participante participante = gson.fromJson(content, Participante.class);
        DaoGeneric.inserir(participante);
    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void alterar(String content) {
        Gson gson = new Gson();
        Participante participante = gson.fromJson(content, Participante.class);
        DaoGeneric.editar(participante);
    }

    @Path("{idparticipante}")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("idparticipante") Long id) {
        Gson gson = new Gson();
        return gson.toJson(DaoParticipante.getID(id));
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(DaoParticipante.getAll());
    }

    @Path("{idparticipante}")
    @DELETE
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void excluir(@PathParam("idparticipante") Long id) {
        DaoParticipante.delete(id);
    }
}
