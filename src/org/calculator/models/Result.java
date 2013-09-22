package org.calculator.models;

import java.io.Serializable;

public class Result implements Serializable {


	private static final long serialVersionUID = 8375816462845029733L;
	private long x;
	private double y;

	public Result() {

	}

	public Result(long x, double y) {
		this.x = x;
		this.y = y;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
