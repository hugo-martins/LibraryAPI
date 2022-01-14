package br.com.phoebustecnologia.Library.services.categoryTestService;

import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;
import br.com.phoebustecnologia.Library.services.CategoryServices;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Category Service")
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServices categoryServices;


    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Should return all categories")
    void ShouldFindAllBCategories() {

        when(categoryRepository.findAll()).thenReturn(
                Stream.of(CategoryTestBuilder.createdCategory().name("category").build(),
                        CategoryTestBuilder.createdCategory().name("category2").build())
                        .collect(Collectors.toList())
        );

        List<Category> categoryList = categoryRepository.findAll();

        assertAll("Categories",
                () -> assertThat(categoryList.size(), is(2)),
                () -> assertThat(categoryList.get(0).getName(), is("category")),
                () -> assertThat(categoryList.get(1).getName(), is("category2"))
        );
    }

    @Test
    @DisplayName("Should return category by Id")
    void ShouldFindById() throws Throwable {

        Long id = anyLong();

        Optional<CategoryDTO> categoryCreated = Optional.of(CategoryTestBuilder.createdCategoryDTO().build());
        when(categoryRepository.findById(id)).thenReturn(categoryCreated);
        CategoryDTO categorySaved = categoryServices.findById(id);

        assertAll("Category",
                () -> assertThat(categorySaved.getName(), is("category"))

        );

    }

    @Test
    @DisplayName("Should save a category")
    void ShouldSaveBook() {
        CategoryDTO mock = CategoryTestBuilder.createdCategoryDTO().build();
        when(categoryRepository.save(mock)).thenReturn(mock);
        CategoryDTO category = categoryServices.save(mock);


        assertAll("Category",
                () -> assertThat(category.getName(), is("category"))
        );
    }

    @Test
    @DisplayName("Should delete a Category")
    void ShouldDeleteBook() {

        when(categoryRepository.existsById(anyLong())).thenReturn(true);
        categoryServices.delete(1L);
        verify(categoryRepository).existsById(anyLong());
    }

    @Test
    @DisplayName("Should updated categories to List")
    void update_whenSuccessful() throws Throwable {

        CategoryDTO category = CategoryTestBuilder.createdCategoryDTO().id(1L).build();

        Optional<CategoryDTO> categoryOpt = Optional.of(category);

        when(categoryRepository.existsById(1L)).thenReturn(true);
        when(categoryRepository.findById(anyLong())).thenReturn(categoryOpt);

        category.setName("Romance");

        when(categoryServices.save(category)).thenReturn(category);

        CategoryDTO categoryResult = categoryServices.update(category);

        assertAll("Category",
                () -> assertThat(categoryResult.getName(), Matchers.is("Romance"))
        );
    }


}

