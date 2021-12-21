package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.ClientDTO;
import br.com.phoebustecnologia.Library.model.Client;
import br.com.phoebustecnologia.Library.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/client")
public class ClientController {

    @Autowired
    ClientServices clientServices;

    @GetMapping(value = "/all")
    public List<ClientDTO> ClientList() {
        return ClientDTO.ListFromAllClients(clientServices.findClientAll());

    }

    @GetMapping(value = "/{id}")
    public ClientDTO ClientList(@PathVariable Long id) {
        return ClientDTO.clientDTO(clientServices.clientsByID(id));

    }
    @PostMapping
    public void addClient(@RequestBody ClientDTO client) {
        clientServices.saveClient(Client.clientFrom(client));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientServices.deleteClient(id);

    }

    @PutMapping(value = "/{id}")
    public void updateClient(@RequestBody ClientDTO client, @PathVariable Long id) {
        client.setId(id);
        clientServices.updateClient(Client.clientFrom(client));
    }
}
