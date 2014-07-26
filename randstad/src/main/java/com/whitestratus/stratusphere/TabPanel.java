package com.whitestratus.stratusphere;

public class TabPanel {
	
	TabSection tabSection;

	public enum Tab {
		BEST_PEOPLE(1), STRONG_CONCEPTS(2), SUPERIOR_BRAND(3), EXCELLENT_EXECUTION(4);
		
		private int dropDownValue;
		
		Tab(int value){
			this.dropDownValue = value;
		}
		
		public int value() {
			return dropDownValue;
		}
	}
}
