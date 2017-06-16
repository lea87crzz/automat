package com.lea87crzz.AutoPublish;

import com.lea87crzz.AutoPublish.object.Process;
import com.lea87crzz.AutoPublish.object.tarea.CleanDirTask;
import com.lea87crzz.AutoPublish.object.tarea.CopyDirTask;
import com.lea87crzz.AutoPublish.object.tarea.CopyFileTask;
import com.lea87crzz.AutoPublish.object.tarea.ExcecuteCommandTask;
import com.lea87crzz.AutoPublish.object.tarea.MavenPackageTask;

public class TestTareas {

	public static void main(String[] args) {
		Process proc=new Process();
		
		String srcDspace="C:\\Users\\lpujol\\git\\dspace6base\\";
		String tomcatWebapps="C:\\usr\\local\\tomcat\\webapps\\";
		
		Process compilarApi=new Process("Compilar dspace-api");
		compilarApi.addTask(new MavenPackageTask(srcDspace+"dspace-api"));
		compilarApi.addTask(new CopyFileTask(srcDspace+"dspace-api\\target\\",
				"C:\\Users\\lpujol\\.m2\\repository\\org\\dspace\\dspace-api\\6.0\\",
				"dspace-api-6.0.jar"));
		
		
		Process compilarJSPUI=new Process("Compilar dspace-jspui");
		compilarJSPUI.addTask(new MavenPackageTask(srcDspace+"dspace-jspui"));
		compilarJSPUI.addTask(new CopyDirTask(srcDspace+"dspace-jspui\\target\\dspace-jspui-6.0\\",
				tomcatWebapps+"admin\\"));
		
		Process compilarXMLUI=new Process("Compilar dspace-jspui");
		compilarXMLUI.addTask(new MavenPackageTask(srcDspace+"dspace-xmlui"));
		compilarXMLUI.addTask(new CopyDirTask(srcDspace+"dspace-xmlui\\target\\dspace-xmlui-6.0\\",
				tomcatWebapps+"ROOT\\"));
		
		Process levantarTomcat=new Process("Levantar tomcat");
		levantarTomcat.addTask(new CleanDirTask("C:\\usr\\local\\dspace\\log\\"));
		levantarTomcat.addTask(new CleanDirTask("C:\\usr\\local\\tomcat\\logs\\"));
		levantarTomcat.addTask(new ExcecuteCommandTask("C:\\usr\\local\\tomcat\\bin\\","startup.bat"));
		
		proc.addTask(levantarTomcat);		
		proc.execute();

	}

}
