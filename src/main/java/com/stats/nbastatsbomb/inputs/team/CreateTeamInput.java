package com.stats.nbastatsbomb.inputs.team;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTeamInput {

    @NotEmpty
    @Size(min = 2,max = 3,message = "Team name size greater than 2 and less than 4")
    @NotNull
    private String name;
}