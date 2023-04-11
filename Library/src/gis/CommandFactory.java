package gis;

import gis.action.*;

public class CommandFactory {
	private CommandFactory() {}
	public static CommandFactory getInstance() {
		return (new CommandFactory());
	}
	public IAction getAction(String Command)
	{
		IAction action=null;
		System.out.println("getAction:"+Command);
		
		switch (Command) {
		
		 case "SelectLibrary": 
			 action = new SelectLibraryAction();
			 break;
		 		
		case "SelectRegion":
			action = new SelectRegionAction();
			break;
			
		case "SelectType":
			action = new SelectTypeAction();
			break;
			
		case "DefaultLibrary":
		default:
			action= new DefaultLibraryAction();
			break;
		}
		return action;
	}

}
