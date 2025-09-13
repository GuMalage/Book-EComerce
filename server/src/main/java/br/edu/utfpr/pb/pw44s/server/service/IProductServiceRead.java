package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Product;

import java.util.List;

public interface IProductServiceRead extends ICrudServiceRead<Product, Long> {
    List<Product> findAllByCategoryId(Long categoryId);
}
