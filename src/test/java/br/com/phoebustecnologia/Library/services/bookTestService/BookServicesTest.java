package br.com.phoebustecnologia.Library.services.bookTestService;

import br.com.phoebustecnologia.Library.Repositories.BookRepository;
import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.services.BookServices;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Test Book Service")
class BookServicesTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServices bookServices;


    @BeforeEach
    void setUp() {
    }


    @Test
    @DisplayName("Should return all books")
    void ShouldFindAllBooks() {

        when(bookRepository.findAll()).thenReturn(
                Stream.of(BookTestBuilder.createdBook().title("bookTest1").build(),
                        BookTestBuilder.createdBook().title("bookTest2").build()).collect(Collectors.toList())
        );

        List<Book> bookList = bookRepository.findAll();

        assertAll("Books",
                () -> assertThat(bookList.size(), is(2)),
                () -> assertThat(bookList.get(0).getTitle(), is("bookTest1")),
                () -> assertThat(bookList.get(0).getAuthor(), is("Author")),
                () -> assertThat(bookList.get(1).getTitle(), is("bookTest2")),
                () -> assertThat(bookList.get(1).getAuthor(), is("Author"))

        );

    }

    @Test
    @DisplayName("Should return book by Category")
    void ShouldFindByCategoryId() {
        when(bookRepository.findAll()).thenReturn(
                Stream.of(BookTestBuilder.createdBook().title("bookTest1").build(),
                        BookTestBuilder.createdBook().title("bookTest2").build()).collect(Collectors.toList())
        );

        List<Book> bookList = bookRepository.findAll();

        assertAll("Books",
                () -> assertThat(bookList.size(), is(2)),
                () -> assertThat(bookList.get(0).getTitle(), is("bookTest1")),
                () -> assertThat(bookList.get(0).getAuthor(), is("Author")),
                () -> assertThat(bookList.get(1).getTitle(), is("bookTest2")),
                () -> assertThat(bookList.get(1).getAuthor(), is("Author"))

        );
    }

    @Test
    @DisplayName("Should return book by Id")
    void ShouldFindById() {

        Long id = anyLong();

        Optional<Book> bookCreated = Optional.of(BookTestBuilder.createdBook().build());
        when(bookRepository.findById(id)).thenReturn(bookCreated);
        Book bookSalved = bookServices.findById(id);

        assertAll("Book",
                () -> assertThat(bookSalved.getTitle(), is("Título")),
                () -> assertThat(bookSalved.getAuthor(), is("Author")),
                () -> assertThat(bookSalved.getIsbn(), is("152165-15544")),
                () -> assertThat(bookSalved.getSynopsis(), is("Texto")),
                () -> assertThat(bookSalved.getPublicationYear(), is(LocalDate.of(2000, 12, 30))),
                () -> assertThat(bookSalved.getAvailableQuantity(), is(2))
        );

    }

    @Test
    @DisplayName("Should save a book")
    void ShouldSaveBook() {
        Book mock = BookTestBuilder.createdBook().build();
        when(bookRepository.save(mock)).thenReturn(mock);
        Book book = bookServices.save(mock);


        assertAll("Book",
                () -> assertThat(book.getTitle(), is("Título")),
                () -> assertThat(book.getAuthor(), is("Author")),
                () -> assertThat(book.getIsbn(), is("152165-15544")),
                () -> assertThat(book.getAvailableQuantity(), is(2)),
                () -> assertThat(book.getSynopsis(), is("Texto")),
                () -> assertThat(book.getCategories().size(), is(1)),
                () -> assertThat(book.getPriceSell(), is(100.00))
        );

    }

    @Test
    @DisplayName("Should delete a Book")
    void ShouldDeleteBook() {

        when(bookRepository.existsById(anyLong())).thenReturn(true);
        bookServices.delete(1L);
        verify(bookRepository).existsById(anyLong());
    }

    @Test
    @DisplayName("Should updated books to List")
    void update_whenSuccessful() {

        Book book = BookTestBuilder.createdBook().id(2L).build();

        Optional<Book> OBook = Optional.of(book);

        when(bookRepository.existsById(2L)).thenReturn(true);
        when(bookRepository.findById(anyLong())).thenReturn(OBook);

        book.setTitle("Development");

        when(bookRepository.save(book)).thenReturn(book);

        Book bookResult = bookServices.update(book);

        assertAll("Book",
                () -> assertThat(bookResult.getTitle(), Matchers.is("Development")));
    }

}