package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Category;
import br.edu.utfpr.pb.pw44s.server.repository.CategoryRepository;
import br.edu.utfpr.pb.pw44s.server.service.ICategoryServiceRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceReadImpl extends CrudServiceReadImpl<Category, Long>
        implements ICategoryServiceRead {
    private final CategoryRepository categoryRepository;

    public CategoryServiceReadImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return categoryRepository;
    }
}
