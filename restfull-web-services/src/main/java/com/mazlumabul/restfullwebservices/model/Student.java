package com.mazlumabul.restfullwebservices.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 2, message = "Must be null")
    private String nameSurname;

    @Max(value = 99999)
    @Positive
    private int studentNumber;

    @NotBlank(message = "Must be not blank")
    private String schoolName;

    @Email(message = "Email should be valid")
    private String email;

    @Min(value = 18, message = "Cannot be younger than 18 years old.")
    private int age;

    @Pattern(regexp = "[0-9\\s]{12}")
    private String phone;

}
