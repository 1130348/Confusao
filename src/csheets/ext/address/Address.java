package csheets.ext.address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Cristina
 */
@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	/**
	 * The name of the street
	 */
	private String street;

	/**
	 * The name of the locality
	 */
	private String locality;

	/**
	 * The postal code of the address
	 */
	private String postal_code;

	/**
	 * The city of the address
	 */
	private String city;

	/**
	 * The country of the address
	 */
	private String country;

	/**
	 * Constructor without parameters
	 */
	public Address() {
		this.street = "";
		this.locality = "";
		this.postal_code = "";
		this.city = "";
		this.country = "";
	}

	/**
	 * Constructor with parameters
	 *
	 * @param tmp_street
	 * @param tmp_locality
	 * @param tmp_postal_code
	 * @param tmp_city
	 * @param tmp_country
	 */
	public Address(String tmp_street, String tmp_locality,
				   String tmp_postal_code, String tmp_city, String tmp_country) {
		this.street = tmp_street;
		this.locality = tmp_locality;
		this.postal_code = tmp_postal_code;
		this.city = tmp_city;
		this.country = tmp_country;
	}

	/**
	 * Returns the name of the street
	 *
	 * @return street
	 */
	public String getStreet() {
		return this.street;
	}

	/**
	 * Returns the name of the locality
	 *
	 * @return locality
	 */
	public String getLocality() {
		return this.locality;
	}

	/**
	 * Returns the name of the city
	 *
	 * @return city
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Returns the name of the country
	 *
	 * @return country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * Returns the name of the postal code
	 *
	 * @return postal_code
	 */
	public String getPostalCode() {
		return this.postal_code;
	}

	/**
	 * Changes the name of the postal code
	 *
	 */
	public void setPostalCode(String tmp) {
		this.postal_code = tmp;
	}

	/**
	 * Changes the name of the country
	 *
	 */
	public void setCountry(String tmp) {
		this.country = tmp;
	}

	/**
	 * Changes the name of the city
	 *
	 */
	public void setCity(String tmp) {
		this.city = tmp;
	}

	/**
	 * Changes the name of the street
	 *
	 */
	public void setStreet(String tmp) {
		this.street = tmp;
	}

	/**
	 * Changes the name of the locality
	 *
	 */
	public void setLocality(String tmp) {
		this.locality = tmp;
	}

	/**
	 * Compares two addresss
	 *
	 * @param a
	 * @return true or false
	 */
	public boolean equals(Address a) {
		return this.city.equals(a.city) && this.country.equals(a.country) && this.street.
			equals(a.street) && this.postal_code.equals(a.postal_code) && this.locality.
			equals(a.locality);
	}

	/**
	 * To String of the class Address
	 *
	 * @return string
	 */
	@Override
	public String toString() {
		return "ADRESS:\n- Street: " + this.street + "\n- City: " + this.city + "\n- Locality: " + this.city + "\n- Postal Code: " + this.postal_code + "\n- Country: " + this.country + "\n";
	}
}
