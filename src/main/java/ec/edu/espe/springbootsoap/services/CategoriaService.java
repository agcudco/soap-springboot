package ec.edu.espe.springbootsoap.services;

import ec.edu.espe.springbootsoap.model.Categoria;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(
        targetNamespace = "http://soap.espe.edu.ec/",
        name            = "CategoriaService"
)
public interface CategoriaService {
    @WebMethod
    @WebResult(name = "Categoria")
    Categoria getCategoria(@WebParam(name = "id") Long id);

    @WebMethod
    List<Categoria> listCategorias();

    @WebMethod
    Categoria createCategoria(@WebParam(name = "categoria") Categoria categoria);

    @WebMethod
    boolean deleteCategoria(@WebParam(name = "id") Long id);
}
