package com.leo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 描述: jpa测试对象
 *
 * @author LIULE9
 * @create 2018-10-25 8:46 AM
 */
@Data
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Demo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private Integer age;
}