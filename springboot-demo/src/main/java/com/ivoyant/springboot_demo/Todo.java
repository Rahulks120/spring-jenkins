package com.ivoyant.springboot_demo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int id;
    private String username;
    @NotBlank(message = "Task cannot be blank")
    @Size(max = 100, message = "Task cannot exceed 100 characters")
    private String description;
    private LocalDate targetDate;


}
