package br.com.phoebustecnologia.Library.services.SaleServices;

import br.com.phoebustecnologia.Library.dto.ClientDTO.ClientDTO;
import br.com.phoebustecnologia.Library.dto.SaleDTO.SaleDTO;
import br.com.phoebustecnologia.Library.model.Status;

import java.util.List;

public interface SaleService {

    //Listar venda pelo Status;
    List<SaleDTO> findByStatus(Status status);

    //Listar Vendas
    List<SaleDTO> findAll();

    //Pesquisar Sale por ID
    SaleDTO findById(Long id);

    //Deletar Sale
    void delete(Long id);

    //Salvar Sale
    SaleDTO save(SaleDTO saleDTO);

    //Atualizar Sale
    SaleDTO update(Long id, SaleDTO saleDTO);
}
