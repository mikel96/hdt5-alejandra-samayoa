
package Source;

/**
 *
 * @author Pingus
 */
public class ColaCircular<E> extends AbstractCola<E> {
        /** Los elementos contenidos en la cola */
        private ListaCircular<E> elementos;    
        /**
         * Constructor de la clase. Crea la cola vacía
         */
        public ColaCircular(){
                elementos = new ListaCircular<E>();
        }

        public int size() {
                return elementos.size();
        }

        public void enqueue(E elemento) {
                elementos.add( elemento );
        }

        public E dequeue() {
                return elementos.remove();
        }

        public E peek() {
                return elementos.darPrimero();
        }

 
}
