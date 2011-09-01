
package Source;

/**
 *
 * @author Pingus
 */
public class ColaArreglos<E> extends AbstractCola<E> {    
        /** Los elementos contenidos en la cola */
        private Object[] elementos;
        
        /**
         * Crea una cola vacía
         */
        public ColaArreglos(){
                elementos = new Object[0];
        }

        @Override
        public E dequeue() {
                if( isEmpty() ) return null;
                else{
                        E retorno = (E) elementos[0];
                        Object[] nuevo = new Object[ size()-1 ];
                        for( int i = 1; i < size(); i++ )
                                nuevo[i-1] = elementos[i];
                        elementos =  nuevo;
                        return retorno;
                }
        }

        @Override
        public void enqueue(E elemento) {
                Object[] nuevos = new Object[ size() + 1 ];
                for( int i = 0; i < size(); i++ )
                        nuevos[i] = elementos[i];
                nuevos[ nuevos.length - 1 ] = elemento;
                elementos = nuevos;
        }

        @Override
        public E peek() {
                if( isEmpty() ) return null;
                else
                        return (E) elementos[0];
        }

        @Override
        public int size() {
                return elementos.length;
        }
    
}
