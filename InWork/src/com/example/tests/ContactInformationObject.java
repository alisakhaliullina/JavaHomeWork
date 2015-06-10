package com.example.tests;

public class ContactInformationObject implements Comparable<ContactInformationObject> {
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String byear;
	private String address2;
	private String phone2;
	

	public ContactInformationObject(String firstname, String lastname,
			String address, String home, String mobile, String work,
			String email, String email2, String byear, String address2,
			String phone2, String id) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.byear = byear;
		this.address2 = address2;
		this.phone2 = phone2;
		
	}

	public ContactInformationObject() {
		
	}

	public ContactInformationObject setFirstname(String firstname) {
		this.firstname = firstname;
			return this;
	}
	public ContactInformationObject setLastname(String lastname) {
		this.lastname = lastname;
			return this;
	}
	public ContactInformationObject setAddress(String address) {
		this.address = address;
			return this;
	}
	public ContactInformationObject setHome(String home) {
		this.home = home;
			return this;
	}
	public ContactInformationObject setMobile(String mobile) {
		this.mobile = mobile;
			return this;
	}
	
	public ContactInformationObject setWork(String work) {
		this.work = work;
			return this;
	}
	public ContactInformationObject setEmail(String email) {
		this.email = email;
			return this;
	}
	public ContactInformationObject setEmail2(String email2) {
		this.email2 = email2;
			return this;
	}
	public ContactInformationObject setAddress2(String address2) {
		this.address2 = address2;
			return this;
	}
	public ContactInformationObject setPhone2(String phone2) {
		this.phone2 = phone2;
			return this;
	}
	public ContactInformationObject setByear(String byear) {
		this.byear = byear;
			return this;
		
	}
		
	@Override
	    public String toString() {
	          return "ContactInformationObject {" + "name='" + firstname + '\'' + '}';
	      }
	
	@Override
		public int hashCode() {
			final int prime = 31;
				int result = 1;
		return result;
		}

	@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
		ContactInformationObject other = (ContactInformationObject) obj;
			if (firstname == null) {
				if (other.firstname != null)
					return false;
			} 
			else if (!firstname.equals(other.firstname))
				return false;
			return true;
		}

	public int compareTo(ContactInformationObject other) {
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
		
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getByear() {
		return byear;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

}