package com.lea87crzz.AutoPublish.object;

import com.lea87crzz.AutoPublish.object.tarea.CleanDirTarea;
import com.lea87crzz.AutoPublish.object.tarea.CopyDirTarea;
import com.lea87crzz.AutoPublish.object.tarea.CopyFileTarea;
import com.lea87crzz.AutoPublish.object.tarea.ExcecuteCommand;
import com.lea87crzz.AutoPublish.object.tarea.MavenPackage;

public class TestTareas {

	public static void main(String[] args) {
		Proceso proc=new Proceso();
		
		/*proc.agregarTarea(new MavenPackage("C:\\Users\\lpujol\\git\\dspace6base\\dspace-api"));
		proc.agregarTarea(new CopyFileTarea("C:\\Users\\lpujol\\git\\dspace6base\\dspace-api\\target\\",
				"C:\\Users\\lpujol\\.m2\\repository\\org\\dspace\\dspace-api\\6.0\\",
				"dspace-api-6.0.jar"));
		
		
		proc.agregarTarea(new MavenPackage("C:\\Users\\lpujol\\git\\dspace6base\\dspace-jspui"));
		proc.agregarTarea(new CopyDirTarea("C:\\Users\\lpujol\\git\\dspace6base\\dspace-jspui\\target\\dspace-jspui-6.0\\",
				"C:\\usr\\local\\tomcat\\webapps\\admin\\"));
		*/
		
		proc.agregarTarea(new CleanDirTarea("C:\\usr\\local\\dspace\\log\\"));
		proc.agregarTarea(new CleanDirTarea("C:\\usr\\local\\tomcat\\logs\\"));
		proc.agregarTarea(new ExcecuteCommand("C:\\usr\\local\\tomcat\\bin\\","startup.bat"));
		
		proc.ejecutar();

	}

}
