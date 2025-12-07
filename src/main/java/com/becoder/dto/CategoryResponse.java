package com.becoder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor    // ← हे खूप महत्वाचे आहे (ModelMapper याचा वापर करतो)
public class CategoryResponse {

    private Integer id;
    
    private String name;
    
    private String description;
    
    private Boolean isActive; 
}

