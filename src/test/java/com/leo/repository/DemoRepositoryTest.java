package com.leo.repository;

import com.leo.model.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 描述: jpa api测试
 *
 * @author LIULE9
 * @create 2018-10-25 1:21 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoRepositoryTest {

  @Autowired
  private DemoRepository repository;

  @Test
  @Transactional
  @Rollback(false)
  public void should_1() throws Throwable {
//    List<Demo> all = repository.findAll();
//
//    System.out.println(all);

//    Sort orders = new Sort(Sort.Direction.DESC, "id");
//    all = repository.findAll(orders);
//    System.out.println(all);

//    Sort orders = Sort.by(Sort.Direction.DESC, "id");
//    all = repository.findAll(orders);
//    System.out.println(all);

//    PageRequest pageable = PageRequest.of(0, 2);
//    Page<Demo> page = repository.findAll(pageable);
//    System.out.println(page.getContent());
//    System.out.println(page.getTotalPages());
//    System.out.println(page.getTotalElements());


//      Demo one = repository.getOne(1);
//      System.out.println(one);

//    Optional<Demo> optional = repository.findById(5);
//    Demo demo = optional.orElseThrow(() -> new RuntimeException("can not find anything"));
//    System.out.println(demo);

//    Optional<Demo> optional = repository.findById(5);
////    Demo demo = optional.orElseGet(() -> new Demo(5, "leo"));
//    Demo demo = optional.orElse(new Demo(5, "leo"));
//    System.out.println(demo);

//    Optional<Demo> optional = repository.findById(1);
//    boolean present = optional.isPresent();
//    System.out.println(present);

//    try(Stream<Demo> stream = repository.findByNameIsLike("%明%")) {
//        stream.forEach((demo)-> System.out.println(demo.getName()));
//    } catch (Exception e) {
//      e.printStackTrace();
//    }
//
//
//    try (Stream<Demo> stream = repository.findByAge(23, PageRequest.of(0,2))) {
//      stream.forEach((demo)-> System.out.println(demo.getName()));
//    }catch (Exception e){
//      e.printStackTrace();
//    }

//    Demo demo = repository.findById(5).get();
//    System.out.println(demo);
//    demo.setName("gg");
//    Demo demo1 = repository.findById(5).get();
//    System.out.println(demo1);

//    Demo one = repository.getOne(5);
//    System.out.println(one);
//    one.setName("gg");
//    Demo one1 = repository.getOne(5);
//    System.out.println(one1);

//    Demo demo = new Demo();
//    demo.setName("ss");
//    demo.setAge(22);
//    Demo save = repository.save(demo);
//    System.out.println(save);


//    boolean exists = repository.existsById(1);
//    System.out.println(exists);

//    Demo de = repository.findByName("x");
//    System.out.println(de);

    Demo demo = new Demo();
    demo.setName("小");
    ExampleMatcher matcher = ExampleMatcher.matching();
    matcher.withMatcher("name", match->match.contains())
    .withIgnorePaths("id")
    .withIgnorePaths("age");
    Example<Demo> example = Example.of(demo, matcher);
    List<Demo> list = repository.findAll(example);
    System.out.println(list);

  }


  @Test
  public void should_2() {
    Demo demo = new Demo();
    demo.setName("明");
    demo.setAge(11);

    //CriteriaQuery<?>: 写查询关键字 order by 、 group by 、 having 、 where 、distinct

    //CriteriaBuilder: 写查询的条件 le 、lt 、ge 、and 、or 、like 、lessThan

    //root: 用来指定对象的属性的表达式

    //Predicate 数组 默认是使用and连接，如果需要使用or，需要特别指定

    List<Demo> demos = repository.findAll((Specification<Demo>) (root, criteriaQuery, criteriaBuilder) -> {
      List<Predicate> predicates = new ArrayList<>();

      if (!StringUtils.isEmpty(demo.getName())) {
        criteriaQuery.distinct(true);
        predicates.add(criteriaBuilder.like(root.get("name"), "%" + demo.getName() + "%"));
      }

      if (demo.getAge() != null) {
        predicates.add(criteriaBuilder.le(root.get("age"), demo.getAge()));
      }

      Predicate[] predicatesArray = predicates.toArray(new Predicate[0]);
      //设置排序，false代表倒序
//        criteriaQuery.orderBy(new ArrayList<Order>() {{
//          add(new OrderImpl(root.get("id"), false));
//        }});

      //排序接口的第二种生成方式
      Order order = criteriaBuilder.asc(root.get("age"));
      criteriaQuery.orderBy(order);

      return criteriaQuery.where(criteriaBuilder.or(predicatesArray)).getRestriction();
    });

    System.out.println(demos);
  }


  @Test
  @Transactional
  public void should_3(){
//    List<Demo> demo = repository.selectDemoByNameAndAgeLessThan("明", 22);
//    System.out.println(demo);

    Integer count = repository.updateDemoAgeByName("小明", 20);
    System.out.println(count);

    Demo demo = repository.getOne(1);
    System.out.println(demo);


  }

}