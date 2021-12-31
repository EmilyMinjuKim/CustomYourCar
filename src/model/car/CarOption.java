package model.car;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.car.CarOption.SORT;

public class CarOption implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum SORT {// 자동차 종류 기본 선택
		SMART("스마트", 1385), // 0000원 빼고 만원 단위부터 시작.
		MODERN("모던", 1590), INSPIRATION("인스퍼레이션", 1870);

		private String carSort;
		private int sortPrice;

		SORT(String carSort, int sortPrice) {
			this.carSort = carSort;
			this.sortPrice = sortPrice;
		}

		public String getSort() {
			return carSort;
		}

		public int getSortPrice() {
			return sortPrice;
		}

		private static final List<Map<String, Integer>> sortPrices = Arrays.stream(values()).map(SORT -> {
			Map<String, Integer> m = new HashMap();
			m.put(SORT.carSort, SORT.sortPrice);
			return m;
		}).collect(Collectors.toList());

		public static List<Map<String, Integer>> getSortPrices() {
			return sortPrices;
		}

	}

	public enum OUTCOLOR {// 외부색상
		IVORY("ivory"), ORANGE("orange"), KHAKII("khakii");

		private String color;

		OUTCOLOR(String color) {
			this.color = color;
		}

		public String getColor() {
			return color;
		}
	}

	public enum OPTION {// 추가 옵션
		TURBO("turbo", 95), SUNROOF("sunroof", 40), NAVI("navi", 152), // 기본 선택 옵션
		WHEELPK("wheel", 55), SMARTSENSOR("sensor", 70), STORAGE("storage", 40);

		private String carOpt;
		private int opPrice;

		OPTION(String carOpt, int opPrice) {
			this.carOpt = carOpt;
			this.opPrice = opPrice;
		}

		public String getOption() {
			return carOpt;
		}

		public int getOptPrice() {
			return opPrice;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		private static final List<Map<String, Integer>> optionPrices = Arrays.stream(values()).map(OPTION -> {
			Map<String, Integer> m = new HashMap();
			m.put(OPTION.carOpt, OPTION.opPrice);
			return m;
		}).collect(Collectors.toList());

		public static List<Map<String, Integer>> getOptionPrices() {
			return optionPrices;
		}
	}

}
