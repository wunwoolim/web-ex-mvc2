package model.user;

public class UserResponseDto {
	private int id;
	private String username;
	private String password;
	private String name;
	private String birth;
	private String gender;
	private String tel;
	private String pnum;
	
	public UserResponseDto(User user) {
		this.id = user.getId();
		this.username =user.getUsername();
		this.password = user.getPassword();
		this.name=user.getName();
		this.birth=user.getBirth();
		this.gender=user.getGender();
		this.tel=user.getTel();
		this.pnum=user.getPnum();
	}
	
	public UserResponseDto(UserRequestDto user) {
		this.id = user.getId();
		this.username =user.getUsername();
		this.password = user.getPassword();
		this.name=user.getName();
		this.birth=user.getBirth();
		this.gender=user.getGender();
		this.tel=user.getTel();
		this.pnum=user.getPnum();
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBirth() {
		return birth;
	}

	public String getGender() {
		return gender;
	}

	public String getTel() {
		return tel;
	}

	public String getPnum() {
		return pnum;
	}

	@Override
	public String toString() {
		return String.format("%d) %s/%s/%s/%s/%s/%s/%s ", this.id,this.username,this.password,this.name,this.birth,this.gender,this.tel,this.pnum);
	}
	
}
