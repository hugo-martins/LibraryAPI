package br.com.phoebustecnologia.Library.dto;

import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Category;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private static final long SerialVersionID = 115645145L;

    private long id;
    private String name;

    public static CategoryDTO categoryDTO (Category categoryEntity){
        return builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }
    public static List<CategoryDTO> categoriesAll(List<Category> categories) {
        return categories.stream().map(CategoryDTO::categoryDTO).collect(Collectors.toList());
    }
}
