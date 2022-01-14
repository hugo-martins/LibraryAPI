package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.services.CategoryServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return categoryServices.findAll();
    }

    @ApiOperation("Find an category by ID")
    @GetMapping(value = "/{id}")
    public CategoryDTO findCategoryByID(@PathVariable Long id) throws Throwable {
        return categoryServices.findById(id);

    }

    @ApiOperation("Save an category")
    @PostMapping
    public void addCategory(@RequestBody CategoryDTO category) {
        categoryServices.save(category) ;

    }

    @ApiOperation("Delete on category")
    @DeleteMapping(value = "/{id}")
    public void  deleteCategory(@PathVariable Long id) {
        categoryServices.delete(id);

    }

    @ApiOperation("Update on category")
    @PutMapping(value = "/{id}")
    public void updateCategory(@RequestBody @NotNull CategoryDTO categoryDTO, @PathVariable Long id) throws Throwable {
        categoryDTO.setId(id);
        categoryServices.update(categoryDTO);

    }
}
