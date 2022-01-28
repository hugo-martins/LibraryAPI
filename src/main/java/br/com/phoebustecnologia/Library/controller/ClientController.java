package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.ClientDTO.ClientDTO;
import br.com.phoebustecnologia.Library.services.ClientServices.ClientServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/client")
public class ClientController {

    @Autowired
    ClientServicesImpl clientServicesImpl;

    @GetMapping(value = "/all")
    public List<ClientDTO> ClientList() {
        return clientServicesImpl.findAll();

    }

    @GetMapping(value = "/{id}")
    public ClientDTO ClientList(@PathVariable Long id){
        return clientServicesImpl.findById(id);

    }
    @PostMapping
    public ClientDTO addClient(@RequestBody ClientDTO clientDTO) {
        return clientServicesImpl.save(clientDTO);
    }


    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientServicesImpl.delete(id);

    }

    @PutMapping(value = "/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        return clientServicesImpl.update(id,clientDTO);
    }
}
