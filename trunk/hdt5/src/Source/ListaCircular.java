/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

/**
 *
 * @author Pingus
 */
public class ListaCircular<E> {

        /** Primer nodo de la lista */
        private Nodo<E> primero;
        
      /**Definicion de Clase Auxiliar NODO para poder implentar la Lista 
         * 
         * @param <E> Tipo de Elemento/Objeto
         */  
        private class Nodo<E> {
        
            /** El objeto contenido en el nodo */
            private E objeto;
            /** El objeto siguiente */
            private Nodo<E> siguiente;
            
            /**CONSTRUCTOR
             * 
             * @param obj el cual consiste el nodo
             */
            public Nodo( E obj ){
                objeto = obj;
                siguiente = null;
        }
            
            public E darObjeto() {
                    return objeto;
            }

            public boolean hasNext() {
                    return siguiente == null;
            }

            public Nodo<E> next() {
                    return siguiente;
            }

            public void setNext( E next ){
                    siguiente = new Nodo<E>(next);
            }

            public void setNext( Nodo<E> next ){
                    siguiente = next;
            }
        }
 


            /**
             * Inicia la lista vacía
             */
            public ListaCircular(){
                    primero = null;
            }

            /**
             * Método que agrega un elemento a la lista
             */
            public void add( E nuevo ){
                     if ( isEmpty() ) {
                     primero = new Nodo<E>( nuevo );
                     primero.setNext( primero );
                  }
                  else {
                      Nodo<E> ultimo;
                      Nodo<E> actual = primero;
                     while(actual.next() != primero) {
                            actual = actual.next();
                     }
                     ultimo = actual;

                     Nodo<E> desplazado = primero;
                     primero = new Nodo<E>( nuevo );
                     primero.setNext( desplazado );
                     ultimo.setNext( primero );
                  }
            }
        
        /**
         * Método que remueve el primer nodo de la lista y lo retorna.
         * @return El primer elemento de la lista. null Si la lista está vacía
         */
        public E remove(){
                E elementoARemover = null;

              // lanza una excepción si la Lista esta vacía
              if ( isEmpty() )
                  return null;
              // recupera el dato a ser removido
              elementoARemover = primero.darObjeto();  

              // reinicializa las referencias al primerNodo and ultimoNodo
              if ( primero == primero.next())
                 primero = null;

              else
              {
                  Nodo<E> ultimo;
                  Nodo<E> actual = primero;
                 while(actual.next() != primero ) {
                        actual = actual.next();
                 }
                 ultimo = actual;
                                
                 primero = primero.next();
                 ultimo.setNext( primero );
              }
                return elementoARemover;  
        }
        
        /**
         * Método que indica si la lista está vacía.
         * @return true Si no hay elementos en la lista. false Si no los hay.
         */
        public boolean isEmpty(){
                return primero == null;
        }
        
        /**
         * Método que informa sobre el tamaño de la lista
         */
        public int size(){
                if( isEmpty() )
                        return 0;
                else{
                        int tamanio = 0;
                        for( Nodo<E> actual = primero; actual.hasNext(); actual.next() )
                                tamanio++;
                        return tamanio;
                }
        }
        
        /**
         * Método que retorna el primer elemento de la lista
         */
        public E darPrimero(){
                if( primero != null )
                        return primero.darObjeto();
                else
                        return null;
        }
}
