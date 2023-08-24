package com.stats.nbastatsbomb.entities.mongoentities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "PlayerMongo")
public class PlayerMongo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String playerName;
}
