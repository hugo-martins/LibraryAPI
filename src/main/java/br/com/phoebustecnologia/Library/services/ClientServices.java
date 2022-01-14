package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.ClientRepository;
import br.com.phoebustecnologia.Library.dto.ClientDTO;
import br.com.phoebustecnologia.Library.exceptions.ClientExistException;
import br.com.phoebustecnologia.Library.exceptions.ClientNotFoundException;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {

    @Autowired
    private ClientRepository clientRepository;


    //Pesquisar lista de clientes
    public List<ClientDTO> findAll() {
        return ClientDTO.ListFromAllClients(clientRepository.findAll());
    }

    //Pesquisar cliente por ID;
    public ClientDTO findById(Long id) throws Throwable{
        return (ClientDTO) clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);
    }

    //Salvar Cliente
    public ClientDTO save(ClientDTO clientDTO) {
        if(clientDTO.getId()!=null){
            throw new ClientExistException();
        }
        return clientRepository.save(clientDTO);
    }

    //Deletar cliente
    public void delete(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new ClientNotFoundException();
        }
        clientRepository.deleteById(id);
    }

    //Atualizar cliente
    public ClientDTO update(@NotNull ClientDTO client) throws Throwable{
        if (!clientRepository.existsById(client.getId())) {
            throw new ClientNotFoundException();
        }
        ClientDTO obj = findById(client.getId());
        updateValuesClient(obj, client);
        return clientRepository.save(obj);

    }


    //Método para salvar e atualizar entidades dos clientes
    public void updateValuesClient(ClientDTO newObj, ClientDTO oldObj) {
        newObj.setName(oldObj.getName());
        newObj.setEmail(oldObj.getEmail());
        newObj.setPhone(oldObj.getPhone());
        newObj.setAge(oldObj.getAge());
        newObj.setSex(oldObj.getSex());
    }


}
