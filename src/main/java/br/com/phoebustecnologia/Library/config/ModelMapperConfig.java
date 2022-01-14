package br.com.phoebustecnologia.Library.config;

import br.com.phoebustecnologia.Library.dto.CategoryDTO;
import br.com.phoebustecnologia.Library.model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){

        var modelMapper = new ModelMapper();
        return  modelMapper;
    }

}
