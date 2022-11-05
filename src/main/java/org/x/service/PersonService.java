package org.x.service;

import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import org.bson.types.ObjectId;
import org.x.model.Person;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PersonService {

    public Uni<String> create(Person entity) {
        return entity.<Person>persist()
                .map(p -> p.id.toString());
    }

    public Uni<Boolean> delete(String id) {
        return Person.deleteById(new ObjectId(id));
    }

    public Uni<List<Person>> findByName(String text) {
        return Person
                .find("{$or: [{'last_name': {$regex: ?1, $options: 'i'}}, {'first_name': {$regex: ?1, $options: 'i'}}]}",
                        Sort.by("last_name", "first_name"), text)
                .page(Page.ofSize(10))
                .list();
    }
}
