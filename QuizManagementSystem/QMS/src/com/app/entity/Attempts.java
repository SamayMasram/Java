package com.app.entity;

import java.time.LocalDateTime;

public class Attempts {
	public int id;
	public int quiz_id;
	public int student_id;
	public int score;
	public int total;
	public LocalDateTime attemptTime;
	
	public Attempts() {
	}
	
	public Attempts(int id, int quiz_id, int student_id, int score, int total, LocalDateTime attemptTime) {
		this.id = id;
		this.quiz_id = quiz_id;
		this.student_id = student_id;
		this.score = score;
		this.total = total;
		this.attemptTime = attemptTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDateTime getAttemptTime() {
		return attemptTime;
	}

	public void setAttemptTime(LocalDateTime attemptTime) {
		this.attemptTime = attemptTime;
	}

	@Override
	public String toString() {
		return "AttemptModel [id=" + id + ", quiz_id=" + quiz_id + ", student_id=" + student_id + ", score=" + score
				+ ", total=" + total + ", attemptTime=" + attemptTime + "]";
	}
}
