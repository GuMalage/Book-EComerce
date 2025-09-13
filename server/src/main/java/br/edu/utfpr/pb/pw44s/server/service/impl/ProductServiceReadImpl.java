package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.IProductServiceRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceReadImpl extends CrudServiceReadImpl<Product, Long> implements IProductServiceRead {

    private final ProductRepository productRepository;

    public ProductServiceReadImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }


    @Override
    public List<Product> findAllByCategoryId(Long categoryId) {
        return this.productRepository.findAllByCategoryId(categoryId);
    }
}
