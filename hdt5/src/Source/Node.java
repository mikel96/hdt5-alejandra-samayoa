/*
 * Nodo para la Lista Circular
 */
package Source;


/**
 * Clase del Nodo
 * @author Pingus
 * @param <E>  elemento 
 */
public class Node<E>{
    /**      
     * Elemento de Dato, valor. 
     */
protected E data; // value stored in this element
/**
 * Nodo anidado del sigiente
 */
protected Node<E> nextElement; // ref to next

/**
 * Constructor del nodo
 * @param v elemento
 * @param next elemento siguiente
 */
    public Node(E v, Node<E> next)
    // pre: v is a value, next is a reference to remainder of list
    // post: an element is constructed as the new head of list
    {
    data = v;
    nextElement = next;
    }
    /**
     * Constructor del nodo, asigna una cola con valor v
     * @param v  valor
     */
    public Node(E v)
    // post: constructs a new tail of a list with value v
    {
    this(v,null);
    }
    /**
     * retorna siguente elemento
     * @return siguiente elemento
     */
    public Node<E> next()
    // post: returns reference to next value in list
    {
    return nextElement;
    }
    /**
     * Asigna al elemento siguiente
     * @param next 
     */
    public void setNext(Node<E> next)
    // post: sets reference to new next value
    {
    nextElement = next;
    }
    /**
     * returna valor del dta
     * @return data
     */
    public E value()
    // post: returns value associated with this element
    {
    return data;
    }
    /**
     * asigna un valor.
     * @param value valor a ser asignado 
     */
    public void setValue(E value)
    // post: sets value associated with this element
    {
    data = value;
    }
 }

