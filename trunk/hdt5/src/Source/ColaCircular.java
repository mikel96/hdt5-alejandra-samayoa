/*
 * Implementacion de la cola Circular
 */
package Source;

/**
 * Cola Circular
 * @author Pingus
 * @param <E> Objeto con el que se trabajara
 */
public class ColaCircular<E> extends AbstractCola<E> {
 // post: constructs a new, empty queue\
/**Lista donde se almacenan los datos    */    
ListaCircular<E> data;
    /**Constructor de la Cola    */
    public ColaCircular(){
        data = new ListaCircular<E>();
    }
    /**
     * Devuelve el tamano de la cola
     * @return queue size
     */
       public int size()
    // post: returns the number of elements in the queue
    {
    return data.size();
    }
    /**
     * Borra los elementos de la cola
     */
    public void clear()
    // post: removes all elements from the queue
    {
    data.clear();
    }
    
    /**
     * Verifica si la cola esta vacia
     * @return  true si la cola no tiene elementos
     */
    public boolean isEmpty()
    // post: returns true iff the queue is empty
    {
    return data.isEmpty();
    }

    /**
     * Ingresa un elemento a la cola
     * @param elemento a ser ingresado
     */
    public void enqueue(E elemento) {
       data.addFirst(elemento);
    }

    /**
     * Extrae un elemento de la cola
     * @return elemento sacado.
     */
    public E dequeue() {
     return data.removeLast(); 
    }

    /**
     * ver cual es el siguiente elemento
     * @return elemento que sera sacado proximo
     */
    public E peek() {
     return data.getFirst();
     
    }
}
