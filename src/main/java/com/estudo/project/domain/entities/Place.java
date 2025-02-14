package com.estudo.project.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Place {

    public Long id;
    public String name;
    public String slug;
    public String state;
    @CreatedDate
    public LocalDateTime createdAt;
    @LastModifiedBy
    public LocalDateTime updatedAt;

    public Place(String name, String slug, String state, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.name = name;
        this.slug = slug;
        this.state = state;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }
}
