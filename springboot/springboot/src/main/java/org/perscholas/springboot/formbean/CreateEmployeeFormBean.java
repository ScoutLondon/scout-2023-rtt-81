package org.perscholas.springboot.formbean;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class CreateEmployeeFormBean {
    private Integer id;

    @NotEmpty(message = "First name is required.")
    @Length(max = 45, message = "First name must be less than 45 characters.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    @Length(max = 45, message = "Last name must be less than 45 characters.")
    private String lastName;

    @NotEmpty(message = "Department name is required.")
    @Length(max = 45, message = "Department name must be less than 45 characters.")
    private String department;
}
