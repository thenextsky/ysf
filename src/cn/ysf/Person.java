package cn.ysf;

import java.awt.Color;
import java.awt.Graphics;

public class Person {
	private int x, y;// 圆心坐标
	final int d = 36, r = d / 2;
	/**
	 * 编号，从1开始
	 */
	private int number;
	/**
	 * 是否活着
	 */
	private boolean alive = true;
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		if(this.isAlive()) {
			g.setColor(Color.GREEN);
		}else {
			g.setColor(Color.RED);
		}
		g.fillOval(x-r, y-r, d, d);
		g.setColor(Color.BLACK);
		g.drawString(this.getNumber()+"", x, y);
		g.setColor(c);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (number != other.number)
			return false;
		return true;
	}

	public Person(int number, boolean alive,int x,int y) {
		this.number = number;
		this.alive = alive;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Person [number=" + number + ", alive=" + alive + "]";
	}
}
