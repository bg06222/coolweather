package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.model.City;
import com.example.coolweather.model.CoolWeatherDB;
import com.example.coolweather.model.County;
import com.example.coolweather.model.Province;

public class Util {
	public synchronized static  boolean saveProvinceIntoDB(CoolWeatherDB db, String response) {
		if(!TextUtils.isEmpty(response)) {
			String[] str1 = response.split(",");
			if(str1 != null && str1.length > 0) {
				for (String str : str1) {
					String[] str2 = str.split("\\|");
					Province province = new Province();
					province.setProvinceCode(str2[0]);
					province.setProvinceName(str2[1]);
					db.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	public synchronized static boolean saveCityIntoDB(CoolWeatherDB db, String response, Province province) {
		if (!TextUtils.isEmpty(response)) {
			String[] str1 = response.split(",");
			if (str1 != null && str1.length > 0) {
				for (String str : str1) {
					String[] str2 = str.split("\\|");
					City city = new City();
					city.setCityCode(str2[0]);
					city.setCityName(str2[1]);
					city.setProvinceId(province.getId());
					db.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}
	
	public synchronized static boolean saveCountyIntoDB(CoolWeatherDB db, String response, City city) {
		if (!TextUtils.isEmpty(response)) {
			String[] countys = response.split(",");
			if ( countys != null && countys.length > 0 ) {
				for ( String c : countys ) {
					String[] str = c.split("\\|");
					County county = new County();
					county.setCountyCode(str[0]);
					county.setCountyName(str[1]);
					county.setCityId(city.getId());
					db.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}
}
