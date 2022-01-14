package br.com.phoebustecnologia.Library.Repositories;

import br.com.phoebustecnologia.Library.dto.BookDTO;
import br.com.phoebustecnologia.Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //Método para listar todos os livros determinado pela categoria.
    @Query(value = "SELECT B.* FROM BOOKS B\n" +
            "INNER JOIN BOOKS_CATEGORIES BC ON BC.BOOK_ID = B.ID\n" +
            "INNER JOIN CATEGORIES C ON C.ID=BC.CATEGORIES_ID\n" +
            "\n" +
            "WHERE C.ID = :idCat", nativeQuery = true)
    List<Book> findByCategoryId(@Param(value = "idCat") Long idCat);

    Optional findById(Long id);

    BookDTO save(BookDTO bookDTO);
}
