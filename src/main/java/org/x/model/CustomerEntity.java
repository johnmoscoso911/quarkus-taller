package org.x.model;

import javax.json.bind.annotation.JsonbProperty;

import org.bson.codecs.pojo.annotations.BsonProperty;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@MongoEntity(collection = "Customer")
public class CustomerEntity extends ReactivePanacheMongoEntity {

    @BsonProperty("last_name")
    @JsonbProperty("last_name")
    private String lastName;
    @BsonProperty("first_name")
    @JsonbProperty("first_name")
    private String firstName;
}
