package com.example.inventory_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class VideoRequest {

    private String name;
    private String url;
    private String description;
    private Date date_prod;
    private CreatorRequest creator;
}
