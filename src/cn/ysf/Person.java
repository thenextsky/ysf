package cn.ysf;

public class Person {
	/**
	 * 编号，从1开始
	 */
	private int number;
	/**
	 * 是否活着
	 */
	private boolean alive = true;

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

	public Person(int number, boolean alive) {
		super();
		this.number = number;
		this.alive = alive;
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
