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
@MongoEntity(collection = "Person")
public class Person extends ReactivePanacheMongoEntity {

    @BsonProperty("last_name")
    @JsonbProperty("last_name")
    private String lastName;
    @BsonProperty("first_name")
    @JsonbProperty("first_name")
    private String firstName;
    private String nickname;
    @BsonProperty("born_date")
    @JsonbProperty("born_date")
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate bornDate;
    @BsonProperty("is_player")
    @JsonbProperty("is_player")
    private Boolean player;
    @BsonProperty("is_coach")
    @JsonbProperty("is_coach")
    private Boolean coach;
}
