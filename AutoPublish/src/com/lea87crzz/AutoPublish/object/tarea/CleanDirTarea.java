package com.lea87crzz.AutoPublish.object.tarea;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.lea87crzz.AutoPublish.object.Resultado;

public class CleanDirTarea extends Tarea {
	
	private String path;
	
	public CleanDirTarea() {
	}
	
	public CleanDirTarea(String path) {
		this.path=path;
	}

	@Override
	public boolean ejecutar() {
		try {			
			File dir=new File(path);
			FileUtils.cleanDirectory(dir);
			result = Resultado.OK;
			return true;
		} catch (Exception e) {
			result = Resultado.ERROR;
		}
		return false;
	}

	@Override
	public String getDescripcion() {
		return "CLEAN "+path;
	}

}
