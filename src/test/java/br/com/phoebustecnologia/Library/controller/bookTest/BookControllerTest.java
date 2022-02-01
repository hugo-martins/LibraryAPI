package br.com.phoebustecnologia.Library.controller.bookTest;

import br.com.phoebustecnologia.Library.Repositories.BookRepository;
import br.com.phoebustecnologia.Library.Repositories.CategoryRepository;
import br.com.phoebustecnologia.Library.controller.BookController;
import br.com.phoebustecnologia.Library.controller.CategoryController;
import br.com.phoebustecnologia.Library.dto.BookDTO.BookDTO;
import br.com.phoebustecnologia.Library.services.BookServices.BookServices;
import br.com.phoebustecnologia.Library.services.BookServices.BookServicesImpl;
import br.com.phoebustecnologia.Library.services.CategoryServices.CategoryServicesImpl;
import br.com.phoebustecnologia.Library.services.bookTestService.BookTestBuilder;
import org.assertj.core.util.Lists;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServicesImpl bookServicesImpl;

    @MockBean
    private BookRepository bookRepository;

    @Mock
    private BookController bookController;


    private final String URL = "/api/book";


    void setup(){
        bookServicesImpl = Mockito.mock(BookServicesImpl.class);
    }



}