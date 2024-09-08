package com.syscosummit.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRespond {
    // Fields representing product
    private String product_id;
    private String product_name;
    private String product_description;
    private int product_price;
}
