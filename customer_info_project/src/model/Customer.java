package model;

public class Customer {
	
	private String name,phone,email;
	private char gender;
	private int age;
	
	public Customer(String name, char gender, int age, String phone, String email) {
		
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setGender(char gender) {
		this.gender=gender;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public char getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}

}
