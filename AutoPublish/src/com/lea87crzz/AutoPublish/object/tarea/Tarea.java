package com.lea87crzz.AutoPublish.object.tarea;

import com.lea87crzz.AutoPublish.object.ITarea;
import com.lea87crzz.AutoPublish.object.Resultado;

public abstract class Tarea implements ITarea {

	protected Resultado result=Resultado.NOT_EJECUTED;
	
	@Override
	public Resultado getResultado() {		
		return result;
	}

}
