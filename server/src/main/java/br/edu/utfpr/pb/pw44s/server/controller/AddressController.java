package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.AddressDTO;
import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.service.IAddressServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.IAddressServiceWrite;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceRead;
import br.edu.utfpr.pb.pw44s.server.service.ICrudServiceWrite;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController extends CrudController<Address, AddressDTO, Long>{
    private final IAddressServiceWrite addressServiceWrite;
    private final IAddressServiceRead addressServiceRead;
    private final ModelMapper modelMapper;

    public AddressController(IAddressServiceWrite addressServiceWrite, IAddressServiceRead addressServiceRead, ModelMapper modelMapper) {
        super(Address.class, AddressDTO.class);
        this.addressServiceWrite = addressServiceWrite;
        this.addressServiceRead = addressServiceRead;
        this.modelMapper = modelMapper;
    }


    @Override
    protected ICrudServiceWrite<Address, Long> getWriteService() {
        return this.addressServiceWrite;
    }

    @Override
    protected ICrudServiceRead<Address, Long> getReadService() {
        return this.addressServiceRead;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @GetMapping("address")
    public ResponseEntity<List<Address>> findByAuthenticatedUser() {
        List<Address> addresses = addressServiceRead.findByAuthenticatedUser();
        if (addresses == null || addresses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(addresses);
    }
}


