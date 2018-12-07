package cn.ysf;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环链表
 *
 */
public class Circle {
	private List<Person> persons = new ArrayList<>();
	/**
	 * 当前编号(不管死活)，从1开始
	 */
	private int currentNumber;

	public synchronized int getCurrentNumber() {
		return currentNumber;
	}

	public synchronized void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	/**
	 * 初始化n个人
	 * 
	 * @param n
	 *            初始化人数
	 */
	public synchronized void init(Param param) {
		persons.clear();
		for (int i = 1; i <= param.getN(); i++) {
			persons.add(new Person(i, true));
		}
		this.setCurrentNumber(param.getK());
	}

	/**
	 * 获取当前元素
	 * @return
	 */
	public synchronized Person getCurrent() {
		Person p = persons.get(currentNumber-1);
		currentNumber++;
		if (currentNumber == persons.size()+1) {
			currentNumber = 1;
		}
		return p;
	}
	
	public synchronized void die(Person person) {
		person.setAlive(false);
	}

	public synchronized int getAliveCount() {
		int count = 0;
		for(Person p:persons) {
			if(p.isAlive()) {
				count++;
			}
		}
		return count;
	}
	
	public synchronized List<Person> getPersons() {
		return persons;
	}

	public synchronized void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@Override
	public String toString() {
		return "Circle [persons=" + persons + ", currentNumber=" + currentNumber + "]";
	}

}
