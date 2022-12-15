package singleton;

public interface Observable {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers(double currentDowJones, String evolution);

}
