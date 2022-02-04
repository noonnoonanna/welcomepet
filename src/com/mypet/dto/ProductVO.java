package com.mypet.dto;

public class ProductVO {
	private int pNum; 	
	private String pName;	
	private int pPrice;
	private String CP; 		
	private String pImg; 	
	private String pInfo; 
	private String kind;
	private String cateCode;
	private String cateName;
	
	
	@Override
	public String toString() {
		return "ProductVO [pNum=" + pNum + ", pName=" + pName + ", pPrice=" + pPrice + ", CP=" + CP + ", pImg=" + pImg
				+ ", pInfo=" + pInfo + ", kind=" + kind + ", cateCode=" + cateCode + ", cateName=" + cateName + "]";
	}

	public String getCateCode() {
		return cateCode;
	}

	public void setCateCode(String cateCode) {
		this.cateCode = cateCode;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}


	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public int getpNum() {
		return pNum;
	}
	public void setpNum(int pNum) {
		this.pNum = pNum;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public String getCP() {
		return CP;
	}
	public void setCP(String cP) {
		CP = cP;
	}
	public String getpImg() {
		return pImg;
	}
	public void setpImg(String pImg) {
		this.pImg = pImg;
	}
	public String getpInfo() {
		return pInfo;
	}
	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}
}
