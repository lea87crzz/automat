package com.lea87crzz.AutoPublish.object.tarea;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.lea87crzz.AutoPublish.object.Result;

public class CleanDirTask extends Task {
	
	private String path;
	
	public CleanDirTask(String name) {
		super(name);
	}
	
	public CleanDirTask(String name,String path) {
		super(name);
		this.path=path;
	}

	@Override
	public boolean execute() {
		try {			
			File dir=new File(path);
			FileUtils.cleanDirectory(dir);
			result = Result.OK;
			return true;
		} catch (Exception e) {
			result = Result.ERROR;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "CLEAN "+path;
	}

}
