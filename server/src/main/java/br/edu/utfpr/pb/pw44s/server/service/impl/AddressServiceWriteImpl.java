package br.edu.utfpr.pb.pw44s.server.service.impl;

import br.edu.utfpr.pb.pw44s.server.model.Address;
import br.edu.utfpr.pb.pw44s.server.repository.AddressRepository;
import br.edu.utfpr.pb.pw44s.server.service.IAddressServiceWrite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceWriteImpl extends CrudServiceWriteImpl<Address, Long> implements IAddressServiceWrite {
    private final AddressRepository addressRepository;

    public AddressServiceWriteImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return addressRepository;
    }

}
