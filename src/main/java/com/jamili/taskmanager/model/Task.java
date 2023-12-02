package com.jamili.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Title may not be blank")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "Description may not be blank")
    private String description;

    @Column(nullable = false)
    private Date creationDate;

    @Column(nullable = false)
    @NotBlank(message = "Status may not be blank")
    private String status;

    @PrePersist
    protected void onCreate() {
        this.creationDate = new Date();
    }
}
