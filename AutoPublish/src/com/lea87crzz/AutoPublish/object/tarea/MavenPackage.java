package com.lea87crzz.AutoPublish.object.tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;


import com.lea87crzz.AutoPublish.object.Resultado;

public class MavenPackage extends Tarea {
	
	public static String MAVEN_PATH="C:\\maven\\bin\\mvn.cmd";
	
	private String path;
	
	public MavenPackage() {		
	}
	
	public MavenPackage(String path) {
		this.path=path;
	}

	@Override
	public boolean ejecutar() {
		try{
			File dir=new File(path);
			String[] vars={"JAVA_HOME=C:\\Program Files\\Java\\jdk1.7.0_80\\","Path=C:\\Windows\\system32;C:\\Windows;C:\\Windows\\System32\\Wbem;C:\\maven\\bin;C:\\ant\\bin;C:\\adb;%JAVA_HOME%;C:\\ProgramData\\Oracle\\Java\\javapath;C:\\Program Files\\Git\\cmd"};			
			Process p = Runtime.getRuntime().exec(MAVEN_PATH+" package", vars, dir);
			p.waitFor();
			String line;

			BufferedReader error = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while((line = error.readLine()) != null){
			    //System.out.println(line);
			}
			error.close();

			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while((line=input.readLine()) != null){
				//if(line.contains("BUILD"))
					System.out.println(line);
			}

			input.close();

			OutputStream outputStream = p.getOutputStream();
			PrintStream printStream = new PrintStream(outputStream);
			printStream.println();
			printStream.flush();
			printStream.close();
			
			result=Resultado.OK;
			return true;
		} catch(Exception e){
			result=Resultado.ERROR;
		}
		return false;
	}

	@Override
	public String getDescripcion() {
		return "MVN PACKAGE en "+path;
	}

}
