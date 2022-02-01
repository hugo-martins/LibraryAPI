package br.com.phoebustecnologia.Library.controller.categoryTest;

import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.controller.CategoryController;
import br.com.phoebustecnologia.Library.dto.CategoryDTO.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;
import br.com.phoebustecnologia.Library.services.CategoryServices.CategoryServicesImpl;
import br.com.phoebustecnologia.Library.services.categoryTestService.CategoryTestBuilder;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CategoryController.class)
@DisplayName("Tests controller of Category")
public class CategoryTestController {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryServicesImpl categoryServicesImpl;

    @MockBean
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryController categoryController;


    private final String URL = "/api/category";


    void setup(){
        categoryServicesImpl = Mockito.mock(CategoryServicesImpl.class);
    }

    @Test
    @DisplayName("Should return all categories")
    void ShouldReturnListAllCategories() throws Exception {

        when(categoryServicesImpl.findAll()).thenReturn(
                Stream.of(
                        CategoryBuilder.createdCategoryDTO().name("category").build(),
                        CategoryBuilder.createdCategoryDTO().name("category2").build())
                        .collect(Collectors.toList())
        );

        mockMvc.perform(MockMvcRequestBuilders.get(URL + "/all").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.is("category")))
                .andExpect(jsonPath("$[1].name", Matchers.is("category2"))

                );

    }

    @Test
    @DisplayName("Should return one category")
    void shouldReturnCategoryById() throws Exception {

        Long id = anyLong();

        Optional<CategoryDTO> categoryCreated = Optional.of(CategoryBuilder.createdCategoryDTO().build());

        when(categoryServicesImpl.findById(id))
                .thenReturn(CategoryBuilder.createdCategoryDTO().build());

        mockMvc.perform(get(URL + "/{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("category"))
                );
    }

    @Test
    @DisplayName("Should save an Category")
    void shouldSaveCategory() throws Exception {
        Category category = CategoryTestBuilder.createdCategory().build();

        when(categoryRepository.save(ArgumentMatchers.any(Category.class)))
                .thenReturn(CategoryTestBuilder.createdSavedCategory().build());

        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(readJson("CategoryDTO.json")))
                .andDo(print())
                .andExpect(status().isOk()
                );

    }
/*
    @Test
    @DisplayName("Should update an Category")
    void shouldUpdateCategory() throws Exception {

        Category categoryToUpdate = CategoryTestBuilder.createdCategory().build();

        Optional<Category> categoryOptional  = Optional.of(categoryToUpdate);

        when(categoryRepository.findById(anyLong())).thenReturn(categoryOptional);

        categoryToUpdate.setName("ação");

        when(categoryRepository.save(ArgumentMatchers.any(Category.class))).thenReturn(categoryToUpdate);

        mockMvc.perform(put(URL + "/{id}")
                        .content(readJson("CategoryDTO.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }
*/
    @Test
    @DisplayName("Should delete an Category")
    void shouldRemoveCategory() throws Exception {
        mockMvc.perform(delete(URL + "/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


    }


    public static String readJson(String file) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/resources/json/" + file).toAbsolutePath());
        return new String(bytes);
    }

}



