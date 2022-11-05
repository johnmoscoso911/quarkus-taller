package org.x.service;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import org.x.model.CustomerEntity;

public interface ICustomerService {

    Multi<CustomerEntity> findAll();

    Uni<CustomerEntity> findById(String id);

    Uni<CustomerEntity> create(CustomerEntity entity);
}
