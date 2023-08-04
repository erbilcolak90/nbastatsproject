package com.stats.nbastatsbomb.inputs;

import com.stats.nbastatsbomb.enums.SortBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInput {

    private int page;
    private int size;
    private SortBy sort;
}
