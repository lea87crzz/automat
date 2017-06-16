package com.lea87crzz.AutoPublish.object.tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.lea87crzz.AutoPublish.object.Result;

public class ExcecuteCommandTask extends Task {

	private String cmd;
	private String path;
	
	public ExcecuteCommandTask() {		
	}
	
	public ExcecuteCommandTask(String path,String cmd) {
		this.path=path;
		this.cmd=cmd;
	}
	
	
	@Override
	public boolean execute() {
		try {
			File dir = new File(path);
			ProcessBuilder pb = new ProcessBuilder(path+cmd);
			pb.directory(dir);

			Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String readline;
			int i = 0;
			while ((readline = reader.readLine()) != null) {
				//if(readline.contains("BUILD"))
				System.out.println(++i + " " + readline);
			}

			result = Result.OK;
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
