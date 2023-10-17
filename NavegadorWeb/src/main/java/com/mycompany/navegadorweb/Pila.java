
package com.mycompany.navegadorweb;

public class Pila {
    NodoPila cima;

    public Pila() {
        cima = null;
    }

    public void empujar(String dato) {
        NodoPila nuevoNodo = new NodoPila(dato);
        nuevoNodo.siguiente = cima;
        cima = nuevoNodo;
    }

    public String sacar() {
        if (cima == null) {
            return null; // Pila vacía
        }
        String dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}
/*
	//Método para saber si la pila está llena
	public boolean estaLlena() {
		return vectorPila.length-1==cima;//Verdadero si la medida del vector que dio el usuario coincide con la cima
	}
	//Método para saber qué objeto está en la cima
	public int cimaPila() {
		return vectorPila[cima];
	}
	//Método para saber tamaño de la pila
	public int tamanoPila() {
		return vectorPila.length;
	}
*/


