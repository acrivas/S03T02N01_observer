package singleton;

public interface Observer {
	
	public void update(double currentDowJones, String evolution);
	public String getName();
	public String toString();

}
