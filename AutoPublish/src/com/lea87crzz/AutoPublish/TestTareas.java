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
		
		String srcDspace="C:\\Users\\lpujol\\git\\dspace6base\\";
		String tomcatWebapps="C:\\usr\\local\\tomcat\\webapps\\";
		
		Proceso compilarApi=new Proceso("Compilar dspace-api");
		compilarApi.agregarTarea(new MavenPackage(srcDspace+"dspace-api"));
		compilarApi.agregarTarea(new CopyFileTarea(srcDspace+"dspace-api\\target\\",
				"C:\\Users\\lpujol\\.m2\\repository\\org\\dspace\\dspace-api\\6.0\\",
				"dspace-api-6.0.jar"));
		
		
		Proceso compilarJSPUI=new Proceso("Compilar dspace-jspui");
		compilarJSPUI.agregarTarea(new MavenPackage(srcDspace+"dspace-jspui"));
		compilarJSPUI.agregarTarea(new CopyDirTarea(srcDspace+"dspace-jspui\\target\\dspace-jspui-6.0\\",
				tomcatWebapps+"admin\\"));
		
		Proceso compilarXMLUI=new Proceso("Compilar dspace-jspui");
		compilarXMLUI.agregarTarea(new MavenPackage(srcDspace+"dspace-xmlui"));
		compilarXMLUI.agregarTarea(new CopyDirTarea(srcDspace+"dspace-xmlui\\target\\dspace-xmlui-6.0\\",
				tomcatWebapps+"ROOT\\"));
		
		Proceso levantarTomcat=new Proceso("Levantar tomcat");
		levantarTomcat.agregarTarea(new CleanDirTarea("C:\\usr\\local\\dspace\\log\\"));
		levantarTomcat.agregarTarea(new CleanDirTarea("C:\\usr\\local\\tomcat\\logs\\"));
		levantarTomcat.agregarTarea(new ExcecuteCommand("C:\\usr\\local\\tomcat\\bin\\","startup.bat"));
		
		proc.agregarTarea(levantarTomcat);		
		proc.ejecutar();

	}

}
