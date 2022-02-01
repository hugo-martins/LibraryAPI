package br.com.phoebustecnologia.Library.controller.categoryTest;

import br.com.phoebustecnologia.Library.dto.CategoryDTO.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;

public class CategoryBuilder {

    public static Category.Builder createdCategory(){
        return Category.builder()
                .name("category");
    }
    public static CategoryDTO.CategoryDTOBuilder createdCategoryDTO(){
        return CategoryDTO.builder()
                .name("category");
    }
}
