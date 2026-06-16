Obtener la suma de los primeros N números naturales, siendo N el único
parámetro.

Pregunta: Considerar si el algoritmo puede hacerse de forma recursiva sin
memoria, o si necesita memoria adicional. Para ello, desplegar la
solución de varios casos (N = 5, 6, 7) y comprobar si un caso
contiene la solución de otro anterior.

Respuesta: En Sumatorio.java si que se necesita memoria adicional para 
realizar las sumas en este programa, ya que cada iteración del programa 
necesita recordar información de las llamadas anteriores. El algoritmo 
necesita memoria adicional para almacenar las llamadas pendientes en la 
pila de ejecución.
S(7)
│
└── 7 + S(6)
         │
         └── 6 + S(5)
                  │
                  └── 5 + S(4)

Dicho esto tambien existe la posibilidad de hacer el codigo con recursión de
cola, es decir crear un parametro aparte de (int n) que se ocupe de guardar
la informacion que guardaba la pila y era necesaria para el resto de itera-
ciones, ahorrando asi el uso de memoria adicional (Vease en NoMem_Sumatorio).
El parametro en cuestión se inicializará siempre a 0

Tambien se ha creado el código en iterativo (Vease en Iterativo_Sumatorio).