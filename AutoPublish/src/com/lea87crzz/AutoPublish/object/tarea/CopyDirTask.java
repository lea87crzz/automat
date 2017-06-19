package com.lea87crzz.AutoPublish.object.tarea;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.lea87crzz.AutoPublish.object.Result;

public class CopyDirTask extends Task {

	private String fromPath;
	private String toPath;

	public CopyDirTask(String name) {
		super(name);
	}

	public CopyDirTask(String name,String from, String to) {
		super(name);
		fromPath = from;
		toPath = to;
	}

	@Override
	public boolean execute() {
		try {
			File srcDir = new File(fromPath);
			File destDir = new File(toPath);
			FileUtils.copyDirectory(srcDir, destDir);
			result = Result.OK;
			return true;
		} catch (Exception e) {
			result = Result.ERROR;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "CP " + fromPath + " TO " + toPath;
	}

}
