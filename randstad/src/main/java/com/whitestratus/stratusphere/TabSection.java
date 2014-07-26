package com.whitestratus.stratusphere;

public class TabSection {
	MenuItem menuItem;

	public enum Section {
		LINKS_IN_THIS_SECTION(1), FEATURED_ARTICLES(2), EXTERNAL_LINKS(3); 
		private int dropDownValue;
		
		Section(int value){
			this.dropDownValue = value;
		}
		
		public int value() {
			return dropDownValue;
		}
	}
}
