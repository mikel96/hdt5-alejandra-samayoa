/*
 * Declaracion de la Clase Abstracta.
 */
package Source;

/**
 *
 * @author Alejandra Samayoa
 */
public abstract class AbstractCola<E> implements Cola<E> {
        
        @Override
        public boolean isEmpty(){
                return size() == 0;
        }

}
