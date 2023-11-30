package com.akechsalim.demo.todo;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
public class Todo {
	@Id
	@SequenceGenerator(name = "todo_sequence", sequenceName = "todo_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "todo_sequence")
	private Integer id;
	private String username;
	private String description;
	private LocalDate targetDate;
	private boolean done;

	public Todo() {
		
	}

	public Todo(String username, String description, LocalDate targetDate, boolean done) {
		this.username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo{" +
				"id=" + id +
				", username='" + username + '\'' +
				", description='" + description + '\'' +
				", targetDate=" + targetDate +
				", done=" + done +
				'}';
	}
}