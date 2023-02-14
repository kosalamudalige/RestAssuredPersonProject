package amp.api.model;

public class Person {

	private String firstName ;
	private String lastName ;
	private int age ;
	private int id ;
	private String address ;
	private int phoneNumber ;
	
	public Person() {
		
	}
	
	public Person(String firstName, String lastName, int age, int id, String address, int phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.id = id;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
