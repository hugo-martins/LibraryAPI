package br.com.phoebustecnologia.Library.controller.bookTest;

import br.com.phoebustecnologia.Library.services.BookServices;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @MockBean
    private BookServices bookServices;

    @Mock
    private MockMvc mockMvc;


    @Test
    void shouldFindAllBook() throws Exception {
        Mockito.when(bookServices.findAll()).thenReturn(
                Lists.newArrayList(
                BookTest.createdBook().id(1L).title("test1").author("author1").build(),
                BookTest.createdBook().id(2L).title("test2").author("author2").build()
        ));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/all").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].id", Matchers.is(1L)))
                .andExpect(jsonPath("$[0].title", Matchers.is("test1")))
                .andExpect(jsonPath("$[0].synopsis", Matchers.is("Texto")))
                .andExpect(jsonPath("$[0].isbn", Matchers.is("152165-15544")))
                .andExpect(jsonPath("$[0].author", Matchers.is("author1")))
                .andExpect(jsonPath("$[0].publicationYear", Matchers.is("2000-12-30")))
                .andExpect(jsonPath("$[0].priceSell", Matchers.is(100.00)))
                .andExpect(jsonPath("$[0].availableQuantity", Matchers.is(2)))
                .andExpect(jsonPath("$[0].categories.[0].id", Matchers.is(1L)))
                .andExpect(jsonPath("$[0].categories.[0].name", Matchers.is("Nome categoria")))
                .andExpect(jsonPath("$[1].id", Matchers.is(2L)))
                .andExpect(jsonPath("$[1].title", Matchers.is("test2")))
                .andExpect(jsonPath("$[1].synopsis", Matchers.is("Texto2")))
                .andExpect(jsonPath("$[1].isbn", Matchers.is("252165-15544")))
                .andExpect(jsonPath("$[1].author", Matchers.is("author2")))
                .andExpect(jsonPath("$[1].publicationYear", Matchers.is("2000-12-31")))
                .andExpect(jsonPath("$[1].priceSell", Matchers.is(200.00)))
                .andExpect(jsonPath("$[1].availableQuantity", Matchers.is(1)))
                .andExpect(jsonPath("$[1].categories.[0].id", Matchers.is(2L)))
                .andExpect(jsonPath("$[1].categories.[0].name", Matchers.is("Nome categoria2")));

    }

    @Test
    void bookListById() {
    }

    @Test
    void bookListByCategory() {
    }

    @Test
    void addBook() {
    }

    @Test
    void deleteBook() {
    }

    @Test
    void updateBook() {
    }
}