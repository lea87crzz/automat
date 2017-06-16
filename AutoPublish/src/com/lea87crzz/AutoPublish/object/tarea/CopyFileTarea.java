package com.lea87crzz.AutoPublish.object.tarea;

import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import com.lea87crzz.AutoPublish.object.Resultado;

public class CopyFileTarea extends Tarea {
	
	private String fromPath;
	private String toPath;
	private String fileName;
	
	public CopyFileTarea() {
	}
	
	public CopyFileTarea(String from,String to,String file) {
		fromPath=from;
		toPath=to;
		fileName=file;
	}
	
	@Override
	public boolean ejecutar() {		
		try{
			Path source=new File(fromPath+fileName).toPath();
			Path dest=new File(toPath).toPath();
			Files.copy(source, dest.resolve(source.getFileName()),StandardCopyOption.REPLACE_EXISTING);
			result=Resultado.OK;
			return true;
		} catch(Exception e){
			result=Resultado.ERROR;
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
	public String getDescripcion() {
		return "CP "+fromPath+fileName+" TO "+toPath;
	}



}
