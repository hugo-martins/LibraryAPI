package br.com.phoebustecnologia.Library.services.BookServices;

import br.com.phoebustecnologia.Library.Repositories.BookRepository;
import br.com.phoebustecnologia.Library.dto.BookDTO.BookDTO;
import br.com.phoebustecnologia.Library.exceptions.BookNotFoundException;
import br.com.phoebustecnologia.Library.model.Book;
import br.com.phoebustecnologia.Library.model.Category;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookServicesImpl implements BookServices{

    private final BookRepository bookRepository;

    public BookServicesImpl(BookRepository bookRepository) {
        super();
        this.bookRepository = bookRepository;
    }

    //Listar livros
    @Override
    public List<BookDTO> findAll(){
        return BookDTO.ListFromAllBooks(bookRepository.findAll());
    }


    //Pesquisar Book por ID
    @Override
    public BookDTO findById(Long id){
        Book result = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return BookDTO.bookDTO(result);
    }


    //Pesquisar lista de livros
    public List<BookDTO> findByCategoryId(Long idCat){
        return BookDTO.ListFromAllBooks(bookRepository.findByCategoryId(idCat));
    }


    //Deletar livro
    @Override
    public void delete(Long id){
        Book book =  bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        bookRepository.delete(book);
    }

    //Salvar livro
    @Override
    public BookDTO save(BookDTO bookDTO){
        Book book =  bookRepository.save(Book.bookSaved(bookDTO));
        Set<Category> categorySet = new HashSet<>(book.getCategories());
        book.setCategories(categorySet);
        return BookDTO.bookSavedDTO(book);
    }

    //Atualizar livro
    public BookDTO update(Long id, BookDTO bookRequest)  {
        Book book =  bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        BookDTO dto = BookDTO.bookDTO(book);
        updateValuesBook(dto, bookRequest);

        return save(dto);
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
