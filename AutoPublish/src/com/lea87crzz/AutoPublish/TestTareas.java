package com.lea87crzz.AutoPublish;

import com.lea87crzz.AutoPublish.object.Proceso;
import com.lea87crzz.AutoPublish.object.tarea.CleanDirTarea;
import com.lea87crzz.AutoPublish.object.tarea.CopyDirTarea;
import com.lea87crzz.AutoPublish.object.tarea.CopyFileTarea;
import com.lea87crzz.AutoPublish.object.tarea.ExcecuteCommand;
import com.lea87crzz.AutoPublish.object.tarea.MavenPackage;

public class TestTareas {

	public static void main(String[] args) {
		Proceso proc=new Proceso();
		
		Proceso compilarApi=new Proceso("Compilar dspace-api");
		compilarApi.agregarTarea(new MavenPackage("C:\\Users\\lpujol\\git\\dspace6base\\dspace-api"));
		compilarApi.agregarTarea(new CopyFileTarea("C:\\Users\\lpujol\\git\\dspace6base\\dspace-api\\target\\",
				"C:\\Users\\lpujol\\.m2\\repository\\org\\dspace\\dspace-api\\6.0\\",
				"dspace-api-6.0.jar"));
		
		
		Proceso compilarJSPUI=new Proceso("Compilar dspace-jspui");
		compilarJSPUI.agregarTarea(new MavenPackage("C:\\Users\\lpujol\\git\\dspace6base\\dspace-jspui"));
		compilarJSPUI.agregarTarea(new CopyDirTarea("C:\\Users\\lpujol\\git\\dspace6base\\dspace-jspui\\target\\dspace-jspui-6.0\\",
				"C:\\usr\\local\\tomcat\\webapps\\admin\\"));
		
		
		Proceso levantarTomcat=new Proceso("Levantar tomcat");
		levantarTomcat.agregarTarea(new CleanDirTarea("C:\\usr\\local\\dspace\\log\\"));
		levantarTomcat.agregarTarea(new CleanDirTarea("C:\\usr\\local\\tomcat\\logs\\"));
		levantarTomcat.agregarTarea(new ExcecuteCommand("C:\\usr\\local\\tomcat\\bin\\","startup.bat"));
		
		proc.agregarTarea(levantarTomcat);
		
		proc.ejecutar();

	}

}
