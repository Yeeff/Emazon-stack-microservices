package com.demo.emazon_stack_microservices.adapters.driving.http.dto.request;


import com.demo.emazon_stack_microservices.domain.util.DomainConstants;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.NotBlank;


@AllArgsConstructor
@Getter
public class AddCategoryRequest {

    @NotBlank(message = "Name cannot be blank")
    @Size(max = DomainConstants.MAX_NAME_LENGTH,
            message = "Name must be less than or equal to "+ DomainConstants.MAX_NAME_LENGTH +" characters")
    private final String  name;

    @NotBlank(message = "Description cannot be blank")
    @Size(max = DomainConstants.MAX_DESCRIPTION_LENGTH,
            message = "Description must be less than or equal to " + DomainConstants.MAX_DESCRIPTION_LENGTH + " characters")
    private final String description;
}
