package com.leo.repository;

import com.leo.model.Demo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.stream.Stream;

/**
 * 描述: jpa测试的jpa
 *
 * @author LIULE9
 * @create 2018-10-25 1:16 PM
 */
public interface DemoRepository extends JpaRepository<Demo, Integer>, JpaSpecificationExecutor<Demo> {

  Stream<Demo> findByNameIsLike(String name);

  Stream<Demo> findByAge(Integer age, Pageable pageable);

  @Nullable
  Demo findByName(String name);

  //  @Query("select d from Demo d where d.name like %:name% and d.age <:age")
//  List<Demo> selectDemoByNameAndAgeLessThan(@Param("name") String name, @Param("age") Integer age);

//  @Query("select d from Demo d where d.name like %?1% and d.age <?2")
//  List<Demo> selectDemoByNameAndAgeLessThan(String name, Integer age);

//    @Query(value = "select * from demo where name like %?1% and age < ?2",nativeQuery = true)
//    List<Demo> selectDemoByNameAndAgeLessThan(String name, Integer age);


//  @Query(value = "update demo set age = ?2 where name = ?1",nativeQuery = true)
//  @Modifying
  Integer updateDemoAgeByName(String name, Integer age);

//  List<Demo> findByNameIsLike(String name);
}