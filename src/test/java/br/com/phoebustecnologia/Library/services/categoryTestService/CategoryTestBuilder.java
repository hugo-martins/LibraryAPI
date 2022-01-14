package br.com.phoebustecnologia.Library.services.categoryTestService;

import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;

public class CategoryTestBuilder {

    public static Category.Builder createdCategory(){
        return Category.builder()
                .id(1L)
                .name("category");
    }

    public static CategoryDTO.CategoryDTOBuilder createdCategoryDTO(){
        return CategoryDTO.builder()
                .id(1L)
                .name("category");
    }
}
