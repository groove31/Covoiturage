package covoiturage.bl.model;

import java.io.Serializable;

public class UserDB implements Serializable {
	public UserDB(int ID, String email, String lastName, String firstName, String addressNumber, String addressWay,
			String addressCP, String addressCity, String longitude, String latitude, String sexe, String phoneNumber,  
			String isConducteur, String isSmoker, String area, String password ) {
		super();
		this.ID = ID;
		this.email = email;
		this.lastName = lastName;
		this.firstName = firstName;
		this.addressNumber = addressNumber;
		this.addressWay = addressWay;
		this.addressCP = addressCP;
		this.addressCity = addressCity;
		this.longitude = longitude;
		this.latitude = latitude;
		this.sexe = sexe;
		this.phoneNumber = phoneNumber;
		this.isConducteur = isConducteur;
		this.isSmoker = isSmoker;
		this.area = area;
		this.password = password;
		
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int ID;
	private  String email="";
	private  String lastName="";
	private  String firstName="";
	private  String addressNumber="";
	private  String addressWay="";
	private  String addressCP="";
	private  String addressCity="";
	private  String longitude="";
	private  String latitude="";
	private  String sexe;
	private  String phoneNumber;
	private  String isConducteur;
	private  String isSmoker;
	private  String area;
	private  String password;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddressNumber() {
		return addressNumber;
	}
	public void setAdressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getAddressWay() {
		return addressWay;
	}
	public void setAddressWay(String addressWay) {
		this.addressWay = addressWay;
	}
	public String getAddressCP() {
		return addressCP;
	}
	public void setAddressCP(String addressCP) {
		this.addressCP = addressCP;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getIsConducteur() {
		return isConducteur;
	}
	public void setConducteur(String isConducteur) {
		this.isConducteur = isConducteur;
	}
	public void setIsConducteur(String isConducteur) {
		this.isConducteur = isConducteur;
	}

	public String getIsSmoker() {
		return isSmoker;
	}
	public void setSmoker(String isSmoker) {
		this.isSmoker = isSmoker;
	}
	public void setIsSmoker(String isSmoker) {
		this.isSmoker = isSmoker;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}



}

