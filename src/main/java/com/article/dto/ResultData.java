package com.article.dto;

import java.util.Map;

import com.article.util.Util;

import lombok.Data;

@Data
public class ResultData {
	private String reusltCode;
	private String msg;
	private Map<String, Object>body;
	
	public ResultData(String reusltCode, String msg, Object...args) {
		super();
		this.reusltCode = reusltCode;
		this.msg = msg;
		this.body = Util.mapOf(args);
	}
	
	public boolean isSuccess() {
		return reusltCode.startsWith("S-");
	}
	
	public boolean isFail() {
		return isSuccess() == false;
	}
}
