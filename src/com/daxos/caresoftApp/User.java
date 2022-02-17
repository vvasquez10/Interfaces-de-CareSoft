package com.daxos.caresoftApp;

public class User {
    protected Integer id;
    protected int pin;
    
	public User(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}        
    
    // PARA HACER: Getters y Setters
    // Implementar un constructor que tome un ID
}