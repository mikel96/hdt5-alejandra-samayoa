package Source;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
        public final static int NUM_COLAS = 4;
        /** La cantidad máxima de clientes que debe haber en cada cola */
        public final static int MAXIMO_CLIENTES_POR_COLA = 10;
        /** Cantidad de clientes que se generarán para el ejercicio */
        public final static int NUM_CLIENTES = 50;

        /** Las colas de atención en el banco. */
        private Cola<Client>[] colas;
        /** La lista generada de clientes. */
        private Lista<Client> listaClientes;
        private int PermanenciaTotal;

        /**
         * Constructor de la clase.
         * post: Se creó una instancia del banco con 4 colas de atención a clientes y se generó la lista aleatoria de clientes.
         */
        public Banco()
        {colas = new Cola[NUM_COLAS];
                
                Scanner scan = new Scanner( System.in );
                System.out.print( "Presione '1' Modalidad Arreglos\n" +
                                "Presiones '2'  Modalidad Circular\n\n" );
                String seleccion = scan.nextLine();
                //int seleccion = scan.nextInt();
                for( int i = 0; i < NUM_COLAS; i++ ){
                        if( seleccion.trim().equals("1"))  colas[i] = new ColaArreglos<Client>();
                        else if( seleccion.trim().equals("2") )colas[i] = new ColaCircular<Client>();
                        else { System.out.println( "Número inválido." ); new Banco(); }
                }
                
                generarListaClientes();
                simulate();
        }

        /**
         * Genera una lista aleatoria de clientes del banco y la ordena por su tiempo de entrada.
         * post: Se genera una lista ordenada de clientes que irán al banco con una hora de entrada y tiempo de permanencia aleatorios. 
         */
        private void generarListaClientes()
        {
                listaClientes = new Lista<Client>();// Inicializa la lista                
                Random random = new Random();// Crea los clientes random
                for( int i = 0; i < NUM_CLIENTES; i++ ){
                        int t1 = random.nextInt( 480 ) + 1;
                        int t2 = random.nextInt( 30 ) + 1;
                        listaClientes.add( new Client( i+1, t1, t2 ) );
                }               
                listaClientes.sort(); // Ordena los clientes por su hora de entrada
                
                System.out.println( "\n  -------- Listado de clientes ----------\n" );
                for( int i = 0; i < listaClientes.size(); i++ )
                {
                        Client cliente = listaClientes.get(i);
                        System.out.println( "Cliente " + (i+1) + ":" + cliente.toString() );
                }
        }
        /**
         * Método que saca de la cola a los clientes que terminaron a determinada hora.
         * @param hora La hora determinada.
         */
        private void sacarClient( int hora )
        {
                for( int i = 0; i < colas.length; i++ ){
                        Cola<Client> cola = colas[i];
                        if( ! cola.isEmpty() ){
                                if( cola.peek().getHoraSalida() == hora ){
                                        Client saliendo = cola.dequeue();
                                        PermanenciaTotal += saliendo.getHoraSalida() - saliendo.getHoraEntrada();
                                        System.out.println( hora + ":\n\tSe termino de atender al cliente " + saliendo.getID() + " en la cola " + (i+1) + ".\n\tSu Estadia fue de " + (saliendo.getHoraSalida() - saliendo.getHoraEntrada()) );
                                } else{}
                        } else{}
                }
                for( int i = 0; i < colas.length; i++ ){
                        Cola<Client> cola = colas[i];
                        if( ! cola.isEmpty() ){
                                if( cola.peek().getHoraAtendido() == 0 ){
                                        cola.peek().setHoraAtendido( hora );
                                        System.out.println( hora + ":\n\tSe está atendiendo al cliente " + cola.peek().getID() + " en la cola " + (i+1) );
                                } else{}    
                        } else{}
                }
        }
 /**
         * Método que atiende a los clientes que entran a determinada hora, metiéndolos en la cola más corta.
         * También marca la hora de atención a los clientes que están empezando a ser atendidos.
         * @param hora La hora a la que se quiere atender a los clientes.
         */
        private void atenderClient( int hora )
        {
                for( int i = 0; i <NUM_CLIENTES; i++ ){
                        if( listaClientes.get(i).getHoraEntrada() == hora ){
                                int colaMasCorta = darColaMasCorta();
                                colas[colaMasCorta].enqueue( listaClientes.get(i) );
                                System.out.println( hora + ":\n\tEl cliente " + (i+1) + " ha ingresado a la cola " + (colaMasCorta+1) );
                        }
                }
                for( int i = 0; i < colas.length; i++ ){
                        Cola<Client> cola = colas[i];
                        if( ! cola.isEmpty() )
                        if( cola.peek().getHoraAtendido() == 0 ){
                                cola.peek().setHoraAtendido( hora );
                                System.out.println( hora + ":\n\t -- Se atiende al cliente " + cola.peek().getID() + " en la cola " + (i+1) );
                        }
                }
        }
        
        private void simulate()
        {
                System.out.println( "\n          .: Eventos :.             \n" );
                for( int i = 1; i < 512; i++ ){
                        atenderClient(i);
                        sacarClient(i);
                }
                System.out.println( "\nPromedio de permanencia: " + PermanenciaTotal / NUM_CLIENTES +"  Minutos." ); // PROMEDIO 
        }
        
        
        /**
         * Método que devuelve el índice de la cola más corta posible.
         * @return El índice de la cola vacía más próxima o de la cola con menor cantidad de clientes en espera.
         */
        private int darColaMasCorta()
        {        // Retorna la cola más próxima que esté vacía (si es que hay colas vacías)
                for( int i = 0; i < NUM_COLAS; i++ )
                        if( colas[i].isEmpty() ) return i;
                // Retorna la cola con menor cantidad de clientes en espera si no hay colas vacías
                int menor = colas[0].size();
                for( int i = 1; i < NUM_COLAS; i++ )
                        if( menor > colas[i].size() ) menor = colas[i].size();
                return menor;
        }

        public static void main( String[] args ){
                new Banco();
        }
        
}