package com.mypet.dto;

public class CategoryVO {
	private String cateCode;
	private String cateName;
	

	@Override
	public String toString() {
		return "CategoryVO [cateCode=" + cateCode + ", cateName=" + cateName + "]";
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
}
