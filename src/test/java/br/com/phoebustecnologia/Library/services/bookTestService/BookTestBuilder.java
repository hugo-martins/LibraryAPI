package br.com.phoebustecnologia.Library.services.bookTestService;


import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Category;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BookTestBuilder {

    public static Book.BookBuilder createdBook(){
        Category test1 = new Category(1L,"Nome categoria");
        Set<Category> newCategory = new HashSet<>();
        newCategory.add(test1);
        return Book.builder()
                .title("Título")
                .synopsis("Texto")
                .isbn("152165-15544")
                .author("Author")
                .publicationYear(LocalDate.of(2000,12,30) )
                .priceSell(100.00)
                .availableQuantity(2)
                .categories(newCategory);

    }
}
