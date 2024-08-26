package com.demo.emazon_stack_microservices.adapters.driving.http.dto.request;


import com.demo.emazon_stack_microservices.domain.util.DomainConstants;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class AddBrandRequest {

    @Size(max = DomainConstants.MAX_BRAND_NAME_LENGTH,
            message = "Name must be less than or equal to "+ DomainConstants.MAX_BRAND_NAME_LENGTH +" characters")
    private final String  name;

    @Size(max = DomainConstants.MAX_BRAND_DESCRIPTION_LENGTH,
            message = "Description must be less than or equal to " + DomainConstants.MAX_BRAND_DESCRIPTION_LENGTH + " characters")
    private final String description;
}
