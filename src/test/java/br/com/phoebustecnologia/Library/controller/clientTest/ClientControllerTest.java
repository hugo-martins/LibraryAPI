package br.com.phoebustecnologia.Library.controller.clientTest;


import br.com.phoebustecnologia.Library.controller.ClientController;
import br.com.phoebustecnologia.Library.services.ClientServices.ClientServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@DisplayName("Test all implements ClientController")
@WebMvcTest(controllers = ClientController.class)
public class ClientControllerTest {


    @Autowired
    private MockMvc mockMvc;


    //private ClientController clientController;

    @Mock
    private ClientServices clientServices;


    @BeforeEach
    public void setup(){


    }
/*
    @Test
    @DisplayName("Find All client")
    void findListAllClient() throws Exception {
        when(clientServices.findClientAll())
                .thenReturn(Lists.newArrayList(
                        ClientTest.createClient().id(1L).name("test1").sex(SexClient.MASCULINE).phone("5415-6515").email("emailteste@test.com").build()
                ));


        mockMvc.perform(MockMvcRequestBuilders.get("/api/client/all", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(1L)))
                .andExpect(jsonPath("$[0].name", is("test1")))
                .andExpect(jsonPath("$[0].sex", is("MASCULINE")))
                .andExpect(jsonPath("$[0].phone", is("5415-6515")))
                .andExpect(jsonPath("$[0].email",is("emailteste@test.com")));

        verify(clientServices).findClientAll();
    }


    @Test
    @DisplayName("Find Client by id")
    void findClientById() throws Exception{
        when(clientServices.clientsByID(1L))
                .thenReturn(ClientTest.createClient()
                        .id(1L)
                        .name("test1")
                        .phone("5415-6515")
                        .email("emailteste@test.com")
                        .age(23)
                        .build());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/client/{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("test1")))
                .andExpect(jsonPath("$.sex", is("Masculine")))
                .andExpect(jsonPath("$.phone", is ("5415-6515")))
                .andExpect(jsonPath("$.age", is(23)))
                .andExpect(jsonPath("$.email", is("emailteste@test.com"))
                );
        verify(clientServices, times(1)).findById(anyLong());

    }


    @BeforeEach
    public void setup(){
        standaloneSetup(this.clientController);
    }

    @Test
    void findListAllClient(){
        when(this.clientServices.findClientAll()).thenReturn(new ArrayList<>(ClientTest.createClient()
                .id(1L)
                .name("test1")
                .sex(SexClient.MASCULINE)
                .phone("5415-6515")
                .email("emailteste@test.com")
                .build()
        ));

        given()
                .accept(ContentType.JSON)
                .when()
                    .get("/api/client/all", 1L)
                .then()
                    .statusCode(HttpStatus.SC_OK);
    }
    */

}
