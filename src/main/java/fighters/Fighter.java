package fighters;

public interface Fighter {

	void hit(Fighter fighter);
	
	boolean isAlive();
	
	void consumeDamage(double damage);
}
