Imprimir por pantalla los números de 1 a N. (Vease en Ascendente.java)
A continuación, hacer otra función que haga lo mismo pero de N a 1. 
(Vease en Ascendente.java)

Pregunta: Si se ha usado memoria, intentar encontrar la solución sin 
usar memoria (solo con el parámetro N)

Respuesta: El Descendente no necesita memoria extra debido a que 
imprime el resultado ANTES de que se ejecute la siguiente iteración 
del programa, y es justo debido a esta relación que el Ascendente 
si que necesita memoria, ya que debido a que imprime DESPUES de la 
llamada/ejecucion de la siguiente iteración del método y tienen que 
esperar almacenados hasta que se acabe de ejecutar el metodo (m-1) 
para que el mismo (m) acabe de ejecutarse. Y respecto al arreglar 
el tema de la memoria solo usando el parametro (int n) es virtual-
mente imposible, ya que se necesita un parametro para guardar los 
valores, en este caso un array o una lista.