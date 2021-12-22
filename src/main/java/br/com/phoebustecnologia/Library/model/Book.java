package br.com.phoebustecnologia.Library.model;

import br.com.phoebustecnologia.Library.dto.BookDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books")
@Builder

public class Book implements Serializable {

    private static final long SerialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String title;

    private String synopsis;

    private String isbn;

    private String author;

    private LocalDate publicationYear;

    private Double priceSell;

    private Integer availableQuantity;


    @OneToMany(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private Set<Category> categories = new HashSet<>();

    public static Book bookFrom(BookDTO bookDTO) {
        return Book
                .builder()
                .id(bookDTO.getId())
                .title(bookDTO.getTitle())
                .isbn(bookDTO.getIsbn())
                .synopsis(bookDTO.getSynopsis())
                .author(bookDTO.getAuthor())
                .publicationYear(bookDTO.getPublicationYear())
                .categories(bookDTO.getCategories())
                .priceSell(bookDTO.getPriceSell())
                .availableQuantity(bookDTO.getAvailableQuantity())
                .build();
    }

}
