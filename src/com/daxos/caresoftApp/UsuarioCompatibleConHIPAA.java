package com.daxos.caresoftApp;

public interface UsuarioCompatibleConHIPAA {
	abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}
