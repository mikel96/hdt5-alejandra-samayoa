/*
 * Implementacion de la Lista Circular
 */
package Source;

/**
 *
 * @author Pingus
 */

public class ListaCircular<E> {
        /** Primer nodo de la lista */
        private Node<E> tail;
        int count;

        /**
         * Inicia la lista vacía
         */
public ListaCircular()
// pre: constructs a new circular list
    {
        tail = null;
        count = 0;
   }    
        /**
         * Método que retorna el primer elemento de la lista
         */
        public void addFirst(E value)
        // pre: value non-null
        // post: adds element to head of list
        {Node<E> temp = new Node<E>(value);
        if (tail == null) { // first value added
        tail = temp;
        tail.setNext(tail);
        } else { // element exists in list
        temp.setNext(tail.next());
        tail.setNext(temp);
        }
        count++;
        }
        
        public void addLast(E value)
        // pre: value non-null
        // post: adds element to tail of list
        {
        // new entry:
        addFirst(value);
        tail = tail.next();
        }
        
        public int size()
        // post: returns number of elements in list
        {
        return count;
        }

        public E getFirst()
        // pre: list is not empty
        // post: returns first value in list
        {
        return tail.value();
        }
        
        public void clear()
        // post: removes all elements from list
        {
        tail = null;
        count = 0;
        }
        
        public boolean isEmpty(){
            return count==0;
        }
                
        
        public E removeLast()
        // pre: !isEmpty()
        // post: returns and removes value from tail of list
        {
        //Assert.pre(!isEmpty(),"list is not empty.");
        Node<E> finger = tail;
        while (finger.next() != tail) {
        finger = finger.next();
        }
        // finger now points to second-to-last value
        Node<E> temp = tail;
        if (finger == tail)
        {
        tail = null;
        } else {
        finger.setNext(tail.next());
        tail = finger;
        }
        count--;
         return temp.value();
    }
}
