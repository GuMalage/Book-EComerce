package br.edu.utfpr.pb.pw44s.server.service;

import br.edu.utfpr.pb.pw44s.server.model.Address;

import java.util.List;

public interface IAddressServiceRead extends ICrudServiceRead<Address, Long>{
    List<Address> findByAuthenticatedUser();
}
