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
@Table(name="UserDetails")
//@XmlRootElement
//@NamedQueries({
//	@NamedQuery(name = "CustomerDetailsEntity.countByCustomerId", query = "SELECT COUNT(c) FROM CustomerDetailsEntity c WHERE c.customerId=:customerId")
//})
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserDetails_generator")
	@SequenceGenerator(name="UserDetails_generator", sequenceName = "UserDetails_seq", allocationSize=50)
	@Column(name = "userId", nullable = false, updatable = false, insertable = false)
	private long clientId;
	@Column(name = "email", nullable = false, updatable = true, insertable = true)
	private String email;
	@Column(name = "password", nullable = false, updatable = true, insertable = true)
	private String password;
	@Column(name = "usertype", nullable = false, updatable = true, insertable = true)
	private String usertype;
	@Column(name = "cre_rec_ts", nullable = true, updatable = true, insertable = true)
	private Date cre_rec_ts;
	@Column(name = "upd_rec_ts", nullable = true, updatable = true, insertable = true)
	private Date upd_rec_ts;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
}
