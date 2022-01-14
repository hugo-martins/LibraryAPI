package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.BookRepository;
import br.com.phoebustecnologia.Library.dto.BookDTO;
import br.com.phoebustecnologia.Library.exceptions.BookExistException;
import br.com.phoebustecnologia.Library.exceptions.BookNotFoundException;
import br.com.phoebustecnologia.Library.model.Category;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServices  {



    @Autowired
    BookRepository bookRepository;

    //Listar todos os livros
    public List<BookDTO> findAll() {
        return BookDTO.ListFromAllBooks(bookRepository.findAll());
    }


    //Pesquisar lista de livros
    public List<BookDTO> findByCategoryId(Long idCat){
        return BookDTO.ListFromAllBooks(bookRepository.findByCategoryId(idCat));
    }

    //Pesquisar livro por ID;
    //Correção para retorno de um book DTO
    public BookDTO findById(Long id) throws Throwable {
        return (BookDTO) bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

    }

    //Salvar Livro
    public BookDTO save(BookDTO book){
        if(book.getId()!=null) {
            throw new BookExistException();
        }
        Set<Category> categorySet = new HashSet<>(book.getCategories());
        book.setCategories(categorySet);
        return bookRepository.save(book);


    }

    //Deletar Livro
    public void delete(Long id){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
    }

    //Atualizar Livro
    public BookDTO update(@NotNull BookDTO book) throws Throwable{
        if(!bookRepository.existsById(book.getId())){
            throw new BookNotFoundException();
        }
        BookDTO obj = findById(book.getId());
        updateValuesBook(obj, book);
        bookRepository.save(obj);
        return obj;
    }

    //Método para salvar e atualizar entidades dos livros
    public void updateValuesBook(BookDTO newObj, BookDTO oldObj){
        newObj.setCategories(oldObj.getCategories());
        newObj.setTitle(oldObj.getTitle());
        newObj.setIsbn(oldObj.getIsbn());
        newObj.setAuthor(oldObj.getAuthor());
        newObj.setSynopsis(oldObj.getSynopsis());
        newObj.setPublicationYear(oldObj.getPublicationYear());
        newObj.setAvailableQuantity((oldObj.getAvailableQuantity()));
        newObj.setPriceSell(oldObj.getPriceSell());

        }
}
