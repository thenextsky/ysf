package cn.ysf;

import java.awt.Color;
import java.awt.Graphics;
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
	/**
	 * 半径
	 */
	private int r = 260;
	//圆心坐标
	private int x = 300;
	private int y = 300;

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
			double af = Math.PI*2/param.getN()*(i-1);
			int x = (int) (r*Math.cos(af)+this.x);
			int y = (int) (this.y-r*Math.sin(af));
			persons.add(new Person(i, true,x,y));
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

	public void draw(Graphics g) {
		Color c = g.getColor();
		for(Person p:persons) {
			p.draw(g);
			if(p.getNumber()==currentNumber-1
					||(currentNumber-1<=0&&p.getNumber()==persons.size())
					) {
				g.setColor(Color.RED);
				g.drawLine(x, y, p.getX(), p.getY());
			}
		}
		g.setColor(Color.RED);
		g.fillOval(x-5, y-5, 10, 10);
		g.setColor(c);
	}

	
}
