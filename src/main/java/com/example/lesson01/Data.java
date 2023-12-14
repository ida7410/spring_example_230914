package com.example.lesson01;

// 일반 java bean이 되도록 annotaion 생략
public class Data {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// alt shift s (오른쪽 클릭 > source) > generate getter and setter
	// sort : getter/setter pair는 getter랑 setter 쌍으로, getter then setter는 getter는 전부 위에 setter는 전부 아래에
	
}
