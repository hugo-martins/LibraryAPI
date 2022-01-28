package br.com.phoebustecnologia.Library.services.ClientServices;

import br.com.phoebustecnologia.Library.dto.ClientDTO.ClientDTO;

import java.util.List;

public interface ClientServices {

    //Listar clientes
    List<ClientDTO> findAll();

    //Pesquisar Client por ID
    ClientDTO findById(Long id);

    //Deletar client
    void delete(Long id);

    //Salvar client
    ClientDTO save(ClientDTO client);

    //Atualizar client
    ClientDTO update(Long id, ClientDTO client);





}
