
package ComentariosEvaluación;

public class ComentariosJoseRamon {
    
    /*
    Qualificació 	6.97 / 10.00
    
    1. Quan totes les dades són correctes i la matrícula no està repetida, insereix el vehícle a la cua inicial.    
    "Cuando se introduce un vehículo correctamente simplemente indicad en que posición se encuentra dicho vehículo, no mostréis la cola entera (eso se puede hacer en todo caso en la opción 5)"
    
    2. Demana el box on introduir el vehicle. Valida que el valor que s'introdueix és correcte (1-6) i torna a demanar el valor fins que siga correcte. 
    "No pide el box en el que se quiere introducir al vehículo."
    
    2. Si el box on es vol introduir el cotxe té buida la seua primera fase, s'inserirà el vehicle (el que porta més temps a la cua) a la primera fase d'eixe box, i s'extraurà eixe vehicle de la cua.
    A més es mostrarà un missatge informant de que l'operació ha sigut completada correctament. 
    "Al introducir el vehículo al box sí desaparece de la cola, pero al desplazar los coches de la cola hacéis algo mal de modo que el último se duplica, y si seguís añadiendo coches a la cola os
    quedarán por ahí repetidos: Posición 2: Matricula: 3333CCC Modelo: Ford Tipo: Coche El vehículo con la matrícula 3333CCC aun no ha superado la revisión Posición 3: Matricula: 4444DDD
    Modelo: Mazda Tipo: Furgoneta El vehículo con la matrícula 4444DDD aun no ha superado la revisión Posición 4: Matricula: 4444DDD Modelo: Mazda Tipo: Furgoneta El vehículo con la matrícula 4444DDD
    aun no ha superado la revisión"
    
    4. Demana el box. Valida que el valor que s'introdueix és correcte (1-6) i torna a demanar el valor fins que siga correcte.
    "Siempre dice que es incorreccto: Selecciona una opción: 4 Dime un número de box para consultar su estado (1 - 6): 2 Número de box inválido. Debe estar entre 1 y 6. Volver a insertar: 1 Número de
    box inválido. Debe estar entre 1 y 6. Volver a insertar:"
    
    Disseny de classes. Descomposició modular i en classes de l'aplicació.
    "Os recomiendo que analicéis si algunos métodos muy pequeños pueden desaparecer o (más habitual) métodos grandes se pueden modularizar. Por ejemplo el método inicio me parece gigante. Hay acciones
    distintas como mostrar el menú, leer la opción. Luego el código de cada case se podría llevar en ocasiones a otros métodos como desplazar las matriculas y otras operaciones. En general falta algo
    más de encapsulación y que muchas tareas se encarguen las propias clases individuales y no la clase taller, por ejemplo es raro que se haga "boxes[i].getFaseRevision()[0].estaLibre()" (y otras veces
    accedeis por "getPrimeraFase") en vez de que la propia clase "box" tenga el método "estaLibre" porque tenemos que evitar acceder a los componentes internos, al igual 
    que "boxes[i].getFaseRevision()[0].asignarVehiculoFase(v)" o en la clase Cola el método "getCola" que precisamente no usáis porque la idea es no tener que tocar las partes internas (en este caso
    el array) y que se haga siempre por medio de sus métodos."
    
    GENERAL - Quan s'introdueix l'opció 6 el programa no acaba.
    "En la clase Taller no tiene ningún sentido la etiqueta programaITV ni el break de la línea 170. Es redundante. Como la opción es 6 ya no se cumplirá la condición del while y saldrá. No funciona bien
    cuando previamente se ha usado una opción correcta. Por ejemplo si ejecutas la opción 5, luego la 6 dice "Fin del programa"! pero sigue esperando datos."
    */
}
