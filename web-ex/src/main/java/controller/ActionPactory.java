package controller;

import controller.board.BoardAction;
import controller.board.BoardCreateAction;
import controller.board.BoardDeleteAction;
import controller.board.BoardUpdateAction;
import controller.user.JoinAction;
import controller.user.LoginAction;
import controller.user.LogoutAction;
import controller.user.MemberListAction;
import controller.user.MypageAction;
import controller.user.editUserAction;
import controller.user.leaveAction;

public class ActionPactory {
	private ActionPactory(){}
	private static ActionPactory instance = new ActionPactory();
	public static ActionPactory getInstance() {
		return instance;
	}
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionPactory : "+command);
		
		if(command.equals("login")) {
			action = new LoginAction();
		}else if(command.equals("logout")) {
			action = new LogoutAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("passwordCheck")) {
			action = new MypageAction();
		}else if(command.equals("updateCheck")) {
			action = new editUserAction();
		}else if(command.equals("deleteCheck")) {
			action = new leaveAction();
		}else if(command.equals("memberList")) {
			action = new MemberListAction();
		}else if(command.equals("board")) {
			action = new BoardAction();
		}else if(command.equals("boardCreate")) {
			action = new BoardCreateAction();
		}else if(command.equals("boardUpdate")) {
			action = new BoardUpdateAction();
		}else if(command.equals("boardDelete")) {
			action = new BoardDeleteAction();
		}
		
		
		return action;
	}
}
