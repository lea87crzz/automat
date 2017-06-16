package com.lea87crzz.AutoPublish.object;

import java.util.ArrayList;

public class Proceso implements ITarea {
	ArrayList<ITarea> tareas;
	private String nombre="";
	protected Resultado result=Resultado.NOT_EJECUTED;
	
	public Proceso(){
		tareas=new ArrayList<ITarea>();
	}
	
	public Proceso(String nombre){
		this.nombre=nombre;
		tareas=new ArrayList<ITarea>();
	}
	
	public ArrayList<ITarea> getTareas(){
		return this.tareas;
	}
	
	public void agregarTarea(ITarea tarea){
		tareas.add(tarea);
	}

	public boolean ejecutar() {
		for(ITarea t:tareas){
			System.out.println(t.getDescripcion());
			t.ejecutar();
			result=t.getResultado();
			if(t.getResultado().equals(Resultado.ERROR)){
				System.out.println("ERROR AL EJECUTAR TAREA");
				return false;
			} else{
				System.out.println("FINALIZADO CORRECTAMENTE");
			}
		}
		return true;
		
	}


	@Override
	public Resultado getResultado() {
		return result;
	}

	@Override
	public String getDescripcion() {
		return "PROCESO "+nombre;
	}

}
