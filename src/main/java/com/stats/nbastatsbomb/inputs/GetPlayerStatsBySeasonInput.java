package com.stats.nbastatsbomb.inputs;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetPlayerStatsBySeasonInput {

    @NotNull
    @NotEmpty
    private String full_name;
    @NotNull
    @NotEmpty
    private String season;
}
