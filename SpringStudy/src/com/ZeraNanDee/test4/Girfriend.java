package com.ZeraNanDee.test4;

public class Girfriend {
private String name;
public Girfriend() {
	System.out.println("调用默认的构造方法");
}
public String getName() {
	System.out.println("获得属性值");
	return name;
}
public void setName(String name) {
	System.out.println("给属性赋值");
	this.name = name;
}
public void Init() {
	System.out.println("这个是它的init方法（初始化）");
}
public void destroy() {
	System.out.println("销毁这个方法");
}
@Override
public String toString() {
	return "Girfriend [name=" + name + "]";
}

}
