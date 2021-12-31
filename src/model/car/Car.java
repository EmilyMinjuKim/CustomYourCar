package model.car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import model.car.CarOption.OPTION;
import model.car.CarOption.SORT;

public class Car implements Serializable {

	private String sort, color, id;// 종류, 색, 고객아이디
	private int price;// 가격
	private ArrayList<String> options;// 옵션

	private static final long serialVersionUID = 1L;

	public Car() {
		this.sort = "modern";
		this.color = "ivory";

	}

	public Car(String sort, String color) {
		this.sort = sort;
		this.color = color;
	}

	public Car(String sort, String color, ArrayList<String> option) {
		this.sort = sort;
		this.color = color;
		this.options = option;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Car [sort=" + sort + ", color=" + color + ", price=" + price + ", options=" + options + ", id=" + id
				+ "]";
	}

}
