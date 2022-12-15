package singleton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Agente implements Observable {
	
	private ArrayList observers;
	private double lastDowJones;
	private double currentDowJones;
	private String evolution;
	
	public Agente() {
		observers = new ArrayList();
		lastDowJones = 34564.10d;
		//currentDowJones = 34564.10f;
		
	}
	
	public double getLastDowJones() {
		return lastDowJones;
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers(double currentDowJones, String evolution) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(currentDowJones, evolution);
			System.out.println("Mensaje para el agente: \"La agencia " + observer.getName() + " ha sido notificada.\"");
		}
	}
	
	public void dowJonesChanged(double currentDowJones) {
		BigDecimal lastDowJonesBD = BigDecimal.valueOf(lastDowJones);
		BigDecimal currentDowJonesBD = BigDecimal.valueOf(currentDowJones);
		BigDecimal difference = currentDowJonesBD.subtract(lastDowJonesBD).setScale(2, RoundingMode.HALF_UP);
		System.out.println("Variación: " + difference);
		BigDecimal absDifference = difference.abs();
		if (absDifference.compareTo(BigDecimal.valueOf(0.10d)) >= 0) {
			if (currentDowJonesBD.compareTo(lastDowJonesBD) > 0) {
				evolution = "el índice DowJones ha subido";
			} else if (currentDowJonesBD.compareTo(lastDowJonesBD) <= 0) {
				evolution = "el índice DowJones ha bajado";
			}
			notifyObservers(currentDowJones, evolution);
		} else {
			System.out.println("Variación menor de 0,10 puntos, no se notifica.");
		}
		lastDowJones = currentDowJones;
	}
}
