package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.repository.ProductRepository;
import br.edu.utfpr.pb.pw44s.server.service.IProductServiceWrite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceWriteImpl extends CrudServiceWriteImpl<Product, Long> implements IProductServiceWrite {

    private final ProductRepository productRepository;

    public ProductServiceWriteImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    protected JpaRepository<Product, Long> getRepository() {
        return productRepository;
    }

}