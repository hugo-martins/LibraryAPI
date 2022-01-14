package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.BookDTO;
import br.com.phoebustecnologia.Library.services.BookServices;
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
    BookServices bookServices;


    @ApiOperation("Get all book")
    @GetMapping(path = "/all")
    public List<BookDTO> findAll() {
        return bookServices.findAll();
    }

    @ApiOperation("Get a book")
    @GetMapping(value = "/{id}")
    public BookDTO bookListById(@PathVariable Long id) throws Throwable {
        return bookServices.findById(id);

    }

    @ApiOperation("List an books by category")
    @GetMapping(value = "/category/{id}")
    public List<BookDTO> bookListByCategory(@RequestParam(value = "category", defaultValue = "0") Long idCat) {
        return bookServices.findByCategoryId(idCat);
    }

    @ApiOperation("Save an book")
    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookServices.save(bookDTO);
    }

    @ApiOperation("Delete an Book")
    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServices.delete(id);

    }

    @ApiOperation("Update an book")
    @PutMapping(value = "/{id}")
    public void updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long id) throws Throwable{
        bookDTO.setId(id);
        bookServices.update(bookDTO);
    }
}
