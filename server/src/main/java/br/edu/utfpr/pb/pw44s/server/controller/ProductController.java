package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.ProductDTO;
import br.edu.utfpr.pb.pw44s.server.dto.response.ProductResponseDTO;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceWrite;
import br.edu.utfpr.pb.pw44s.server.service.IProductServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.IProductServiceWrite;
import br.edu.utfpr.pb.pw44s.server.service.impl.ProductServiceWriteImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends CrudController<Product, ProductDTO, ProductResponseDTO, Long> {
    private final IProductServiceWrite productServiceWrite;
    private final IProductServiceRead productServiceRead;
    private final ModelMapper modelMapper;

    public ProductController(IProductServiceWrite productServiceWrite, IProductServiceRead productServiceRead, ModelMapper modelMapper, ProductServiceWriteImpl productServiceWriteImpl) {
        super(Product.class, ProductDTO.class, ProductResponseDTO.class);
        this.productServiceWrite = productServiceWrite;
        this.productServiceRead = productServiceRead;
        this.modelMapper = modelMapper;
    }

    @Override
    protected ICrudServiceWrite<Product, Long> getWriteService() {
        return productServiceWrite;
    }

    @Override
    protected ICrudServiceRead<Product, Long> getReadService() {
        return productServiceRead;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productServiceRead.findAllByCategoryId(categoryId);
    }
}