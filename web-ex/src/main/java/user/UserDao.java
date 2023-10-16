package user;

import java.util.ArrayList;
import java.util.Arrays;

public class UserDao {
	
	private ArrayList<User>list;
	
	//GoF 디자인 패턴 중 > 생성 패턴 중 하나인 > Singletone
	
	//1) 생성자를 private로 돌림  
	// new 키워드 사용 x
	// 클래스 외부에서 객체를 생성할 수 없도록 차단
	private UserDao(){
		list = new ArrayList<>();
	}
	
	//2) 단일 객체를 생성함
	// 클래스 내부에서만 private 생성자를 사용할 수 있다
	// static 영역에 둠
	private static UserDao instance = new UserDao();
	
	//3) public static getter 제공
	// UserDao 객체를 얻을 수 있는 유일한 메소드
	public static UserDao getInstance() {
		return instance;
	}
	
	
	// User에 대한 CRUD 메소드를 구현
	// 저장소 : list
	
	//Create
	//Read
	//Update
	//Delete
	
	public int getSize() {
		return list.size();
	}
	
	public boolean createUser(UserRequestDto user) {
		if(isDuplicatedUser(user)) {
			return false;
		}
		User newUser = new User(user);
		newUser.setId(generateId());
		list.add(newUser);
		return true;
	}
	
	public boolean isDuplicatedUser(UserRequestDto user) {
		for(int i=0; i<list.size(); i++) {
			if(user.getUsername().equals((list).get(i).getUsername())) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean duplicatedUser(UserRequestDto user) {
		for(int i=0; i<list.size(); i++) {
			if(user.getUsername().equals((list).get(i).getUsername()) && user.getPassword().equals((list).get(i).getPassword())) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean passwoerUser(UserRequestDto user) {
		for(int i=0; i<list.size(); i++) {
			if(user.getPassword().equals((list).get(i).getPassword())) {
				return true;
			}
		}
		
		return false;
	}
	
	private int generateId() {
		int id = 0;
		boolean idDupl = false;
		do {
			id =(int) Math.floor(Math.random() * (9999-1000+1))+1000; // 1000~9999 랜덤
			
			
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).getId() == id){
					idDupl = true;
				}
			}
		}while(idDupl);
		
		return id;
	}
	
	public UserResponseDto findById(int id) {
		for(int i=0; i<list.size(); i++) {
			User user = list.get(i);
			if(user.getId() == id) {
				return new UserResponseDto(user);
			}
		}
		return null;
	}
	
	public UserResponseDto findByUsername(String username) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUsername().equals(username)) {
				return new UserResponseDto(list.get(i));
			}
		}
		return null;
	}
	
	private User getUser(UserRequestDto userDto) {
		User user = null;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getUsername().equals(userDto.getUsername())) {
				user = list.get(i);
			}
		}
		return user;
	}
	
	public ArrayList<UserResponseDto> findAll() {
		ArrayList<UserResponseDto> respons = new ArrayList<>();
		
		for(int i=0; i<list.size(); i++) {
			User user = list.get(i);
			respons.add(new UserResponseDto(user));
		}
		return respons;
	}
	
	public boolean setUser(UserRequestDto user) {
		User target = getUser(user);
		
		if(target == null) {
			return false;
		}
		target.setUsername(user.getUsername());
		target.setPassword(user.getPassword());
		target.setName(user.getName());
		target.setBirth(user.getBirth());
		target.setGender(user.getGender());
		target.setTel(user.getTel());
		target.setPnum(user.getPnum());
		
		return true;
	}
	
	public boolean delsetUser(UserRequestDto user) {
		System.out.println("user : "+user.getUsername());
		
		User target = getUser(user);
		
		if(target == null) {
			return false;
		}
		
		if(!target.getPassword().equals(user.getPassword())) {
			return false;
		}
		
		list.remove(target);
		
		return true;
	}
	
}
