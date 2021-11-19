package restful;

import DAO.DaoContato;
import DAO.DaoGeneric;
import com.google.gson.Gson;
import entidades.Contato;
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

@Path("Contato")
public class ContatoResource {

    @Context
    private UriInfo context;

    public ContatoResource() {
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson gson = new Gson();
        Contato contato = gson.fromJson(content, Contato.class);
        DaoGeneric.inserir(contato);
    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void alterar(String content) {
        Gson gson = new Gson();
        Contato contato = gson.fromJson(content, Contato.class);
        DaoGeneric.editar(contato);
    }

    @Path("{idcontato}")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("idcontato") Long id) {
        Gson gson = new Gson();
        return gson.toJson(DaoContato.getID(id));
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(DaoContato.getAll());
    }

    @Path("{idcontato}")
    @DELETE
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void excluir(@PathParam("idcontato") Long id) {
        DaoContato.delete(id);
    }
}
