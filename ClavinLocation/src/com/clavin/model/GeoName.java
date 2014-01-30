package com.clavin.model;

import java.io.Serializable;

public class GeoName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer geonameID;
	private String name;
	private String asciiName;
	private Double latitude;
	private Double longitude;
	private String primaryCountryCode;
	private String timezone;
	private String primaryCountryName;
	
	public Integer getGeonameID() {
		return geonameID;
	}
	public void setGeonameID(Integer geonameID) {
		this.geonameID = geonameID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAsciiName() {
		return asciiName;
	}
	public void setAsciiName(String asciiName) {
		this.asciiName = asciiName;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getPrimaryCountryCode() {
		return primaryCountryCode;
	}
	public void setPrimaryCountryCode(String primaryCountryCode) {
		this.primaryCountryCode = primaryCountryCode;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getPrimaryCountryName() {
		return primaryCountryName;
	}
	public void setPrimaryCountryName(String primaryCountryName) {
		this.primaryCountryName = primaryCountryName;
	}

}
