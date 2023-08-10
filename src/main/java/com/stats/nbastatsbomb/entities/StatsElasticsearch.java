package com.stats.nbastatsbomb.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "stats")
public class StatsElasticsearch {

    @Id
    private int id;
    @Field(type = FieldType.Text, name = "player_name")
    private String player_name;

}
