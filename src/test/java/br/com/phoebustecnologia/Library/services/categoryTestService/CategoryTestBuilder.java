package br.com.phoebustecnologia.Library.services.categoryTestService;

import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Category;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CategoryTestBuilder {

    public static Category.Builder createdCategory(){
        return Category.builder()
                .id(1L)
                .name("category");
    }
}
