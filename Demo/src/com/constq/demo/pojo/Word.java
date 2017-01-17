package com.constq.demo.pojo;

import java.io.Serializable;

public class Word implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String english;
	private String chinese;
	private int type;
	private String type_name;
	private int rank;
	public Word() {
		super();
	}
	public Word(String english, String chinese, int type, String type_name,
			int rank) {
		super();
		this.english = english;
		this.chinese = chinese;
		this.type = type;
		this.type_name = type_name;
		this.rank = rank;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Word [id=" + id + ", english=" + english + ", chinese="
				+ chinese + ", type=" + type + ", type_name=" + type_name
				+ ", rank=" + rank + "]";
	}
	
}
