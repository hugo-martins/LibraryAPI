package br.com.phoebustecnologia.Library.services;

import br.com.phoebustecnologia.Library.Repositories.BookRepository;
import br.com.phoebustecnologia.Library.exceptions.BookExistException;
import br.com.phoebustecnologia.Library.exceptions.BookNotFoundException;
import br.com.phoebustecnologia.Library.model.Book;
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
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    //Pesquisar lista de livros
    public List<Book> findByCategoryId(Long idCat){
        return bookRepository.findByCategoryId(idCat);
    }

    //Pesquisar livro por ID;
    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);

    }

    //Salvar Livro
    public Book save(Book book){
        if(book.getId()!=null) {
            throw new BookExistException();

        }
        Set<Category> categorySet = new HashSet<>(book.getCategories());
        book.setCategories(categorySet);
        Book b = bookRepository.save(book);
        return  b;

    }

    //Deletar Livro
    public void delete(Long id){
        if(!bookRepository.existsById(id)){
            throw new BookNotFoundException();
        }
        bookRepository.deleteById(id);
    }

    //Atualizar Livro
    public Book update(@NotNull Book book){
        if(!bookRepository.existsById(book.getId())){
            throw new BookNotFoundException();
        }
        Book obj = findById(book.getId());
        updateValuesBook(obj, book);
        bookRepository.save(obj);

        return obj;
    }

    //Método para salvar e atualizar entidades dos livros
    public void updateValuesBook(Book newObj, Book oldObj){
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
