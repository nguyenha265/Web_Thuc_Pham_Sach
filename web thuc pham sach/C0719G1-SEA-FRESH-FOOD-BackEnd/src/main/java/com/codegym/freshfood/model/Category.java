package com.codegym.freshfood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long categoryId;

/*  @NotBlank
  @Size(min = 1, max = 20)*/
  private String name;

  @JsonIgnore
  @OneToMany(targetEntity = Product.class,mappedBy = "category")
  private List<Product> products;
}
