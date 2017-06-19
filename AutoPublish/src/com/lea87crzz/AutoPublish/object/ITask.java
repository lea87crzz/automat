package com.lea87crzz.AutoPublish.object;

public interface ITask {	
	
	public boolean execute();
	
	public Result getResult();
	
	public String getDescription();
	
	public String getName();
}
