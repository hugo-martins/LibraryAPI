package br.com.phoebustecnologia.Library.services.CategoryServices;

import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.dto.CategoryDTO.CategoryDTO;
import br.com.phoebustecnologia.Library.exceptions.CategoryNotFoundException;
import br.com.phoebustecnologia.Library.model.Category;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryServices {


    private final CategoryRepository categoryRepository;



    public CategoryServicesImpl(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }


    //Listar categoria
    @Override
    public List<CategoryDTO> findAll(){
        return CategoryDTO.categoriesFromAll(categoryRepository.findAll());
    }


    //Pesquisar Categoria por ID
    @Override
    public CategoryDTO findById(Long id){
        Category result = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        return CategoryDTO.categoryDTO(result);
    }

    //Deletar categoria
    @Override
    public void delete(Long id){
        Category category =  categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(category);
    }


    //Salvar categoria
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO){
        Category categorySaved = categoryRepository.save(Category.categorySaved(categoryDTO));
        return CategoryDTO.categorySavedDTO(categorySaved);
    }


    //Atualizar categoria
    public CategoryDTO update(Long id, CategoryDTO categoryRequest)  {
        Category category =  categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        CategoryDTO dto = CategoryDTO.categoryDTO(category);
        updateValues(dto,categoryRequest);
        return save(dto);
    }

    //Captura um objeto antigo e atualiza para um novo
    public void updateValues(@NotNull CategoryDTO newObj, CategoryDTO oldObj){
        newObj.setName(oldObj.getName());
    }
}

