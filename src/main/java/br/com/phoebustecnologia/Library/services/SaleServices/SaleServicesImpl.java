package br.com.phoebustecnologia.Library.services.SaleServices;

import br.com.phoebustecnologia.Library.Repositories.SaleRepository;
import br.com.phoebustecnologia.Library.dto.SaleDTO.SaleDTO;
import br.com.phoebustecnologia.Library.exceptions.SaleNotFoundException;
import br.com.phoebustecnologia.Library.model.Sale;
import br.com.phoebustecnologia.Library.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServicesImpl implements SaleService{


    @Autowired
    private SaleRepository saleRepository;


    public SaleServicesImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }


    //Pesquisar lista de vendas pelo Status
    @Override
    public List<SaleDTO> findByStatus(Status status){
        return SaleDTO.ListFromAllSales(saleRepository.findByStatus(status));
    }

    //Pesquisar lista de Compras
    @Override
    public List<SaleDTO> findAll(){
        return SaleDTO.ListFromAllSales(saleRepository.findAll());
    }

    //Pesquisar venda por ID;
    @Override
    public SaleDTO findById(Long id){
        Sale result = saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new);
        return SaleDTO.saleDTO(result);
    }

    //Salvar venda
   @Override
    public SaleDTO save(SaleDTO saleDTO){
        Sale saleSaved = saleRepository.save(Sale.saleSaved(saleDTO));
        return SaleDTO.saleSavedDTO(saleSaved);
    }


    //Deletar venda
    @Override
    public void delete(Long id){
        Sale sale = saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new);

        saleRepository.delete(sale);
    }

    //Atualizar venda
    @Override
    public SaleDTO update(Long id, SaleDTO saleDTO) {
        Sale sale =  saleRepository.findById(id)
                .orElseThrow(SaleNotFoundException::new);

        SaleDTO dto = SaleDTO.saleSavedDTO(sale);
        updateValuesSale(dto, saleDTO);

        return save(dto);
    }

    //Método para salvar e atualizar entidades das vendas
    public void updateValuesSale(SaleDTO newObj, SaleDTO oldObj){
        newObj.setClient(oldObj.getClient());
        newObj.setBookPurchase(oldObj.getBookPurchase());
        newObj.setValuePurchase(oldObj.getValuePurchase());
        newObj.setDatePurchase(oldObj.getDatePurchase());
        newObj.setStatus(oldObj.getStatus());

    }
}
