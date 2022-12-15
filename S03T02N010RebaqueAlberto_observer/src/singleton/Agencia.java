package singleton;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Agencia implements Observer {
	
	private double currentDowJones;
	private String evolution;
	private Observable agente;
	private String name;
	
	public Agencia(Observable agente, String name) {
		this.agente = agente;
		agente.registerObserver(this);
		this.name = name;
	}
	
	public void update(double currentDowJones, String evolution) {
		this.currentDowJones = currentDowJones;
		this.evolution = evolution;
		System.out.println("Mensaje para la agencia: \"Estimado/a " + this.name + ", " + this.evolution + " respecto a la última referencia y actualmente tiene un valor de " + BigDecimal.valueOf(this.currentDowJones).setScale(2, RoundingMode.HALF_UP)+ " puntos.\"");
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Agencia: " + this.name + ", currentDowJones: " + currentDowJones + ", evolution: " + evolution + ", agente: " + agente;
	}
	
	

}
