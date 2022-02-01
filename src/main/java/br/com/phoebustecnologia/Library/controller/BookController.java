package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.BookDTO.BookDTO;
import br.com.phoebustecnologia.Library.services.BookServices.BookServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
@Api(value = "API REST Book")
@CrossOrigin(origins = "*")
public class BookController {


    @Autowired
    BookServicesImpl bookServicesImpl;


    @ApiOperation("Get all book")
    @GetMapping(path = "/all")
    public List<BookDTO> findAll() {

        return bookServicesImpl.findAll();
    }

    @ApiOperation("Get a book")
    @GetMapping(value = "/{id}")
    public BookDTO bookListById(@PathVariable Long id){
        return bookServicesImpl.findById(id);

    }

    @ApiOperation("List an books by category")
    @GetMapping(value = "/category/{id}")
    public List<BookDTO> bookListByCategory(@RequestParam(value = "category", defaultValue = "0") Long idCat) {
        return bookServicesImpl.findByCategoryId(idCat);
    }

    @ApiOperation("Save an book")
    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookServicesImpl.save(bookDTO);
    }

    @ApiOperation("Delete an Book")
    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServicesImpl.delete(id);

    }

    @ApiOperation("Update an book")
    @PutMapping(value = "/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        bookServicesImpl.update(id, bookDTO);
    }
}
