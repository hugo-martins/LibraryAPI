package br.com.phoebustecnologia.Library.controller.bookTest;


import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Category;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BookTest {

    public static Book.BookBuilder createdBook(){
        Category test1 = new Category(1L,"Nome categoria");
        Set<Category> newCategory = new HashSet<>();
        newCategory.add(test1);
        return Book.builder()
                .id(1L)
                .title("Título")
                .synopsis("Texto")
                .isbn("152165-15544")
                .author("Autor")
                .publicationYear(LocalDate.of(2000,12,30) )
                .priceSell(100.00)
                .availableQuantity(2)
                .categories(newCategory);

    }

    public static Book.BookBuilder createdBookDTO(){
        Category test1 = new Category(1L,"Nome categoria");
        Set<Category> newCategory = new HashSet<>();
        newCategory.add(test1);
        return Book.builder()
                .id(1L)
                .title("Título")
                .synopsis("Texto")
                .isbn("152165-15544")
                .author("Autor")
                .publicationYear(LocalDate.of(2000,12,30) )
                .priceSell(100.00)
                .availableQuantity(2)
                .categories(newCategory);
    }
}
