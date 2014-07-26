package com.whitestratus.stratusphere;

public class MenuHeader {
	
	TabPanel tab;
	
	public enum Menu {
		PRIMARY_MEGA_MENU(1);
		private int dropDownValue;
		
		Menu(int value){
			this.dropDownValue = value;
		}
		
		public int value() {
			return dropDownValue;
		}
	}

}
