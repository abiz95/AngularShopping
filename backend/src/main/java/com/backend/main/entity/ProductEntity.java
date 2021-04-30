package com.backend.main.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
//import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="ProductDetail")
//@XmlRootElement
//@NamedQueries({
//	@NamedQuery(name = "ProductEntity.deleteByProductId", query = "delete from ProductEntity p where p.productId=:productId")
//})
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductDetail_generator")
	@SequenceGenerator(name="ProductDetail_generator", sequenceName = "ProductDetail_seq", allocationSize=50)
	@Column(name = "productId", nullable = false, updatable = false, insertable = false)
	private long productId;
	@Column(name = "productName", nullable = false, updatable = true, insertable = true)
	private String productName;
	@Column(name = "productDescription", nullable = false, updatable = true, insertable = true)
	private String productDescription;
	@Column(name = "productPrice", nullable = false, updatable = true, insertable = true)
	private double productPrice;
	@Column(name = "productDate", nullable = false, updatable = true, insertable = true)
	private Date productDate;
	@Column(name = "cre_rec_ts", nullable = true, updatable = true, insertable = true)
	private Date cre_rec_ts;
	@Column(name = "upd_rec_ts", nullable = true, updatable = true, insertable = true)
	private Date upd_rec_ts;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
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
	public long getProductId() {
		return productId;
	}
	
}
