package com.capgemini.HostelManagementSystem.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Hostellor
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column
private String hostellorname;
@Column
private String collegename;
@Column
private int age;
@Column
private int roomno;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHostellorname() {
		return hostellorname;
	}
	public void setHostellorname(String hostellorname) {
		this.hostellorname = hostellorname;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	
	
}