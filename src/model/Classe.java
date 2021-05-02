package model;

/**
 * @author Admin
 *
 */
public class Classe 
{
	private String name;
	private int nbBoys;
	private int nbGirls;
	
	public Classe(String name, int nbBoys, int nbGirls) {
		this.name = name;
		this.nbBoys = nbBoys;
		this.nbGirls = nbGirls;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbBoys() {
		return nbBoys;
	}

	public void setNbBoys(int nbBoys) {
		this.nbBoys = nbBoys;
	}

	public int getNbGirls() {
		return nbGirls;
	}

	public void setNbGirls(int nbGirls) {
		this.nbGirls = nbGirls;
	}

	@Override
	public String toString() {
		return "Classe [name=" + name + ", nbBoys=" + nbBoys
				+ ", nbGirls=" + nbGirls + "]";
	}
	
}

