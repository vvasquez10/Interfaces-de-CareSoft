package com.daxos.caresoftApp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements UsuarioCompatibleConHIPAA {

    private ArrayList<String> patientNotes;

	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean assignPin(int pin) {
		// El pin debe tener exactamente 4 dígitos, de lo contrario devuelve false. 
		// Se espera que asigne el pin al usuario (como una variable miembro)
		int length = String.valueOf(pin).length();

		if(length == 4) {
			this.setPin(length);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		//Verifica la identificación del médico versus la identificación dada; devuelve true si coinciden, de lo contrario, devuelve false.
		if(this.getId() == confirmedAuthID) {
			return true;
		} else {
			return false;
		}
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format("Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // PARA HACER: Setters y Getters

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}	
	
}
