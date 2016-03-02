package covoiturage.bl.model;

public class AdresseGoogle {
	
	private String adresse;

	public AdresseGoogle(String addressNumber, String addressWay,String addressCp, String addressCity) {
		super();
		this.adresse = 
				addressNumber + ", " +
				addressWay + ", " +
				addressCp + " " +
				addressCity + ", France";
	}

	public String getAdresse() {
		return adresse;
	}
	
}
