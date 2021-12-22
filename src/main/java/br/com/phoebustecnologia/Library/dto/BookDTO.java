package br.com.phoebustecnologia.Library.dto;

import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Category;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(builderClassName = "Builder")
public class BookDTO implements Serializable {


    private static final long SerialVersionID = 1L;

    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String synopsis;
    @NotNull
    private String isbn;

    @NotNull
    private String author;

    @NotNull
    private LocalDate publicationYear;

    @NotNull
    private Double priceSell;

    @NotNull
    private Integer availableQuantity;

    @NotNull
    private Set<Category> categories;

    public static  BookDTO bookDTO( Book bookEntity){
        return BookDTO
                .builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .isbn(bookEntity.getIsbn())
                .synopsis(bookEntity.getSynopsis())
                .author(bookEntity.getAuthor())
                .publicationYear(bookEntity.getPublicationYear())
                .categories(bookEntity.getCategories())
                .priceSell(bookEntity.getPriceSell())
                .availableQuantity(bookEntity.getAvailableQuantity())
                .build();
    }

    public static List<BookDTO> ListFromAllBooks (List<Book> books) {
        return books.stream().map(BookDTO::bookDTO).collect(Collectors.toList());
    }

}