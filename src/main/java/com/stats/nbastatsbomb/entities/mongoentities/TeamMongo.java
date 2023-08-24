package com.stats.nbastatsbomb.entities.mongoentities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "TeamMongo")
public class TeamMongo {

    @Id
    private String id;
    private int apiId;
    private String name;
    private String nickName;
    private String code;
    private String city;
    private String logo;

}