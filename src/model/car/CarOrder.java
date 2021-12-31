package model.car;

import java.io.Serializable;
import java.time.LocalDate;

public class CarOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	private String payMonth, address, deliveryDate, id;// 할부 개월, 탁송지, 탁송날짜, 주문자 id
	private LocalDate payDate;

	public LocalDate getPayDate() {
		return payDate;
	}

	public void setPayDate(LocalDate payDate) {
		this.payDate = payDate;
	}

	private Car car; // 주문차

	public String getPayMonth() {
		return payMonth;
	}

	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CarOrder [payMonth=" + payMonth + ", address=" + address + ", deliveryDate=" + deliveryDate + ", id="
				+ id + ", payDate=" + payDate + ", car=" + car + "]";
	}

}
