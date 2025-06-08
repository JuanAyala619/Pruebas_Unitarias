/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EstructurasDeDatos;

/**
 *
 * @author Julian
 * @param <T>
 */
public class ListaSimple<T> {
    private Nodo cabeza;
    
    public ListaSimple(){
        this.cabeza=null;
    }
    
    //Agregar al final
    public void agregar(T dato){
        Nodo nuevo=new Nodo(dato);
        if(cabeza==null){
            cabeza=nuevo;
        }else{
            Nodo actual=cabeza;
            while(actual.siguiente!=null){
                actual=actual.siguiente;
            }
            actual.siguiente=nuevo;
        }
    }
  //Elimina un nodo en base al valor dado  
    public boolean eliminar(T dato){//Elimina un Nodo por Valor
        if(cabeza==null)return false;
        if(cabeza.dato==dato){
            cabeza=cabeza.siguiente;
            return true;
        }
        Nodo actual= cabeza;
        while(actual.siguiente!=null && actual.siguiente.dato!=dato){
            actual=actual.siguiente;
        }
        if(actual.siguiente!=null){
            actual.siguiente=actual.siguiente.siguiente;
            return true;
        }
        return false;//No encontrado
    }
    
    public boolean editar(T datoAnterior, T datoEditado){
        Nodo<T> actual=cabeza;
        do{
            if(actual.dato.equals(datoAnterior)){
                actual.dato=datoEditado;
                return true;
            }
        }while(actual!=null);
        return false;
    }
   //Imprime los datos de la lista 
    public void mostrar(){
      Nodo actual=cabeza;
      while(actual!=null){
          System.out.println(actual.dato+" ->");
          actual=actual.siguiente;
      }
        System.out.println("null");
    }
  //Imprime la cantidad de nodos de la lista  
    public int tamanio(){
        int contador=0;
        Nodo actual=cabeza;
        while(actual!=null){
            contador++;
            actual=actual.siguiente;
        }
        return contador;
    }
    
}
