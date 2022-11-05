package org.x.repository;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import org.x.model.CustomerEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepository implements ReactivePanacheMongoRepository<CustomerEntity> {
}
