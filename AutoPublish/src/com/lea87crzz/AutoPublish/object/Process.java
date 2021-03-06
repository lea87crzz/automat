package com.lea87crzz.AutoPublish.object;

import java.util.ArrayList;

import com.lea87crzz.AutoPublish.view.LocaleUtils;

public class Process implements ITask {
	ArrayList<ITask> tasks;
	private String name="";
	protected Result result=Result.NOT_EJECUTED;
	
	public Process(){
		tasks=new ArrayList<ITask>();
	}
	
	public Process(String name){
		this.name=name;
		tasks=new ArrayList<ITask>();
	}
	
	public ArrayList<ITask> getTasks(){
		return this.tasks;
	}
	
	public void addTask(ITask task){
		tasks.add(task);
	}

	public boolean execute() {
		for(ITask t:tasks){
			System.out.println(t.getDescription());
			t.execute();
			result=t.getResult();
			if(t.getResult().equals(Result.ERROR)){
				System.out.println(LocaleUtils.getString("process.error"));
				return false;
			} else{
				System.out.println(LocaleUtils.getString("process.completed"));
			}
		}
		return true;
		
	}
	
	public String getName(){
		return name;
	}


	@Override
	public Result getResult() {
		return result;
	}

	@Override
	public String getDescription() {
		return LocaleUtils.getString("process.description")+" "+name;
	}

}
