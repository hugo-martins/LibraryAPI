package br.com.phoebustecnologia.Library.Repositories;

import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    CategoryDTO save(CategoryDTO categoryDTO);

    Optional findById(Long id);


}
