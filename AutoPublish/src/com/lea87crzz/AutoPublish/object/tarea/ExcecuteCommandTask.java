package com.lea87crzz.AutoPublish.object.tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.lea87crzz.AutoPublish.object.Result;

public class ExcecuteCommandTask extends Task {

	private String cmd;
	private String path;
	private Boolean wait;
	
	public ExcecuteCommandTask(String name) {
		super(name);
		wait=false;
	}
	
	public ExcecuteCommandTask(String name,String path,String cmd,Boolean wait) {
		super(name);
		this.path=path;
		this.cmd=cmd;
		this.wait=wait;
	}
	
	
	@Override
	public boolean execute() {
		try {
			Thread t=new Thread(){
				@Override
				public void run() {
					try{
						File dir = new File(path);
						ProcessBuilder pb = new ProcessBuilder(path+cmd);
						pb.directory(dir);
	
						Process p = pb.start();
						BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
						String readline;
						int i = 0;
						while ((readline = reader.readLine()) != null) {
							System.out.println(++i + " " + readline);
						}
						result = Result.OK;
					} catch (Exception e) {
						result = Result.ERROR;
					}
				}
			};
			t.start();
			if(wait)
				t.wait();			
			return true;
		} catch (Exception e) {
			result = Result.ERROR;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "EXCEC "+cmd;
	}

}
