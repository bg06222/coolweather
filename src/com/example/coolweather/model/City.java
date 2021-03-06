package com.example.coolweather.model;

public class City {
	private int id;
	private String cityName;
	private String cityCode;
	private int provinceId;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String name) {
		this.cityName = name;
	}
	
	public String getCityCode() {
		return cityCode;
	}
	
	public void setCityCode(String code) {
		this.cityCode = code;
	}
	
	public int getProvinceId() {
		return this.provinceId;
	}
	
	public void setProvinceId(int id) {
		this.provinceId = id;
	}

}
