package com.lea87crzz.AutoPublish.object.tarea;

import com.lea87crzz.AutoPublish.object.Resultado;
import com.lea87crzz.AutoPublish.object.ITarea;

public class CopyFileTarea implements ITarea {
	
	private String fromPath;
	private String toPath;
	private String fileName;
	
	private Resultado res=Resultado.NOT_EJECUTED;
	
	public CopyFileTarea() {
	}
	
	public CopyFileTarea(String from,String to,String file) {
		fromPath=from;
		toPath=to;
		fileName=file;
	}
	
	@Override
	public boolean ejecutar() {		
		return false;
	}

	@Override
	public Resultado getResultado() {
		return res;
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



}
