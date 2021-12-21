package br.com.phoebustecnologia.Library.model;

import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
@Table(name = "Categories")
public class Category implements Serializable {

    private static final long SerialVersionID =  1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "categories")
    private final Set<Book> books = new HashSet<>();

    public static Category categoryFrom(CategoryDTO categoryDTO){
        return builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

}
