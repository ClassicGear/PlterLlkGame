package com.plter.linkgame.reader;

public class GamePkg {
	
	
	public GamePkg(String name,Background background,Picture[] pictures, Background[] backgrounds) {
		this.background=background;
		this.name=name;
		this.pictures=pictures;
		//
		//背景图组。
		this.backgrounds=backgrounds;
	}
	
	public String getName() {
		return name;
	}
	public Picture[] getPictures() {
		return pictures;
	}
	public Background getBackground() {
		return background;
	}
	//
	public Background[] getBackgrounds() {
		return backgrounds;
	}
	//返回背景组。
	
	private Background background=null;
	private String name="";
	private Picture[] pictures=null;
	//
	//背景图组。
	private Background[] backgrounds=null;
}
