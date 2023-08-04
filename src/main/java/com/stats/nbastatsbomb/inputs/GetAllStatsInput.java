package com.stats.nbastatsbomb.inputs;

import com.stats.nbastatsbomb.enums.StatsTableColumns;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllStatsInput {

    private StatsTableColumns fieldName;
    private PaginationInput paginationInput;
}
