package restful;

import DAO.DaoGeneric;
import DAO.DaoLocal;
import com.google.gson.Gson;
import entidades.Localizacao;
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

@Path("Localizacao")
public class LocalizacaoResource {

    @Context
    private UriInfo context;

    public LocalizacaoResource() {
    }

    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void inserir(String content) {
        Gson gson = new Gson();
        Localizacao local = gson.fromJson(content, Localizacao.class);
        DaoGeneric.inserir(local);
    }

    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void alterar(String content) {
        Gson gson = new Gson();
        Localizacao local = gson.fromJson(content, Localizacao.class);
        DaoGeneric.editar(local);
    }

    @Path("{idlocal}")
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getOne(@PathParam("idlocal") Long id) {
        Gson gson = new Gson();
        return gson.toJson(DaoLocal.getID(id));
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getAll() {
        Gson gson = new Gson();
        return gson.toJson(DaoLocal.getAll());
    }

    @Path("{idlocal}")
    @DELETE
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void excluir(@PathParam("idlocal") Long id) {
        DaoLocal.delete(id);
    }
}
