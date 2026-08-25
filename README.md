Gestor de gastos en Java

Integrantes:
  -Aarón Trejo (Estudiante A)
  -Diego Alberto Dávalos Salinas (Estudiante B)

Responsabilidades de cada integrante:
  -Aarón Trejo:
    Implementación de los métodos para registro de gastos, mostrar los gastos, mostrar el resumen de gastos.
  -Diego Alberto Dávalos Salinas:
    Implementación de los métodos para calcular el total de gastos, obtener y mostrar gasto mayor, calcular y consultar el gasto por categoria.

Instrucciones para ejecutar el programa
  1-Al correr el programa, se desplegará un menú enumerado con opciones para el registro o visualizacion de gastos.
  2-Ingresar el número la acción a realizar.
  3-Seguir los pasos indicados en el programa para el registro o consulta de gastos.
  4-Realizar las acciones el número de veces que el usuario requiera.
  5-Ingresar 7 para cerrar el programa.

Métodos implementados
  -registrarGasto
  -mostrarGasto
  -mostrarResumen
  -calcularTotal
  -obtenerPosicionGastoMayor
  -mostrarGastoMayor
  -calcularTotalPorCategoria
  -consultarGastosPorCategoria
  
Conflicto encontrado y forma de resolverlo
  -Cada estudiante hizo un cambio diferente en la linea de presentación inicial del programa, creando un conflicto intencional. Para resolverlo se acordó un texto de presentación para sustiruir a los dos anteriores, se hizo la correción en Github y se hizo el merge al programa principal.

Conclusión individual de cada integrante
  -Aarón Trejo:
    Durante el desarrollo colaborativo de este proyecto, entendi conceptos clave sobre el control de versiones, comprendiendo que el *commit* guarda el historial de forma local mientras que el *push* sube esos cambios al servidor, lo que hace ejecutar siempre un *pull* antes de editar archivos para sincronizar nuestro entorno con la versión más actualizada y prevenir incongruencias. Asimismo, el uso de ramas demostró ser importante para aislar el desarrollo de nuevas características sin arriesgar la estabilidad del código principal; sin embargo, durante la integración nos enfrentamos a un conflicto ocasionado por la modificación simultánea de las mismas líneas de código por los dos alumnos distintos. Para solucionarlo, analizamos manualmente el archivo y decidimos conservar el bloque de código que presentaba la lógica más robusta y que mejor cumplía con los requerimientos del sistema. Finalmente, mi aportación personal al proyecto consistió en el desarrollo del método `registrarGasto`, donde implementé ciclos de validación estrictos para evitar caídas del sistema por ingresos de datos erróneos, además de programar la lógica matemática y de visualización en las funciones `calcularTotal` y `mostrarResumen` para procesar correctamente la información de las listas.
    
  -Diego Alberto Dávalos Salinas:
    Esta práctica me ayudó a comprender cómo se usa Github para elaboración de proyectos de progamación colaborativos, entendiendo qué es un commit, push, pull, conflicto y merge, cuándo se usa cada uno y cómo. Además me permitió conocer como funcionan varias funciones, ciclos y condicionales en Java, usando como base conocimientos previos de C y C++. EL commit únicamente guarda los cambios en el repositorio local, mientras que el push hace que los cambios se vean reflejados en Github. Debe hacerse pull antes de modificar archivos para trabajar con las versiones más actuales del programa y evitar conflictos. Las ramas sirven para que cada colaborador realice cambios en el programa pero de una forma aislada del main, para que éste sólo se modifique cuando los cambios hechos en la rama sean aprobados por el equipo. El conflicto fue ocasionado por la modificación de la misma parte del código por parte de diferentes colaboradores. Se decidió qué código conservar en base a las versiones más actuales o correctas de los métodos, as+i como los acuerdos entre colaboradores. Aporté al programa los métodos para el total de gastos, y para obtener y mostrar le gasto mayor y el total por categoría, así como el diseño del menú de opciones.
