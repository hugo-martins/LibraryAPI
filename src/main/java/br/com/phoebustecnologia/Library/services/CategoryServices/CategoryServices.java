package br.com.phoebustecnologia.Library.services.CategoryServices;

import br.com.phoebustecnologia.Library.dto.CategoryDTO.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;

import java.util.List;


public interface CategoryServices  {


    //Listar categoria
    List<CategoryDTO> findAll();

    //Pesquisar Categoria por ID
    CategoryDTO findById(Long id);

    //Deletar categoria
     void delete(Long id);

    //Salvar categoria
    CategoryDTO save(CategoryDTO categoryDTO);

    //Atualizar categoria
    CategoryDTO update(Long id, CategoryDTO category);

}
