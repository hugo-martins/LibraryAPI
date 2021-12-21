package br.com.phoebustecnologia.Library.Repositories;

import br.com.phoebustecnologia.Library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //Método para listar todos os livros determinado pela categoria.
    List<Book> findByCategoryId(@Param(value = "idCat") Long idCat);


}
