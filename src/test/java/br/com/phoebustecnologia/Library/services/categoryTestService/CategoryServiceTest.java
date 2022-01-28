package br.com.phoebustecnologia.Library.services.categoryTestService;

import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.dto.CategoryDTO.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;
import br.com.phoebustecnologia.Library.services.CategoryServices.CategoryServicesImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Category Service")
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServicesImpl categoryServicesImpl;



    @BeforeEach
    void setUp() {
        this.categoryServicesImpl = new CategoryServicesImpl(categoryRepository);

    }

    @Test
    @DisplayName("Should return all categories")
    void ShouldFindAllBCategories() {

        when(categoryRepository.findAll()).thenReturn(
                Stream.of(CategoryTestBuilder.createdCategory().name("category").build(),
                                CategoryTestBuilder.createdCategory().name("category2").build())
                        .collect(Collectors.toList())
        );

        List<CategoryDTO> categoryList = categoryServicesImpl.findAll();

        assertAll("Categories",
                () -> assertThat(categoryList.size(), is(2)),
                () -> assertThat(categoryList.get(0).getName(), is("category")),
                () -> assertThat(categoryList.get(1).getName(), is("category2"))
        );
    }

    @Test
    @DisplayName("Should return category by Id")
    void ShouldFindById() {

        Long id = anyLong();

        Optional<Category> categoryCreated = Optional.of(CategoryTestBuilder.createdCategory().build());
        when(categoryRepository.findById(id)).thenReturn(categoryCreated);
        CategoryDTO categorySaved = categoryServicesImpl.findById(id);

        assertAll("Category",
                () -> assertThat(categorySaved.getName(), is("category"))

        );

    }

    @Test
    @DisplayName("Should save a category")
    void ShouldSavedCategory() {
        Category category = CategoryTestBuilder.createdSavedCategory().build();

        when(categoryRepository.save(ArgumentMatchers.any(Category.class)))
                .thenReturn(CategoryTestBuilder.createdSavedCategory().build());

        CategoryDTO dto = categoryServicesImpl.save(CategoryDTO.categorySavedDTO(category));

        assertAll("Category",
              () -> assertThat(dto.getName(), is("category")));

    }

    @Test
    @DisplayName("Should delete a Category")
    void ShouldDeleteCategory() {
        Long id = anyLong();
        Optional<Category> categoryCreated = Optional.of(CategoryTestBuilder.createdCategory().build());
        when(categoryRepository.findById(id)).thenReturn(categoryCreated);
        categoryServicesImpl.delete(1L);
    }


    @Test
    @DisplayName("Should updated categories to List")
    void update_whenSuccessful() {

        Category categoryToUpdate = CategoryTestBuilder.createdCategory().build();

        Optional<Category> categoryOptional  = Optional.of(categoryToUpdate);

        when(categoryRepository.findById(anyLong())).thenReturn(categoryOptional);

        categoryToUpdate.setName("ação");

        when(categoryRepository.save(ArgumentMatchers.any(Category.class))).thenReturn(categoryToUpdate);

        CategoryDTO categoryResult = categoryServicesImpl.update(1L, CategoryDTO.categoryDTO(categoryToUpdate));

        assertAll("Category",
                () -> assertThat(categoryResult.getName(), is("ação"))
        );
    }


}



