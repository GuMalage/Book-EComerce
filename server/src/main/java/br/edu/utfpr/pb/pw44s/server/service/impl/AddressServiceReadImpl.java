package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.service.IAddressServiceRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceReadImpl extends CrudServiceReadImpl<Address, Long> implements IAddressServiceRead {
    private final AddressRepository addressRepository;

    public AddressServiceReadImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }
}
