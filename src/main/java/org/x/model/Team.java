package org.x.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = false)
@MongoEntity(collection = "Team")
public class Team extends ReactivePanacheMongoEntity {

    private String name;
    private String abbreviation;
    @BsonProperty("foundation_date")
    @JsonbProperty("foundation_date")
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate foundationDate;
}
