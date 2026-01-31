package com.shi.studentmanagement.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDTO {

    private Long id;

    @NotBlank(message = "Course name is required")
    @Size(max=150, message="Max of 150 characters allowed")
    private String courseName;

    @NotBlank(message = "Course code is required")
    private String courseCode;

    @NotBlank(message = "Duration is required")
    private String duration;

    private boolean active;

    @NotNull(message = "Fee is required")
    private BigDecimal fee;

    @NotBlank(message = "Description is required")
    private String description;

    private LocalDateTime createdAt;
}
