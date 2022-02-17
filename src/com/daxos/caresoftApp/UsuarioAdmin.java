package com.daxos.caresoftApp;

import java.util.ArrayList;
import java.util.Date;

public class UsuarioAdmin extends User implements UsuarioCompatibleConHIPAA, AdminCompatibleConHIPAA {

	// Dentro de la clase:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
    
    // PARA HACER: Implementar un constructor que tome un ID y un rol
    // PARA HACER: ¡Implementar UsuarioCompatibleConHIPAA!
    // PARA HACER: ¡Implementar AdminCompatibleConHIPAA
    
	public UsuarioAdmin(Integer id, String role) {
		super(id);
		this.role = role;
		securityIncidents = new ArrayList<String>();
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// Devuelve una lista de cadenas (incidentes reportados)
		return securityIncidents;
	}

	@Override
	public boolean assignPin(int pin) {
		// El pin debe tener exactamente 6 dígitos, de lo contrario devuelve false. 
		// Se espera que asigne el pin al usuario (como una variable miembro)
		int length = String.valueOf(pin).length();

		if(length == 6) {
			this.setPin(length);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		//Compara los id y, si no coinciden, crea un reporte de incidente utilizando el método authIncident. 
		// Devuelve true si las identificaciones coinciden, false en caso contrario. 
		if(this.getId() == confirmedAuthID) {
			return true;
		} else {
			authIncident();
			return false;
		}
	}
	
	public void newIncident(String notes) {
        String report = String.format(
            "Fecha y hora de envío: %s \n, Reportado por ID: %s\n Notas: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Fecha y hora de envío: %s \n, ID: %s\n Notas: %s \n", 
            new Date(), this.id, "FALLÓ EL INTENTO DE AUTORIZACIÓN PARA ESTE USUARIO"
        );
        securityIncidents.add(report);
    }

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}        
}
