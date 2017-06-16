package com.lea87crzz.AutoPublish.object;

import java.util.ArrayList;

public class Proceso {
	ArrayList<ITarea> tareas;
	
	public Proceso(){
		tareas=new ArrayList<ITarea>();
	}
	
	public ArrayList<ITarea> getTareas(){
		return this.tareas;
	}
	
	public void agregarTarea(ITarea tarea){
		tareas.add(tarea);
	}

}
