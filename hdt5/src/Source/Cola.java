/*
 * Interfaz de la Cola a ser implementada.
 */
package Source;

/**
 *
 * @author alejadnra Samayoa
 */
interface Cola<E> {
    /**
	 * Metodo que indica si la cola no tiene elementos.
	 * @return true Si la cola se encuentra vacia.  
	 */
	public boolean isEmpty();
	
	/**
	 * Metodo que indica la cantidad de elementos en la cola.
	 * @return La cantidad de elementos en la cola.
	 */
	public int size();
	
	/**
	 * Metodo que introduce al final de la cola un elemento.
	 * @param elemento El objeto que se desea insertar a la cola.
         */
	public void enqueue( E elemento );
	
	/**
	 * Metodo que retorna y remueve el primer elemento de la cola.
	 * @return El elemento que esta al principio de la cola. null Si la cola esta vacia.
	 */
	public E dequeue();
	
	/**
	 * Metodo que retorna pero no remueve el primer elemento de la cola.
	 * @return El elemento que esta al principio de la cola. null Si la cola esta vacia
	 */
	public E peek();

}
    
    

