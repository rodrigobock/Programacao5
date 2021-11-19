/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import DAO.DAOCompromisso;
import av3_prog5.Compromisso;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import av3_prog5.Contato;
import av3_prog5.Localizacao;
import av3_prog5.Participante;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
@WebService(serviceName = "WS")
public class WS {

    // Inserir
    @WebMethod(operationName = "InserirContato")
    public boolean inserirContato(
            @WebParam(name = "nome") String nome,
            @WebParam(name = "fone") String fone,
            @WebParam(name = "email") String email) {
        Contato c = new Contato(nome, fone, email);
        return DAO.DAOContato.insertContato(c);
    }

    @WebMethod(operationName = "InserirLocalização")
    public boolean inserirLocal(
            @WebParam(name = "descricao") String descricao,
            @WebParam(name = "rua") String rua,
            @WebParam(name = "bairro") String bairro,
            @WebParam(name = "cidade") String cidade,
            @WebParam(name = "numero") String numero,
            @WebParam(name = "cep") String cep) {
        Localizacao l = new Localizacao(descricao, rua, bairro, cidade, numero, cep);
        return DAO.DAOLocal.insertLocal(l);
    }

    @WebMethod(operationName = "InserirComprimisso")
    public boolean inserirCompromisso(
            @WebParam(name = "data") Date data,
            @WebParam(name = "hora") Time hora,
            @WebParam(name = "duracao") Time duracao) {
        Compromisso comp = new Compromisso(data, hora, duracao);
        return DAO.DAOCompromisso.inserirCompromisso(comp);
    }

    @WebMethod(operationName = "InserirParticipante")
    public boolean inserirParticipante(
            @WebParam(name = "status") boolean status,
            @WebParam(name = "compromisso") Compromisso comp,
            @WebParam(name = "contato") Contato c) {
        Participante p = new Participante(status, comp, c);
        return DAO.DAOParticipantes.inserirParticipante(p);
    }

    // Editar
    @WebMethod(operationName = "EditarContato")
    public boolean editarContato(
            @WebParam(name = "nome") String nome,
            @WebParam(name = "fone") String fone,
            @WebParam(name = "email") String email,
            @WebParam(name = "compromisso") List<Participante> p) {
        Contato c = new Contato(nome, fone, email, p);
        return DAO.DAOGeneric.editar(c);
    }

    @WebMethod(operationName = "EditarLocalizacao")
    public boolean editarLocal(
            @WebParam(name = "descricao") String descricao,
            @WebParam(name = "rua") String rua,
            @WebParam(name = "bairro") String bairro,
            @WebParam(name = "cidade") String cidade,
            @WebParam(name = "numero") String numero,
            @WebParam(name = "cep") String cep,
            @WebParam(name = "compromisso") List<Compromisso> comp) {
        Localizacao l = new Localizacao(descricao, rua, bairro, cidade, numero, cep, comp);
        return DAO.DAOGeneric.editar(l);
    }

    @WebMethod(operationName = "EditarComprimisso")
    public boolean editarCompromisso(
            @WebParam(name = "data") Date data,
            @WebParam(name = "hora") Time hora,
            @WebParam(name = "duracao") Time duracao,
            @WebParam(name = "partipante") List<Participante> p,
            @WebParam(name = "localizacao") Localizacao l) {
        Compromisso comp = new Compromisso(data, hora, duracao, p, l);
        return DAO.DAOGeneric.editar(comp);
    }

    @WebMethod(operationName = "EditarParticipante")
    public boolean editarParticipante(
            @WebParam(name = "status") boolean status,
            @WebParam(name = "compromisso") Compromisso comp,
            @WebParam(name = "contato") Contato c) {
        Participante p = new Participante(status, comp, c);
        return DAO.DAOGeneric.editar(p);
    }

    // Consultar
    @WebMethod(operationName = "BuscarLocalPorID")
    public Localizacao buscarLocalByID(
            @WebParam(name = "id") long id) {
        return DAO.DAOLocal.getID(id);
    }

    @WebMethod(operationName = "BuscarLocalAll")
    public List<Localizacao> buscarLocalAll() {
        return DAO.DAOLocal.getAll();
    }

    @WebMethod(operationName = "BuscarCompromissoByID")
    public Compromisso buscarCompromissoByID(
            @WebParam(name = "id") long id) {
        return DAO.DAOCompromisso.getID(id);
    }

    @WebMethod(operationName = "BuscarCompromissoAll")
    public List<Compromisso> buscarCompromissoAll() {
        return DAO.DAOCompromisso.getAll();
    }

    @WebMethod(operationName = "BuscarContatoByID")
    public Contato buscarContatoByID(
            @WebParam(name = "id") long id) {
        return DAO.DAOContato.getID(id);
    }

    @WebMethod(operationName = "BuscarContatoAll")
    public List<Contato> buscarContatoAll() {
        return DAO.DAOContato.getAll();
    }

    @WebMethod(operationName = "BuscarByName")
    public List<Contato> buscarContatoByName(
            @WebParam(name = "nome") String nome) {
        return DAO.DAOContato.getContato(nome);
    }

    // Compromisso pelo Local
    @WebMethod(operationName = "CompromissoByLocal")
    public List<Compromisso> CompByLocal(
            @WebParam(name = "id") int id) {
        return DAOCompromisso.getCompromissoLocal(id);
    }

    @WebMethod(operationName = "CompromissoByContato")
    public List<Compromisso> CompByName(
            @WebParam(name = "id") int id) {
        return DAOCompromisso.getCompromissoContato(id);
    }

    // Delete
    @WebMethod(operationName = "DeleteContato")
    public boolean DeleteContato(
            @WebParam(name = "id") Long id) {
        return DAO.DAOContato.delete(id);
    }

    @WebMethod(operationName = "DeleteCompromisso")
    public boolean DeleteCompromisso(
            @WebParam(name = "id") Long id) {
        return DAO.DAOCompromisso.delete(id);
    }

    @WebMethod(operationName = "DeleteParticipante")
    public boolean DeleteParticipante(
            @WebParam(name = "id") Long id) {
        return DAO.DAOParticipantes.delete(id);
    }
    
        @WebMethod(operationName = "DeleteLocalizacao")
    public boolean DeleteLocal(
            @WebParam(name = "id") Long id) {
        return DAO.DAOLocal.delete(id);
    }

}
