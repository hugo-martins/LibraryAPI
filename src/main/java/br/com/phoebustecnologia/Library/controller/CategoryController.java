package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;
import br.com.phoebustecnologia.Library.services.CategoryServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
@Api(value = "API REST Category ")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryServices categoryServices;

    @ApiOperation("List of category")
    @GetMapping(value = "/all")
    public List<CategoryDTO> categoryList() {
        return CategoryDTO.categoriesAll(categoryServices.findAll());
    }

    @ApiOperation("Find an category by ID")
    @GetMapping(value = "/{id}")
    public CategoryDTO findCategoryByID(@PathVariable Long id){
        return CategoryDTO.categoryDTO(categoryServices.categoryById(id));

    }

    @ApiOperation("Save an category")
    @PostMapping
    public void addCategory(@RequestBody CategoryDTO category) {
        categoryServices.saveCategory(Category.categoryFrom(category)) ;

    }

    @ApiOperation("Delete on category")
    @DeleteMapping(value = "/{id}")
    public void  deleteCategory(@PathVariable Long id) {
        categoryServices.deleteCategory(id);

    }

    @ApiOperation("Update on category")
    @PutMapping(value = "/{id}")
    public void updateCategory(@RequestBody CategoryDTO category, @PathVariable Long id) {
        category.setId(id);
        categoryServices.updateCategory(Category.categoryFrom(category));

    }
}
