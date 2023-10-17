package model.board;

public class BoardResponseDto {
	private int id;
    private int user_id;
    private String title;
    private String contents;
    private String in_date;
    private String up_date;
    
    public BoardResponseDto(Board board) {
    	this.id = board.getId();
    	this.user_id = board.getUser_id();
    	this.title = board.getTitle();
    	this.contents = board.getContents();
    	this.in_date = board.getIn_date();
    	this.up_date = board.getUp_date();
    }
    
    public BoardResponseDto(BoardRequestDto board) {
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

	public int getUser_id() {
		return user_id;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getIn_date() {
		return in_date;
	}

	public String getUp_date() {
		return up_date;
	}
    
	@Override
	public String toString() {
		return String.format("%d) %s/%s/%s/%s/%s ", this.id,this.user_id,this.title,this.contents,this.in_date,this.up_date);
	}
}
