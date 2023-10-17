package controller;

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
		
		System.out.println("ActionPactory"+command);
		
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
		}else if(command.equals("memderList")) {
			action = new MemberListAction();
		}
		
		
		return action;
	}
}
