package com.fictiveprojectmanagement.repository;

import com.fictiveprojectmanagement.entity.Product;
import com.fictiveprojectmanagement.model.FirstTask;
import com.fictiveprojectmanagement.model.SecondTask;
import com.fictiveprojectmanagement.model.ThirdTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT NEW com.fictiveprojectmanagement.model.FirstTask(p.brandName as brandName, p.categoryName as categoryName, SUM(p.salesIncVatActual) as sumOfIncVatActual) FROM Product p GROUP BY p.brandName, p.categoryName ORDER BY p.categoryName ASC")
    List<FirstTask> getFirstTask();

    @Query("SELECT new com.fictiveprojectmanagement.model.SecondTask(p.categoryName as categoryName, sum(p.volume) as volume, SUM(p.salesIncVatActual) as sumOfIncVatActual) from Product p group by p.categoryName, p.volume order by SUM(p.salesIncVatActual) desc limit 4")
    List<SecondTask> getSecondTask();

    @Query("""
                  SELECT new com.fictiveprojectmanagement.model.ThirdTask(p.brandName as brandName,
                  CASE
                     WHEN p.salesIncVatActual >= 0 AND p.salesIncVatActual <= 10 THEN '0-10'
                     WHEN p.salesIncVatActual > 10 AND p.salesIncVatActual <= 100 THEN '10-100'
                     ELSE '100'
                   END as salesRange,
                   p.salesIncVatActual as salesIncVatActual)
            FROM Product p
            GROUP BY p.brandName, p.salesIncVatActual""")
    List<ThirdTask> getThirdTask();
}
