package com.ssafy.happyhouse.model.dto;

public class HouseDeal implements Comparable<HouseDeal> {

	public static String APT_DEAL = "아파트 매매";
	public static String APT_RENT = "아파트 전월세";
	public static String HOUSE_DEAL = "주택 매매";
	public static String HOUSE_RENT = "주택 전월세";

	/** 거래 정보를 식별할 번호 */
	private int no;
	/** 법정 동명 */
	private String dong;
	/** 아파트 이름 */
	private String aptName;
	/** 법정 동코드 */
	private int code;
	/** 거래 금액 */
	private String dealAmount;
	/** 건축 연도 */
	private int buildYear;
	/** 거래 연도 */
	private int dealYear;
	/** 거래 월 */
	private int dealMonth;
	/** 거래 일 */
	private int dealDay;
	/** 전용면적 */
	private double area;
	/** 층 */
	private int floor;
	/** 지번 */
	private String bozung;
	/** */
	private String lat;
	private String lng;
	private String jibun;

	private double landArea;

	/**
	 * type 1 : 아파트 매매 2 : 연립 다세세 매매 3 : 아파트 전월세 4 : 연립 다세세 전월세
	 */
	private String type;
	private String rentMoney;

	private String img;

	public HouseDeal() {
	}

	public HouseDeal(int no) {
		super();
		this.no = no;
	}

	public boolean isMine(int no) {
		return this.no == no;
	}

	public String getBozung() {
		return bozung;
	}

	public void setBozung(String bozung) {
		this.bozung = bozung;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(String rentMoney) {
		this.rentMoney = rentMoney;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public double getLandArea() {
		return landArea;
	}

	public void setLandArea(double landArea) {
		this.landArea = landArea;
	}

	@Override
	public String toString() {
		return "HouseDeal [no=" + no + ", dong=" + dong + ", AptName=" + aptName + ", code=" + code + ", dealAmount="
				+ dealAmount + ", buildYear=" + buildYear + ", dealYear=" + dealYear + ", dealMonth=" + dealMonth
				+ ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor + ", lat=" + lat + ", lng=" + lng
				+ ", jibun=" + jibun + ", type=" + type + ", rentMoney=" + rentMoney + ", img=" + img + "]";
	}

	@Override
	public int compareTo(HouseDeal o) {
		// TODO Auto-generated method stub
		if (this.dealAmount == null) {
			this.dealAmount = "0";
		}
		if (o.dealAmount == null) {
			o.dealAmount = "0";
		}

		this.dealAmount = this.dealAmount.replace(",", "").trim();
		o.dealAmount = o.dealAmount.replace(",", "").trim();
		return Integer.parseInt(o.dealAmount) - Integer.parseInt(this.dealAmount);
	}
}

// stem.out.println(this +" " + o);
