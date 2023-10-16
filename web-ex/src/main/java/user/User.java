package user;

public class User {
	private int id;
	private String username;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String tel;
	private String pnum;
	
	public User() {}
	
	public User(String password) {
		this.password = password;
	}
	
	public User( int id,String username,String password,String name,String birth,String gender,String tel,String pnum) {
		this.id = id;
		this.username =username;
		this.password = password;
		this.name=name;
		this.birth =birth;
		this.gender = gender;
		this.tel=tel;
		this.pnum=pnum;
	}
	
	public User(String username,String password) {
		this.username =username;
		this.password = password;
	}
	
	public User(String username,String password,String name) {
		this.username =username;
		this.password = password;
		this.name=name;
	}
	
	public User(UserRequestDto user) {
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.name = user.getName();
		this.birth =user.getBirth();
		this.gender = user.getGender();
		this.tel=user.getTel();
		this.pnum=user.getPnum();
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPnum() {
		return pnum;
	}
	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	
}
