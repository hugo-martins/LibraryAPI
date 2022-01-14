package br.com.phoebustecnologia.Library.Repositories;

import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.dto.ClientDTO;
import br.com.phoebustecnologia.Library.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

    Optional findById(Long id);

    ClientDTO save(ClientDTO clientDTO);
}
