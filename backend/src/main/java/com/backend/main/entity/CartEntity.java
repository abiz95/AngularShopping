package com.backend.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CartDetail")
//@XmlRootElement
//@NamedQueries({
//	@NamedQuery(name = "CustomerDetailsEntity.countByCustomerId", query = "SELECT COUNT(c) FROM CustomerDetailsEntity c WHERE c.customerId=:customerId")
//})
public class CartEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CartDetail_generator")
	@SequenceGenerator(name="CartDetail_generator", sequenceName = "CartDetail_seq", allocationSize=50)
	@Column(name = "cartId", nullable = false, updatable = false, insertable = false)
	private long cartId;
	@Column(name = "email", nullable = false, updatable = true, insertable = true)
	private String email;
	@Column(name = "productId", nullable = false, updatable = true, insertable = true)
	private long productId;
	@Column(name = "qty", nullable = false, updatable = true, insertable = true)
	private int qty;
	@Column(name = "status", nullable = false, updatable = true, insertable = true)
	private int status;
	@Column(name = "totalPrice", nullable = false, updatable = true, insertable = true)
	private double totalPrice;
	@Column(name = "cre_rec_ts", nullable = true, updatable = true, insertable = true)
	private Date cre_rec_ts;
	@Column(name = "upd_rec_ts", nullable = true, updatable = true, insertable = true)
	private Date upd_rec_ts;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getCre_rec_ts() {
		return cre_rec_ts;
	}
	public void setCre_rec_ts(Date cre_rec_ts) {
		this.cre_rec_ts = cre_rec_ts;
	}
	public Date getUpd_rec_ts() {
		return upd_rec_ts;
	}
	public void setUpd_rec_ts(Date upd_rec_ts) {
		this.upd_rec_ts = upd_rec_ts;
	}
	public long getCartId() {
		return cartId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
