package com.backend.main.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.main.entity.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, String> {

	@Transactional
	@Modifying
	@Query("delete from CartEntity c where c.cartId=:cartId") 
	void deleteByCartId(@Param("cartId") long productId) throws Exception;
	
	@Transactional
	@Modifying
	@Query("select c from CartEntity c where c.email=:email and c.status=0") 
	List<CartEntity> findByEmailAndStatusInd(@Param("email") String email) throws Exception;
	
	CartEntity findByCartId(long cartId) throws Exception;
	List<CartEntity> findByEmail(String email) throws Exception;
	List<CartEntity> findByCartIdAndStatus(long cartId, int status) throws Exception;
}
