package com.example.fictiveprojectmanagement.repository;

import com.example.fictiveprojectmanagement.entity.Product;
import com.example.fictiveprojectmanagement.entity.task1.Task1Dto;
import com.example.fictiveprojectmanagement.entity.task1.Task2;
import com.example.fictiveprojectmanagement.entity.task1.Task3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT NEW com.example.fictiveprojectmanagement.entity.task1.Task1Dto(p.brandName as brandName, p.categoryName as categoryName, SUM(p.salesIncVatActual) as sumOfIncVatActual) FROM Product p GROUP BY p.brandName, p.categoryName ORDER BY p.categoryName ASC")
    List<Task1Dto> getTask1();

    @Query("SELECT new com.example.fictiveprojectmanagement.entity.task1.Task2(p.categoryName as categoryName, sum(p.volume) as volume, SUM(p.salesIncVatActual) as sumOfIncVatActual) from Product p group by p.categoryName, p.volume order by SUM(p.salesIncVatActual) desc limit 4")
    List<Task2> getTask2();

    @Query("""
                  SELECT new com.example.fictiveprojectmanagement.entity.task1.Task3(p.brandName as brandName,
                  CASE
                     WHEN p.salesIncVatActual >= 0 AND p.salesIncVatActual <= 10 THEN '0-10'
                     WHEN p.salesIncVatActual > 10 AND p.salesIncVatActual <= 100 THEN '10-100'
                     ELSE '100'
                   END as salesRange,
                   p.salesIncVatActual as sumOfIncVatActual)
            FROM Product p
            GROUP BY p.brandName, p.salesIncVatActual""")
    List<Task3> getTask3();
}
