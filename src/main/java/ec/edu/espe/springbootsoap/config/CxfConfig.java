package ec.edu.espe.springbootsoap.config;

import ec.edu.espe.springbootsoap.services.impl.CategoriaServiceImpl;
import ec.edu.espe.springbootsoap.services.impl.ClienteServiceImpl;
import ec.edu.espe.springbootsoap.services.impl.ProductoServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.ws.Endpoint;

@Configuration
public class CxfConfig {

    @Bean
    public Endpoint clienteEndpoint(Bus bus, ClienteServiceImpl impl) {
        EndpointImpl endpoint = new EndpointImpl(bus, impl);
        endpoint.publish("/ClienteService");
        return endpoint;
    }

    @Bean
    public Endpoint categoriaEndpoint(Bus bus, CategoriaServiceImpl impl) {
        EndpointImpl endpoint = new EndpointImpl(bus, impl);
        endpoint.publish("/CategoriaService");
        return endpoint;
    }

    @Bean
    public Endpoint productoEndpoint(Bus bus, ProductoServiceImpl impl) {
        EndpointImpl endpoint = new EndpointImpl(bus, impl);
        endpoint.publish("/ProductoService");
        return endpoint;
    }
}
