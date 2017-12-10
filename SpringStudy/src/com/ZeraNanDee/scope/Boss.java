package com.ZeraNanDee.scope;

public class Boss {
	private String name;
	private Car car;

	public Boss() {
	}

	public Car getCar() {
		return car;
	}
	public void setCar(Car car)
	{
		this.car=car;
	}
	public String toString()
	{
		return "name:"+name+"\n car:"+car;
	}
	
}
