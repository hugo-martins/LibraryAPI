package br.com.phoebustecnologia.Library.controller.categoryTest;

import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.controller.CategoryController;
import br.com.phoebustecnologia.Library.model.Category;
import br.com.phoebustecnologia.Library.services.CategoryServices;
import br.com.phoebustecnologia.Library.services.categoryTestService.CategoryTestBuilder;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CategoryController.class)
@DisplayName("Tests controller of Category")
public class CategoryTestController {
/*
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CategoryServices categoryServices;

    @MockBean
    private CategoryController categoryController;

    private final String URL = "/api/category";




    @Test
    @DisplayName("Should return all categories")
    void ShouldReturnListAllCategories() throws Exception {

        when(categoryServices.findAll()).thenReturn(
                Lists.newArrayList(
                        CategoryBuilder.createdCategory().name("category").build(),
                        CategoryBuilder.createdCategory().name("category2").build()
                ));


        mockMvc.perform(get(URL + "/all").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].name", Matchers.is("category")))
                .andExpect(jsonPath("$[1].name", Matchers.is("category2"))

                );

    }
    @Test
    @DisplayName("Should return one category")
    void shouldReturnCategoryById() throws Exception{

        Long id = anyLong();

        Optional<Category> categoryCreated = Optional.of(CategoryBuilder.createdCategory().build());

        when(categoryServices.findById(id))
                .thenReturn(CategoryBuilder.createdCategory()
                        .name("category")
                        .build());

        mockMvc.perform(get(URL + "/{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.is("category"))
                );
    }

    /*@Test
    @DisplayName("Should save an Category")
    void shouldSaveCategory() throws Exception {
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(readJson("Category.json")))
                .andDo(print())
                .andExpect(status().isCreated()
                );

    }*/

    /*@Test
    @DisplayName("Should update an Category")
    void shouldUpdateCategory() throws Exception {
        mockMvc.perform(put(URL + "/{id}")
                        .content(readJson("Category.json"))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }

    @Test
    @DisplayName("Should delete an Category")
    void shouldRemoveCategory() throws Exception {
        mockMvc.perform(delete(URL + "/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());

    }
    public static String readJson(String file) throws Exception {
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/java/resources/json/" + file).toAbsolutePath());
        return new String(bytes);
    }
*/
}



