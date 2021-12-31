package controller.car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.car.Car;
import model.car.CarOption.OPTION;
import model.car.CarOption.SORT;
import model.car.CarOrder;

public class CustomController {
	static String filename = "carList.txt";
	static String orderFile = "orderList.txt";

	// 자동차 견적 저장을 가져와서 ArrayList에 저장 후 반환하는 메소드.
	public ArrayList<Car> getList() {// static으로 하면 안 됨. 수정해야함.
		ArrayList<Car> orderList = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
			orderList = (ArrayList) ois.readObject();
		} catch (IOException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	// 견적 저장 메소드
	public void saveList(ArrayList<Car> carOrder) {
		File orderList = new File(filename);

		// 파일 없을 경우 만들기
		if (!orderList.exists()) {
			try {
				orderList.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
			oos.writeObject(carOrder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 계약된 내용을 가져와서 ArrayList에 저장 후 반환하는 메소드.
	public ArrayList<CarOrder> getOrderList() {// static으로 하면 안 됨. 수정해야함.
		ArrayList<CarOrder> orderList = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(orderFile))) {
			orderList = (ArrayList) ois.readObject();
		} catch (IOException e) {
			e.getStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	// 계약 내역 저장 메소드
	public void saveOrderList(ArrayList<CarOrder> carOrder) {
		File orderList = new File(orderFile);

		// 파일 없을 경우 만들기
		if (!orderList.exists()) {
			try {
				orderList.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(orderFile))) {
			oos.writeObject(carOrder);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 자동차 견적 인풋 메소드
	public void inputCar(ArrayList orderList, String id) {
		ArrayList<Car> saveList = new ArrayList<>();
		Car car = new Car();
		car.setSort((String) orderList.get(0));
		car.setColor((String) orderList.get(1));
		car.setOptions((ArrayList<String>) orderList.get(2));
		car.setPrice((int) orderList.get(3));
		car.setId(id);

		saveList.add(car);
		saveList(saveList);
	}

	// 견적 정보 가져오기.
	public Car getCar(String id) {
		ArrayList<Car> carList = getList();
		Car car = new Car();
		int size = carList.size();
		for (int i = 0; i < size; i++) {
			if (carList.get(i).getId().equals(id)) {
				car = carList.get(i);
			}
		}
		return car;
	}

	// 결제 정보 가져오기
	public CarOrder getOrderCar(String id) {
		ArrayList<CarOrder> orderList = getOrderList();
		CarOrder orderInfo = new CarOrder();

		int size = orderList.size();
		for (int i = 0; i < size; i++) {
			if (orderList.get(i).getId().equals(id)) {
				orderInfo = orderList.get(i);
			}
		}
		return orderInfo;
	}

	// 자동차 결제 내역 삭제 메소드
	public String deleteList(String id) {
		ArrayList<CarOrder> list = getOrderList();
		int size = list.size();
		for (int i = 0; i < size; i++) {
			if (list.get(i).getCar().getId().equals(id)) {
				list.remove(i);
				saveOrderList(list);
				return "계약이 취소 되었습니다.";
			}
		}
		return "삭제 실패";
	}


	// 자동차 결제 메소드
	public String buyCar(ArrayList buyInfo, ArrayList orderList, String id) {
		Car car = new Car();
		car.setSort((String) orderList.get(0));
		car.setColor((String) orderList.get(1));
		car.setOptions((ArrayList<String>) orderList.get(2));
		car.setPrice((int) orderList.get(3));
		car.setId(id);

		ArrayList<CarOrder> orderedList = new ArrayList<>();
		CarOrder order = new CarOrder();
		order.setAddress((String) buyInfo.get(0));
		order.setPayMonth((String) buyInfo.get(1));
		order.setDeliveryDate((String) buyInfo.get(2));
		order.setPayDate((LocalDate) buyInfo.get(3));
		order.setId(id);
		order.setCar(car);
		orderedList.add(order);

		saveOrderList(orderedList);

		return "계약이 완료 되었습니다. 감사합니다.";
	}

	// 기본 자동차 가격 가져오는 메소드
	public String getSortPrice(String sort) {
		int size = SORT.getSortPrices().size();// 자동차 종류 사이즈
		Collection<Integer> price = null;// 자동차 가격 변수

		for (int i = 0; i < size; i++) {
			if (SORT.getSortPrices().get(i).containsKey(sort)) {
				price = SORT.getSortPrices().get(i).values();
			}
		}
		return price + " 만원";
	}

	// 사용자 옵션 가격
	public ArrayList<Map<String, Integer>> getOptionPrice(ArrayList list) {
		int size = OPTION.getOptionPrices().size();// 옵션 가격의 사이즈.
		int length = list.size();// 사용자가 선택한 옵션 길이.
		ArrayList priceList = new ArrayList();
		Iterator it = OPTION.getOptionPrices().iterator();

		ArrayList<Map<String, Integer>> p = new ArrayList<Map<String, Integer>>();

		while (it.hasNext()) {
			HashMap m = (HashMap) it.next();
			for (int i = 0; i < length; i++) {
				if (m.containsKey(list.get(i))) {
					priceList.add(m.get(list.get(i)));
					p.add(OPTION.getOptionPrices().get(i));
				}
			}
		}
		return p;
	}

}
