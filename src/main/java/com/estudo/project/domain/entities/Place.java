package com.estudo.project.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@Table("place")
public class Place {
    @Id
    public Long id;
    public String name;
    public String slug;
    public String state;
    public int grade;
    @CreatedDate
    public LocalDateTime createdAt;
    @LastModifiedDate
    public LocalDateTime updatedAt;

    public Place(String name, String slug, String state, int grade) {
        this.name = name;
        this.slug = slug;
        this.state = state;
        this.grade = grade;
    }
}
