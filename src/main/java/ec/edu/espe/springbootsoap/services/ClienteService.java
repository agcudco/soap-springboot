package ec.edu.espe.springbootsoap.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

import ec.edu.espe.springbootsoap.model.Cliente;

@WebService(
        targetNamespace = "http://springbootsoap.espe.edu.ec/",
        name            = "ClienteService"
)
public interface ClienteService {
    @WebMethod
    @WebResult(name = "Cliente")
    Cliente getCliente(@WebParam(name = "id") Long id);

    @WebMethod
    List<Cliente> listClientes();

    @WebMethod
    Cliente createCliente(@WebParam(name = "cliente") Cliente cliente);

    @WebMethod
    boolean deleteCliente(@WebParam(name = "id") Long id);
}
