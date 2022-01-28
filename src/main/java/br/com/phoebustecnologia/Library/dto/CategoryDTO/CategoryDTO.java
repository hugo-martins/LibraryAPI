package br.com.phoebustecnologia.Library.dto.CategoryDTO;

import br.com.phoebustecnologia.Library.model.Category;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private static final long SerialVersionID = 1L;

    private Long id;

    @NotNull
    private String name;

    public static CategoryDTO categoryDTO (Category categoryEntity){
        return builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }

    public static List<CategoryDTO> categoriesFromAll(List<Category> categories) {
        return categories.stream().map(CategoryDTO::categoryDTO).collect(Collectors.toList());
    }

    public static CategoryDTO categorySavedDTO (Category categoryEntity){
        return builder()
                .name(categoryEntity.getName())
                .build();
    }
    public void categoryUpdateDTO (Category categoryEntity){

    }

}
