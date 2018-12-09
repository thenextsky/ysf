package cn.ysf;

import java.io.Serializable;

/**
 * 运行参数
 */
public class Param implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 初始n个人
	 */
	private int n;
	/**
	 * 数到m的那个人出列
	 */
	private int m;
	/**
	 * 从k开始报数
	 */
	private int k;

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public Param(int n, int m, int k) {
		this.n = n;
		this.m = m;
		this.k = k;
	}

	@Override
	public String toString() {
		return "Param [n=" + n + ", m=" + m + ", k=" + k + "]";
	}
	
	
}
