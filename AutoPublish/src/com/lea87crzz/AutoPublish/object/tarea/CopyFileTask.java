package com.lea87crzz.AutoPublish.object.tarea;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.lea87crzz.AutoPublish.object.Result;

public class CopyFileTask extends Task {
	
	private String fromPath;
	private String toPath;
	private String fileName;
	
	public CopyFileTask() {
	}
	
	public CopyFileTask(String from,String to,String file) {
		fromPath=from;
		toPath=to;
		fileName=file;
	}
	
	@Override
	public boolean execute() {		
		try{
			Path source=new File(fromPath+fileName).toPath();
			Path dest=new File(toPath).toPath();
			Files.copy(source, dest.resolve(source.getFileName()),StandardCopyOption.REPLACE_EXISTING);
			result=Result.OK;
			return true;
		} catch(Exception e){
			result=Result.ERROR;
		}
		return false;
	}

	public String getFromPath() {
		return fromPath;
	}

	public void setFromPath(String fromPath) {
		this.fromPath = fromPath;
	}

	public String getToPath() {
		return toPath;
	}

	public void setToPath(String toPath) {
		this.toPath = toPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public String getDescription() {
		return "CP "+fromPath+fileName+" TO "+toPath;
	}



}