package restful;

import DAO.DaoCompromisso;
import DAO.DaoGeneric;
import com.google.gson.Gson;
import entidades.Compromisso;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("Compromisso")
public class CompromissoResource {

    @Context
    private UriInfo context;

    public CompromissoResource() {
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson gson = new Gson();
        Compromisso comp = gson.fromJson(content, Compromisso.class);
        DaoGeneric.inserir(comp);
    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void alterar(String content) {
        Gson gson = new Gson();
        Compromisso comp = gson.fromJson(content, Compromisso.class);
        DaoGeneric.editar(comp);
    }

    @Path("{idcompromisso}")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("idcompromisso") Long id) {
        Gson gson = new Gson();
        return gson.toJson(DaoCompromisso.getID(id));
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(DaoCompromisso.getAll());
    }

    @Path("IDCompromissoContato/{idcompromisso}")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String compromissoContato(@PathParam("idcompromisso") int id) {
        Gson gson = new Gson();
        return gson.toJson(DaoCompromisso.getCompromissoContato(id));
    }

    @Path("IDCompromissoLocal/{idcompromisso}")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String compromissoLocal(@PathParam("idcompromisso") int id) {
        Gson gson = new Gson();
        return gson.toJson(DaoCompromisso.getCompromissoLocal(id));
    }

    @Path("{idcompromisso}")
    @DELETE
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void excluir(@PathParam("idcompromisso") Long id) {
        DaoCompromisso.delete(id);
    }
}
