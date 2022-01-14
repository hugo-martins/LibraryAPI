package br.com.phoebustecnologia.Library.Repositories;

import br.com.phoebustecnologia.Library.dto.ClientDTO;
import br.com.phoebustecnologia.Library.dto.SaleDTO;
import br.com.phoebustecnologia.Library.model.Sale;
import br.com.phoebustecnologia.Library.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository <Sale, Long> {


    List<SaleDTO> findByStatus(Status status);

    Optional findById(Long id);

    SaleDTO save(SaleDTO saleDTO);
}
