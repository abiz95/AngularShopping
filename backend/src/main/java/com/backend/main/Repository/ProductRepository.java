package com.backend.main.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.main.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

	List<ProductEntity> findAllByOrderByProductIdDesc() throws Exception;
	ProductEntity findByProductId(long productId) throws Exception;
	  @Transactional
	  @Modifying
	  @Query("delete from ProductEntity p where p.productId=:productId") 
	  void deleteByProductId(@Param("productId") long productId) throws Exception;
}
