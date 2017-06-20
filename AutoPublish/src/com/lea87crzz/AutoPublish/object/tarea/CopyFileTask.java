package com.lea87crzz.AutoPublish.object.tarea;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.lea87crzz.AutoPublish.object.Result;
import com.lea87crzz.AutoPublish.view.LocaleUtils;

public class CopyFileTask extends Task {
	
	private String fromPath;
	private String toPath;
	private String fileName;
	
	public CopyFileTask(String name) {
		super(name);
	}
	
	public CopyFileTask(String name,String from,String to,String file) {
		super(name);
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
		return "CP "+fromPath+fileName+" "+LocaleUtils.getString("task.cp.to")+" "+toPath;
	}



}
