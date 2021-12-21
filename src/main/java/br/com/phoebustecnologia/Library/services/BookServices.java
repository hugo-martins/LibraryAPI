package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.BookRepository;
import br.com.phoebustecnologia.Library.dto.BookDTO;
import br.com.phoebustecnologia.Library.exceptions.BookNotFoundException;
import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServices  {

    @Autowired
    private BookRepository bookRepository;


    //Listar todos os livros
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //Pesquisar lista de livros
    public List<Book> findByCategoryId(Long idCat){
        return bookRepository.findByCategoryId(idCat);
    }

    //Pesquisar livro por ID;
    public Book bookByID(Long id){
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    //Salvar Livro
    public void save(Book book){
        if(!bookRepository.existsById(book.getId())){
            throw new BookNotFoundException();
        }
        Set<Category> categorySet = new HashSet<>(book.getCategories());
        book.setCategories(categorySet);
        bookRepository.save(book);

    }

    //Deletar Livro
    public void delete(Long id){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
    }

    //Atualizar Livro
    public void update(BookDTO bookDTO){
        if(!bookRepository.existsById(bookDTO.getId())){
            throw new BookNotFoundException();
        }
        Book obj = bookByID(bookDTO.getId());
        updateValuesBook(obj, bookDTO);
        bookRepository.save(obj);

    }

    //Método para salvar e atualizar entidades dos livros
    public void updateValuesBook(BookDTO newObj, BookDTO oldObj){
        newObj.setCategories(oldObj.getCategories());
        newObj.setTitle(oldObj.getTitle());
        newObj.setIsbn(oldObj.getIsbn());
        newObj.setAuthor(oldObj.getAuthor());
        newObj.setSynopsis(oldObj.getSynopsis());
        newObj.setPublicationYear(oldObj.getPublicationYear());
        newObj.setQuantAvailable(oldObj.getQuantAvailable());
        newObj.setPriceSell(oldObj.getPriceSell());

        }
}
