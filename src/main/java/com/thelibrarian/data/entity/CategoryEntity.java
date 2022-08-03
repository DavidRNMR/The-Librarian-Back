package com.thelibrarian.data.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name="CATEGORY")
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;



    /*@OneToMany(targetEntity = CategoryEntity.class,mappedBy="id_book", orphanRemoval = false, fetch = FetchType.LAZY)
    private List<CategoryEntity> categories;*/
}
