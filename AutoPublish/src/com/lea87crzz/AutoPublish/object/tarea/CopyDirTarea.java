package com.lea87crzz.AutoPublish.object.tarea;

import java.io.File;

import org.apache.commons.io.FileUtils;

import com.lea87crzz.AutoPublish.object.Resultado;

public class CopyDirTarea extends Tarea {

	private String fromPath;
	private String toPath;

	public CopyDirTarea() {
	}

	public CopyDirTarea(String from, String to) {
		fromPath = from;
		toPath = to;
	}

	@Override
	public boolean ejecutar() {
		try {
			File srcDir = new File(fromPath);
			File destDir = new File(toPath);
			FileUtils.copyDirectory(srcDir, destDir);
			result = Resultado.OK;
			return true;
		} catch (Exception e) {
			result = Resultado.ERROR;
		}
		return false;
	}

	@Override
	public String getDescripcion() {
		return "CP " + fromPath + " TO " + toPath;
	}

}
