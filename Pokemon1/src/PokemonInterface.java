
public interface PokemonInterface {
	public double getWeight();
	public double getHealth();
	public String getName();
	public int getExp();
	
	
	public void setName(String name);
	public void setExp(int value);
	public void eat(Foods berry);
	public void reducedHealth(double value);
	public void reducedWeight(double value);
	

}
