package com.lea87crzz.AutoPublish.object.tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.lea87crzz.AutoPublish.object.Resultado;

public class ExcecuteCommand extends Tarea {

	private String cmd;
	private String path;
	
	public ExcecuteCommand() {		
	}
	
	public ExcecuteCommand(String path,String cmd) {
		this.path=path;
		this.cmd=cmd;
	}
	
	
	@Override
	public boolean ejecutar() {
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

			result = Resultado.OK;
			return true;
		} catch (Exception e) {
			result = Resultado.ERROR;
		}
		return false;
	}

	@Override
	public String getDescripcion() {
		return "EJECUTA "+cmd;
	}

}
