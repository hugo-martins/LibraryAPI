package br.com.phoebustecnologia.Library.controller;

import br.com.phoebustecnologia.Library.dto.CategoryDTO.CategoryDTO;
import br.com.phoebustecnologia.Library.services.CategoryServices.CategoryServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
@Api(value = "API REST Category ")
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    CategoryServicesImpl categoryServicesImpl;


    @ApiOperation("List of category")
    @GetMapping(value = "/all")
    public List<CategoryDTO> categoryList() {

        return categoryServicesImpl.findAll();
    }

    @ApiOperation("Find an category by ID")
    @GetMapping(value = "/{id}")
    public CategoryDTO findCategoryByID(@PathVariable(name =  "id") Long id){
        return categoryServicesImpl.findById(id);

    }

    @ApiOperation("Save an category")
    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO category) {
        return categoryServicesImpl.save(category);
    }

    @ApiOperation("Delete on category")
    @DeleteMapping(value = "/{id}")
    public void  deleteCategory(@PathVariable Long id) {
        categoryServicesImpl.delete(id);

    }

    @ApiOperation("Update on category")
    @PutMapping(value = "/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
         return categoryServicesImpl.update(id, categoryDTO);
    }
}
