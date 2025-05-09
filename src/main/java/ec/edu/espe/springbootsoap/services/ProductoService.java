package ec.edu.espe.springbootsoap.services;

import ec.edu.espe.springbootsoap.model.Producto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

import java.util.List;

@WebService(
        targetNamespace = "http://soap.espe.edu.ec/",
        name = "ProductoService"
)
public interface ProductoService {

    @WebMethod
    @WebResult(name = "Producto")
    ec.edu.espe.springbootsoap.model.Producto getProducto(@WebParam(name = "id") Long id);

    @WebMethod
    List<Producto> listProductos();

    @WebMethod
    Producto createProducto(@WebParam(name = "producto") Producto producto);

    @WebMethod
    boolean deleteProducto(@WebParam(name = "id") Long id);
}
