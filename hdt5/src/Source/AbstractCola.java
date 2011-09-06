/*
 * Declaracion de la Clase Abstracta.
 */
package Source;

/**
 * Clase abstracta de cola
 * @author Pingus
 * @param <E> 
 */
public abstract class AbstractCola<E> implements Cola<E> {
        
        @Override
        public boolean isEmpty(){
                return size() == 0;
        }

}
