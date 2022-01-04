package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.exceptions.CategoryNotFoundException;
import br.com.phoebustecnologia.Library.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices  {


    @Autowired
    private CategoryRepository categoryRepository;

    //Listar categoria
    public List<Category> findAll(){
        return categoryRepository.findAll();

    }

    //Pesquisar Categoria por ID
    public Category findById(Long id) {
        return  categoryRepository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    //Deletar categoria
    public void delete(Long id){
        if(!categoryRepository.existsById(id)){
            throw new CategoryNotFoundException();
        }
        categoryRepository.deleteById(id);
    }

    //Salvar categoria
    public Category save(Category category){
        return categoryRepository.save(category);
    }

    //Atualizar livro
    public Category update(Category category){
        if(!categoryRepository.existsById(category.getId())){
            throw new CategoryNotFoundException();
        }
        Category obj = findById(category.getId());
        updateValues(obj, category);
        return categoryRepository.save(obj);
    }

    public void updateValues(Category newObj, Category oldObj){newObj.setName(oldObj.getName());}
}
