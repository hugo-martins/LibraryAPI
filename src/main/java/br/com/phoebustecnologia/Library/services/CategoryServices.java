package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.exceptions.CategoryExistException;
import br.com.phoebustecnologia.Library.exceptions.CategoryNotFoundException;
import br.com.phoebustecnologia.Library.exceptions.ClientExistException;
import br.com.phoebustecnologia.Library.model.Category;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices  {


    @Autowired
    private CategoryRepository categoryRepository;



    //Listar categoria
    public List<CategoryDTO> findAll(){
        return CategoryDTO.categoriesAll(categoryRepository.findAll());
    }


    //Pesquisar Categoria por ID
    public CategoryDTO findById(Long id) throws Throwable {
        return (CategoryDTO) categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    //Deletar categoria
    public void delete(Long id){
        if(!categoryRepository.existsById(id)){
            throw new CategoryNotFoundException();
        }
        categoryRepository.deleteById(id);
    }

    //Salvar categoria
    public CategoryDTO save(CategoryDTO category){
        if(category.getId()!=null){
            throw new CategoryExistException();
        }
        return  categoryRepository.save(category);
    }


    //Atualizar livro
    public CategoryDTO update(CategoryDTO category) throws Throwable {
        if(!categoryRepository.existsById(category.getId())){
            throw new CategoryNotFoundException();
        }
        CategoryDTO obj = findById(category.getId());
        updateValues(obj, category);
        categoryRepository.save(obj);
        return obj;
    }

    public void updateValues(@NotNull CategoryDTO newObj, CategoryDTO oldObj){
        newObj.setName(oldObj.getName());
    }

}
