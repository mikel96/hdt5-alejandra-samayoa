Se simulación de atención a clientes en las colas de un banco.1 Considere un banco con cuatro ventanillas. Un cliente entra en
al  banco  en  una  hora  específica  t1  (en  minutos  desde  la  apertura  del  banco)  y  desea  llevar  a  cabo  una  transacción  en
cualquier ventanilla. Se espera que la transacción tome el tiempo necesario t2 (minutos) para ser completada. Si una de las
ventanillas esta libre, la transacción del cliente será atendida inmediatamente. Así el tiempo de permanencia del cliente en el
banco será t2 (minutos).

Pero si no hay ninguna ventanilla libre, el cliente debe escoger la ventanilla que tenga la cola con menor cantidad de clientes y
esperar hasta ser atendido. Así el tiempo de permanencia del cliente en el banco será t2 (minutos) más el tiempo que estuvo
en la cola (en minutos).

Su  programa  deberá  calcular  el  tiempo  promedio  de  permanencia  de  los  clientes  en  el  banco.  Tendrá  cuatro  colas,  con  un
máximo de 10 clientes por cola. Debe leerse una serie de parejas de números (t1,t2) que representan a cada cliente; t1 es un
número entre 1 y 480 que indica el tiempo de llegada del cliente al banco, en minutos desde que el banco abrió. El tiempo t2
indica la duración de la transacción en minutos y es un número entre 1 y 30. Debe existir una indicación de que ya no hay más
clientes (por ejemplo t1 es negativo indica fin de clientes).

El programa utiliza una lista de eventos, ordenada por el tiempo del evento. Inicialmente se guardan en esta fila los eventos
de la llegada de los clientes (ordenados por el tiempo de llegada, t1). De esta lista de eventos se retira, ordenadamente por el
tiempo, cada evento y se procesa de la siguiente forma:

a.  Evento de llegada: se coloca el cliente (t1,t2) en la cola más corta. Si es el único cliente en esa cola, se coloca un evento
de salida, en la lista de eventos para salir en t2, indicando la cola del cliente.
b.  Evento de salida: se retira el cliente de la cola en que se encuentra, se calcula el tiempo que ha permanecido en el banco.
El siguiente cliente en la cola (si existe alguno) es ahora atendido en la ventanilla y se agrega un evento salida (para esta
cola) en la lista de eventos, indicando que el cliente saldrá t2 más tarde.

El programa se termina cuando la lista de eventos está vacía. Al procesar cada evento de  llegada se muestran los  clientes,
(t1,t2) que están en la cola a la que es asignado el cliente que llegó. Si ya se ha excedido el límite de clientes en todas las
colas se muestra un mensaje y se retiran todos los eventos de llegada de la lista de eventos.

Al finalizar el programa se indica el promedio de tiempo de permanencia de los clientes en el banco.