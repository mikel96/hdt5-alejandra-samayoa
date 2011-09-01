
package Source;

/**
 * Clase que representa a un cliente del banco. Un cliente tiene
 * un tiempo de entrada y un tiempo de permanencia (t1 y t2)
 * @author Pingus
 *
 */
public class Client implements Comparable<Client>{
        /** Hora de entrada del cliente en minutos desde la apertura del banco.
         * No debe ser mayor a 480 */
        private int horaEntrada;
        
        /** Tiempo que le tomará al cliente hacer su mandado (en minutos).
         * No debe ser mayor a 30 */
        private int tiempoEstadia;
        
        /**
         * Hora a la que atienden al cliente en el banco.
         */
        private int atentdidoalas;
        
        /**Identificador */
        private int id;
        
        
        
        /**
         * Crea una instancia del cliente
         * @param t1 La hora de entrada del cliente al banco en minutos desde la apertura del banco.
         * @param t2 Tiempo que le tomará al cliente hacer su mandado (en minutos).
         * pre: t1 debe ser un número entre 1 y 480. t2 debe ser un número entre 1 y 30.
         */
        public Client(int ide, int t1, int t2 ){
                
                assert t1 > 0 && t1 <= 480 : "La hora de entrada debe ser un número entre 1 y 480.";
                assert t2 > 0 && t2 <= 30 : "El tiempo de permanencia debe ser menor a 30 minutos.";
                id = ide;
                horaEntrada = t1;
                tiempoEstadia= t2;
                atentdidoalas = 0;
        }
        /**
         * Método que retorna la hora de entrada del cliente
         * @return La hora en la que el cliente entra al bancho en minutos desde la apertura del banco.
         */
        public int getHoraEntrada(){
                return horaEntrada;
        }
        
        /**
         * Método que retorna el tiempo que el cliente permanecerá en el banco
         * @return El tiempo que al cliente le toma hacer su mandado (en minutos).
         */
        public int getTiempoEstadia(){
                return tiempoEstadia;
        }
        
        /**
         * Método que retorna la hora en la que atienden al cliente
         * @return La hora en la que atienden al cliente. 0 si no ha sido atendido.
         */
        public int getHoraAtendido(){
                return atentdidoalas;
        }
        
        /**
         * Método que indica al cliente la hora en la que ha sido atendido.
         * @param unaHora La hora en la que se empezó a atender al cliente en el banco.
         */
        public void setHoraAtendido( int unaHora ){
                atentdidoalas = unaHora;
        }
        
        /**
         * Método que calcula y retorna la hora a la que el cliente saldrá del banco.
         * @return 0 Si no ha sido atendido. horaAtendido + tiempoPermanencia Si ya fue atendido.
         */
        public int getHoraSalida(){
                if( atentdidoalas == 0 ) return 0;
                return atentdidoalas + tiempoEstadia;
        }
        
        @Override
        public int compareTo(Client otro) {
                if( horaEntrada < otro.horaEntrada ) return -1;
                else if( horaEntrada == otro.horaEntrada ) return 0;
                else return 1;
        }
        
        public String toString()
        {
                return "\n\tHora de Ingreso: " + horaEntrada + "\n\tDuración de transacción: " + tiempoEstadia;
        }
        
        public int getID(){
                return id;
        }
}