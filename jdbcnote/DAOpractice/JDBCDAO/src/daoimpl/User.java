package daoimpl;

public class User {
  private int id ;
  
private String username;
  private String password;
  private int age;
  private String address;
  public User(int id, String username, String password, int age, String address, String phone) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
	this.age = age;
	this.address = address;
	this.phone = phone;
}
		  public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		private String phone;
		}
