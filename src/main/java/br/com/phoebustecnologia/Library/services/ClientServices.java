package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.ClientRepository;
import br.com.phoebustecnologia.Library.exceptions.BookNotFoundException;
import br.com.phoebustecnologia.Library.exceptions.ClientExistException;
import br.com.phoebustecnologia.Library.exceptions.ClientNotFoundException;
import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Client;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;


    //Pesquisar lista de clientes
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    //Pesquisar cliente por ID;
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    //Salvar Cliente
    public Client save(Client client) {
        if(client.getId()!=null){
            throw new ClientExistException();
        }
        return clientRepository.save(client);
    }

    //Deletar cliente
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        }
        clientRepository.deleteById(id);
    }

    //Atualizar cliente
    public Client update(@NotNull Client client) {
        if (!clientRepository.existsById(client.getId())) {
            throw new ClientNotFoundException();
        }
        Client obj = findById(client.getId());
        updateValuesClient(obj, client);
        clientRepository.save(obj);

        return obj;
    }


    //Método para salvar e atualizar entidades dos clientes
    public void updateValuesClient(Client newObj, Client oldObj) {
        newObj.setName(oldObj.getName());
        newObj.setEmail(oldObj.getEmail());
        newObj.setPhone(oldObj.getPhone());
        newObj.setAge(oldObj.getAge());
        newObj.setSex(oldObj.getSex());
    }


}
