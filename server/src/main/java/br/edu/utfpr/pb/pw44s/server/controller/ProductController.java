package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.ProductDTO;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceWrite;
import br.edu.utfpr.pb.pw44s.server.service.IProductServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.IProductServiceWrite;
import br.edu.utfpr.pb.pw44s.server.service.impl.ProductServiceWriteImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController extends CrudController<Product, ProductDTO, Long> {
    private final IProductServiceWrite productServiceWrite;
    private final IProductServiceRead productServiceRead;
    private final ModelMapper modelMapper;
    private final ProductServiceWriteImpl productServiceWriteImpl;

    public ProductController(IProductServiceWrite productServiceWrite, IProductServiceRead productServiceRead, ModelMapper modelMapper, ProductServiceWriteImpl productServiceWriteImpl) {
        super(Product.class, ProductDTO.class);
        this.productServiceWrite = productServiceWrite;
        this.productServiceRead = productServiceRead;
        this.modelMapper = modelMapper;
        this.productServiceWriteImpl = productServiceWriteImpl;
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
}