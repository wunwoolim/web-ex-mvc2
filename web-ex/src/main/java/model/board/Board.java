package model.board;

public class Board {
    private int id;
    private int user_id;
    private String title;
    private String contents;
    private String in_date;
    private String up_date;
    
    public Board() {}
    
    public Board(String title,String contents,String in_date,String up_date) {
    	this.title = title;
    	this.contents = contents;
    	this.in_date = in_date;
    	this.up_date = up_date;
    }
    
    public Board(int id,int user_id,String title,String contents,String in_date,String up_date) {
    	this.id = id;
    	this.user_id = user_id;
    	this.title = title;
    	this.contents = contents;
    	this.in_date = in_date;
    	this.up_date = up_date;
    }
    
    public Board(BoardRequestDto board) {
    	this.id = board.getId();
    	this.user_id = board.getUser_id();
    	this.title = board.getTitle();
    	this.contents = board.getContents();
    	this.in_date = board.getIn_date();
    	this.up_date = board.getUp_date();
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getIn_date() {
		return in_date;
	}

	public void setIn_date(String in_date) {
		this.in_date = in_date;
	}

	public String getUp_date() {
		return up_date;
	}

	public void setUp_date(String up_date) {
		this.up_date = up_date;
	}
    
    
}
