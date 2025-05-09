package ec.edu.espe.springbootsoap.services.impl;

import ec.edu.espe.springbootsoap.model.Cliente;
import ec.edu.espe.springbootsoap.repository.ClienteRepository;
import ec.edu.espe.springbootsoap.services.ClienteService;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@WebService(
        endpointInterface = "ec.edu.espe.springbootsoap.services.ClienteService",
        targetNamespace = "http://soap.ejemplo.com/",
        serviceName = "ClienteService"
)
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public Cliente getCliente(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Cliente> listClientes() {
        return repo.findAll();
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        cliente.setId(null);
        return repo.save(cliente);
    }

    @Override
    public boolean deleteCliente(Long id) {
        Optional<Cliente> c = repo.findById(id);
        if (c.isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
