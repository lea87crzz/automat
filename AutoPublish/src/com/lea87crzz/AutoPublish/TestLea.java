package com.lea87crzz.AutoPublish;

import com.lea87crzz.AutoPublish.object.Process;
import com.lea87crzz.AutoPublish.object.tarea.CleanDirTask;
import com.lea87crzz.AutoPublish.object.tarea.CopyDirTask;
import com.lea87crzz.AutoPublish.object.tarea.CopyFileTask;
import com.lea87crzz.AutoPublish.object.tarea.ExcecuteCommandTask;
import com.lea87crzz.AutoPublish.object.tarea.MavenPackageTask;

public class TestLea {
	
	public static Process getProcessDspace6(){
		Process proc=new Process("Dspace6");
		
		String srcDspace="C:\\Users\\lpujol\\git\\dspace6base\\";
		String tomcatWebapps="C:\\usr\\local\\tomcat\\webapps\\";
		
		Process compilarApi=new Process("Compilar dspace-api");
		compilarApi.addTask(new MavenPackageTask("Mvn dspace-api",srcDspace+"dspace-api"));
		compilarApi.addTask(new CopyFileTask("Cp dspace-api",srcDspace+"dspace-api\\target\\",
				"C:\\Users\\lpujol\\.m2\\repository\\org\\dspace\\dspace-api\\6.0\\",
				"dspace-api-6.0.jar"));
		
		
		Process compilarJSPUI=new Process("Compilar dspace-jspui");
		compilarJSPUI.addTask(new MavenPackageTask("Mvn dspace-jspui",srcDspace+"dspace-jspui"));
		compilarJSPUI.addTask(new CopyDirTask("Cp dspace-jspui",srcDspace+"dspace-jspui\\target\\dspace-jspui-6.0\\",
				tomcatWebapps+"admin\\"));
		
		Process compilarAutoridades=new Process("Compilar autoridades");
		compilarAutoridades.addTask(new MavenPackageTask("Mvn autoridades",srcDspace+"dspace-autoridades"));
		compilarAutoridades.addTask(new CopyDirTask("Cp dspace-autoridades",srcDspace+"dspace-autoridades\\target\\autoridades\\",
				tomcatWebapps+"autoridades\\"));
		
		Process compilarXMLUI=new Process("Compilar dspace-xmlui");
		compilarXMLUI.addTask(new MavenPackageTask("Mvn dspace-xmlui",srcDspace+"dspace-xmlui"));
		compilarXMLUI.addTask(new CopyDirTask("Cp dspace-xmlui",srcDspace+"dspace-xmlui\\target\\dspace-xmlui-6.0\\",
				tomcatWebapps+"ROOT\\"));
		
		Process levantarTomcat=new Process("Levantar tomcat");
		levantarTomcat.addTask(new CleanDirTask("Clean log dspace","C:\\usr\\local\\dspace\\log\\"));
		levantarTomcat.addTask(new CleanDirTask("clean log tomcat","C:\\usr\\local\\tomcat\\logs\\"));
		levantarTomcat.addTask(new ExcecuteCommandTask("startup tomcat","C:\\usr\\local\\tomcat\\bin\\","startup.bat",false));
		
		
		proc.addTask(compilarApi);
		proc.addTask(compilarJSPUI);
		proc.addTask(compilarAutoridades);		
		proc.addTask(compilarXMLUI);
		proc.addTask(levantarTomcat);
		
		return proc;
	}

}
