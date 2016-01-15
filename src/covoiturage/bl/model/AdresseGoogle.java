package covoiturage.bl.model;

public class AdresseGoogle {
	
	private String adresse;

	public AdresseGoogle(String addressNumber, String addressWay,String addressCP, String addressCity) {
		super();
		this.adresse = 
				addressNumber + ", " +
				addressWay + ", " +
				addressCP + " " +
				addressCity + ", France";
	}

	public String getAdresse() {
		return adresse;
	}
	
}
