package org.x.service.impl;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.x.model.CustomerEntity;
import org.x.repository.CustomerRepository;
import org.x.service.ICustomerService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository repository;

    @Override
    public Multi<CustomerEntity> findAll() {
        return repository.listAll()
                .onItem()
                .transformToMulti(Multi.createFrom()::iterable);
    }

    @Override
    public Uni<CustomerEntity> findById(String id) {
        return repository.findById(new ObjectId(id));
    }

    @Override
    public Uni<CustomerEntity> create(CustomerEntity entity) {
        return repository.persist(entity);
    }
}
