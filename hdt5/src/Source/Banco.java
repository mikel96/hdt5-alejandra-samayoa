package Source;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Pingus
 */



/**
 * Clase que representa al banco con 4 colas y un máximo de 10 clientes por cola.
 * @author Pingus
 */
public class Banco{

        /** La cantidad de colas que hay en el banco. */
        public final static int CANTIDAD_COLAS = 4;
        /** La cantidad máxima de clientes que debe haber en cada cola */
        public final static int MAXIMO_CLIENTES_POR_COLA = 10;
        /** Cantidad de clientes que se generarán para el ejercicio */
        public final static int CLIENTES_A_GENERAR = 50;

        /** Las colas de atención en el banco. */
        private Cola<Client>[] colas;
        /** La lista generada de clientes. */
        private Lista<Client> listaClientes;

        /**
         * Constructor de la clase.
         * post: Se creó una instancia del banco con 4 colas de atención a clientes y se generó la lista aleatoria de clientes.
         */
        public Banco()
        {
                colas = new Cola[CANTIDAD_COLAS];
                
               
                for( int i = 0; i < CANTIDAD_COLAS; i++ )
                        colas[i] = new ColaArreglos<Client>();
                        //colas[i] = new Cola_ListaCircular<Client>();
                generarListaClientes();
        }

        /**
         * Genera una lista aleatoria de clientes del banco y la ordena por su tiempo de entrada.
         * post: Se genera una lista ordenada de clientes que irán al banco con una hora de entrada y tiempo de permanencia aleatorios. 
         */
        private void generarListaClientes()
        {
                // Inicializa la lista
                listaClientes = new Lista<Client>();
                
                // Crea los clientes aleatoriamente
                Random random = new Random();
                for( int i = 0; i < CLIENTES_A_GENERAR; i++ ){
                        int t1 = random.nextInt( 480 ) + 1;
                        int t2 = random.nextInt( 30 ) + 1;
                        listaClientes.add( new Client( t1, t2 ) );
                }
                
                // Ordena los clientes por su hora de entrada
                listaClientes.sort();
        }
        
        /**
         * Método que devuelve el índice de la cola más corta posible.
         * @return El índice de la cola vacía más próxima o de la cola con menor cantidad de clientes en espera.
         */
        private int darColaMasCorta()
        {        // Retorna la cola más próxima que esté vacía (si es que hay colas vacías)
                for( int i = 0; i < CANTIDAD_COLAS; i++ )
                        if( colas[i].isEmpty() ) return i;
                // Retorna la cola con menor cantidad de clientes en espera si no hay colas vacías
                int menor = colas[0].size();
                for( int i = 1; i < CANTIDAD_COLAS; i++ )
                        if( menor > colas[i].size() ) menor = colas[i].size();
                return menor;
        }
                
}