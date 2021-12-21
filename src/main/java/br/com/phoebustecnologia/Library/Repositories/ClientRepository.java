package br.com.phoebustecnologia.Library.Repositories;

import br.com.phoebustecnologia.Library.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
