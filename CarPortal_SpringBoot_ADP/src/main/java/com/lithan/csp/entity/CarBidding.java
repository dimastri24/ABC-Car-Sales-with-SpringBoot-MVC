package com.lithan.csp.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CarBidding {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
//    @Column(name = "bidder_name")
//    private String bidderName;
    
    @Column(name = "bidder_price")
    private BigDecimal bidderPrice;
    
    @Column(name = "bid_date")
    private Date bidDate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Cars car;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private Users user;
    
    public CarBidding() {}

	public CarBidding(/* String bidderName, */ BigDecimal bidderPrice, Date bidDate, Cars car, Users user) {
		/* this.bidderName = bidderName; */
		this.bidderPrice = bidderPrice;
		this.bidDate = bidDate;
		this.car = car;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public String getBidderName() {
//		return bidderName;
//	}
//
//	public void setBidderName(String bidderName) {
//		this.bidderName = bidderName;
//	}

	public BigDecimal getBidderPrice() {
		return bidderPrice;
	}

	public void setBidderPrice(BigDecimal bidderPrice) {
		this.bidderPrice = bidderPrice;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date savedate) {
		this.bidDate = savedate;
	}

	public Cars getCar() {
		return car;
	}

	public void setCar(Cars car) {
		this.car = car;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
    

}
