package br.com.phoebustecnologia.Library.services.categoryTestService;

import br.com.phoebustecnologia.Library.dto.CategoryDTO.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;

public class CategoryTestBuilder {

    public static Category.Builder createdCategory(){
        return Category.builder()
                .id(1L)
                .name("category");
    }
    public static CategoryDTO.CategoryDTOBuilder createdCategoryDTO(){
        return CategoryDTO.builder()
                .name("category");
    }
    public static Category.Builder createdSavedCategory(){
        return Category.builder()
                .name("category");
    }

}
