package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.CategoryDTO;
import br.edu.utfpr.pb.pw44s.server.model.Category;
import br.edu.utfpr.pb.pw44s.server.service.ICategoryServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.ICategoryServiceWrite;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceWrite;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
public class CategoryController extends CrudController<Category, CategoryDTO, Long> {
    private final ICategoryServiceWrite categoryServiceWrite;
    private final ICategoryServiceRead categoryServiceRead;
    private final ModelMapper modelMapper;

    public CategoryController(ICategoryServiceWrite categoryServiceWrite, ICategoryServiceRead categoryServiceRead, ModelMapper modelMapper) {
        super(Category.class, CategoryDTO.class);
        this.categoryServiceWrite = categoryServiceWrite;
        this.categoryServiceRead = categoryServiceRead;
        this.modelMapper = modelMapper;
    }


    @Override
    protected ICrudServiceWrite<Category, Long> getWriteService() {
        return this.categoryServiceWrite;
    }

    @Override
    protected ICrudServiceRead<Category, Long> getReadService() {
        return this.categoryServiceRead;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }


}
