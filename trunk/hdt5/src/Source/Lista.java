/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.util.ArrayList;

/**
 * Clase que implementa una lista que se ordena en base al método compareTo()
 * @author Pingus
 * @param <E> Genérico a implementar
 */
public class Lista<E extends Comparable<E>> extends ArrayList<E>{
        /**
         * Método que ordena los elementos de la lista utilizando el algoritmo
         * usando BubbleSort
         */
        public void sort(){
                int out, in;

                for( out = size()-1; out > 1; out-- ) 
                for( in = 0; in < out; in++ ) 
                if( get(in).compareTo(get( in+1 )) == -1 ) 
                        swap(in, in+1); 
        }

        /**
         * Método que realiza el intercambio
         * @param i1 El índice del primer elemento
         * @param i2 El índice del segundo elemento
         */
        private void swap(int i1, int i2) {
                E primero = get(i1);
                E segundo = get(i2);
                set( i1, segundo );
                set( i2, primero );
        }
        
}
