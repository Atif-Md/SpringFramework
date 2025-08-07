package com.atiff.model;

public class Student {
	
	private int sno;
	private String sname;
	private String addr;
	private float avg;
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public float getAvg() {
		return avg;
	}
	public void setAvg(float avg) {
		this.avg = avg;
	}
	
	@Override
	public String toString() {
		return "Student [Student no=" + sno + ", Student Name=" + sname + ", Address=" + addr + ", Average=" + avg + "]";
	}
	
}
