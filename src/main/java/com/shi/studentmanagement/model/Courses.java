package com.shi.studentmanagement.model;
import java.math.BigDecimal;
import java.time.LocalDate; 
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="courses")
public class Courses {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String courseName;

    @Column(nullable=false, unique=true)
    private String courseCode;

    private String duration;

    @Column(name="active", nullable=false)
    private boolean active = true;

    @Column(precision=12, scale=2, nullable=false)
    private BigDecimal fee;

    @Column(length=1000)
    private String description;

    @Column(nullable=false, updatable=false)
    private LocalDateTime createdAt;
}
