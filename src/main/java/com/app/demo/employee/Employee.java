package com.app.demo.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "performance_rating")
    private String performanceRating;
    @Column(name = "team_name")
    private String teamName;
    @Column(name = "date_of_joining")
    private LocalDate dateOfJoining;
    @Column(name = "created_date_time")
    @JsonIgnore
    private final LocalDateTime createdDateTime = LocalDateTime.now(ZoneId.systemDefault());

}

