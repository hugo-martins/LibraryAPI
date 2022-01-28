package br.com.phoebustecnologia.Library.services.BookServices;

import br.com.phoebustecnologia.Library.dto.BookDTO.BookDTO;

import java.util.List;

public interface BookServices  {

    //Listar livros
    List<BookDTO> findAll();

    //Pesquisar livros por ID
    BookDTO findById(Long id);

    List<BookDTO> findByCategoryId(Long id);

    //Deletar livros
    void delete(Long id);

    //Salvar categoria
    BookDTO save(BookDTO bookDTO);

    //Atualizar categoria
    BookDTO update(Long id, BookDTO bookDTO);




}
