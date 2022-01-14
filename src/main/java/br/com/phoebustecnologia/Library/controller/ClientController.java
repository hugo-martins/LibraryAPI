package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.ClientDTO;
import br.com.phoebustecnologia.Library.services.ClientServices;
import org.jetbrains.annotations.NotNull;
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
        return clientServices.findAll();

    }

    @GetMapping(value = "/{id}")
    public ClientDTO ClientList(@PathVariable Long id) throws Throwable {
        return clientServices.findById(id);

    }
    @PostMapping
    public void addClient(@RequestBody ClientDTO client) {
        clientServices.save(client);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientServices.delete(id);

    }

    @PutMapping(value = "/{id}")
    public void updateClient(@RequestBody @NotNull ClientDTO client, @PathVariable Long id) throws Throwable {
        client.setId(id);
        clientServices.update(client);
    }
}
