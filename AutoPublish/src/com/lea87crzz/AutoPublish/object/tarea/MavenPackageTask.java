package com.lea87crzz.AutoPublish.object.tarea;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.lea87crzz.AutoPublish.object.Result;

public class MavenPackageTask extends Task {

	public static String MAVEN_PATH = "C:\\maven\\bin\\mvn.cmd";

	private String path;

	public MavenPackageTask(String name) {
		super(name);
	}

	public MavenPackageTask(String name,String path) {
		super(name);
		this.path = path;
	}

	@Override
	public boolean execute() {
		try {
			File dir = new File(path);

			ProcessBuilder pb = new ProcessBuilder(MAVEN_PATH, "package");
			pb.directory(dir);

			Process p = pb.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String readline;
			while ((readline = reader.readLine()) != null) {
				//if(readline.contains("BUILD"))
				System.out.println(readline);
			}

			result = Result.OK;
			return true;
		} catch (Exception e) {
			result = Result.ERROR;
		}
		return false;
	}

	@Override
	public String getDescription() {
		return "MVN PACKAGE on " + path;
	}

}
