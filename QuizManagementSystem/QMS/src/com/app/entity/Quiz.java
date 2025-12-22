package com.app.entity;

public class Quiz {
	public int id;
	public String title;
	public Integer creater_id;

	public Quiz() {
	}
	
	public Quiz(int id, String title, Integer creater_id) {
		this.id = id;
		this.title = title;
		this.creater_id = creater_id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getCreater_id() {
		return creater_id;
	}
	
	public void setCreater_id(Integer creater_id) {
		this.creater_id = creater_id;
	}
	
	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", creater_id=" + creater_id + "]";
	}
}

