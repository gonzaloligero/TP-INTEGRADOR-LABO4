UNIVERSIDAD TECNOLÓGICA NACIONAL 

FACULTAD REGIONAL GENERAL PACHECO

Tecnicatura Universitaria en 
Programación

LABORATORIO IV 

TRABAJO PRÁCTICO INTEGRADOR


Se pide crear un sistema de gestión para un banco en donde existirán dos 
tipos de usuarios: administrador del banco y clientes.

Usuario banco
• ABML de clientes. Tener en cuenta que a cada cliente se le asignará 
un usuario y contraseña para poder acceder a la web del banco. El 
administrador podrá cambiar la contraseña, pero nunca se podrá 
modificar el usuario de ese cliente.

• ABML de cuentas y asignación de cuenta a cliente. Una cuenta debe 
pertenecer a un solo cliente. Se le podrá asignar un máximo de 3 
cuentas a un cliente. Al crear la cuenta se le asignará un monto inicial 
fijo de $10.000.

• Autorización de préstamos. El administrador podrá autorizar o 
rechazar los préstamos solicitados por el cliente. Si se aprueba el 
préstamo entonces se le asignará al cliente el monto pedido. Tener 
en cuenta que se deberán generar las cuotas para que luego pague 
el cliente.

• Incluir informe/reportes estadísticos para el administrador.
Usuario cliente

• El cliente podrá seleccionar una cuenta y observar el historial de los 
movimientos realizados en esa cuenta.

• Transferencias a otros clientes: Un cliente podrá transferir dinero 
entre sus propias cuentas o a cuentas de otros clientes utilizando el 
CBU. Se podrá realizarla transferencia mientras el usuario cuente con 
dinero disponible. Si no posee dinero no podrá transferir.

• Pedido de préstamo. El cliente podrá pedir un préstamo de cierto 
dinero al banco, seleccionar la cantidad de cuotas en las que quiere
NOTA: Para realizar el Trabajo Práctico Integrador deberá utilizar JAVA. 
Se deberán incluir lossiguientestemas: JDBC / JSP / SERVLETS / SESSION
abonarlo y elegir la cuenta en donde se le depositará el pago del 
préstamo. El banco recibirá el pedido y autorizará o no dicho 
préstamo.

• El cliente tendrá un menú de pago de préstamos en donde figure las 
cuotas que debe pagar, podrá pagar seleccionando la cuota y cuenta 
de donde se descontará dicho gasto. Cada vez que se pague una 
cuota se guardará la fecha en la cual se pagó la misma.

• El cliente podrá visualizarsu información personal. No podrá cambiar 
los datos, solo los visualizará.


Observaciones


Asumiremos que no se generan intereses por el pago fuera de término de 
la cuota de un préstamo, la cuota es fija. También asumiremos que toda la 
funcionalidad pertenece a un mismo banco (en la tabla usuario de la base 
de datos deberán tener un usuario de tipo administrador de banco para que 
pueda acceder a la aplicación). No es necesario hacer un ABML de tipo de 
cuentas posibles y tipos de movimientos, los mismos deben estar cargados 
previamente en la base de datos. Las cuentas no pueden quedar con saldos 
negativos.

Tipos de cuentas posibles:
• Caja de ahorro.
• Cuenta corriente.

Tipos de movimientos posibles:
• Alta de cuenta. El alta de una cuenta genera un movimiento de 
dinero positivo en la cuenta origen.

• Alta de un préstamo. El alta de un préstamo genera un movimiento 
de dinero positivo en la cuenta origen.

• Pago de préstamo. El pago de un préstamo genera un movimiento de 
dinero negativo en la cuenta origen.

• Transferencia. Una transferencia genera dos movimientos, un 
movimiento negativo en la cuenta de origen (extracción de dinero) y 
un movimiento positivo en la cuenta destino (depósito de dinero)

En cuanto a los datos, mínimamente cada tabla tiene lossiguientes datos:
• Por cada movimiento se tiene una fecha, detalle o concepto, importe 
y tipo de movimiento.

• Un cliente tiene un DNI, CUIL, nombre, apellido, sexo, nacionalidad, 
fecha de nacimiento, dirección, localidad, provincia, correo 
electrónico, teléfonos, un usuario y contraseña para acceder a la 
página.

• Una cuenta tiene un cliente asignado, fecha de creación, tipo de 
cuenta, un número de cuenta, CBU y un saldo.
• Un préstamo tiene un cliente asignado, una fecha, el importe que 
deberá pagar el cliente (con intereses), el importe pedido por el 
cliente, un plazo de pago en meses, el monto que deberá pagar por 
mes y cuotas.

1) Se debe participar en el foro del TP integrador. Los alumnos que no 
participen en el foro serán considerados que no participaron de la tarea 
y por ende desaprobaran la misma. También se evaluará el contenido 
que aporto cada alumno y a partir de esto se definirá la nota que 
obtendrá cada uno. En cada aporte al foro deberán aclarar que 
modificación están realizando.
2) Debe haber un acceso al sistema (LOGIN).
3) En cada pantalla se podrá observar el usuario que accedió al sistema. 
(USUARIO LOGUEADO).
4) Los listados deben estar paginados.
5) Utilizar búsquedas y filtros en los listados. Las búsquedas hacerlas 
generales utilizando el comparador LIKE %contenido% para traer todos 
los textos que cumplen con la condición, no solo el texto que sea 
idéntico. También trabajar con filtros, los filtros no son iguales a las 
búsquedas, los filtros permiten seleccionar opciones como, por ejemplo, 
en el listado de movimientos que te permita seleccionar los movimientos 
cuyo importe total este en un rango entre 1000 a 2000, o <100, >=100, 
etc.
6) Mensajes aclaratorios “Se agrego correctamente en la base de datos”
7) Trabajar con programación en tres capas, utilizar interfaces y manejar 
las excepciones.
8) Es necesario que el código se encuentre divididos en paquetes. Las 
excepciones estarán en un paquete separado y deberán crear al menos 
dos excepciones propias.
9) Acerca de las entidades, las clases deben estar correctamente 
diagramadas. Ejemplo: la clase movimiento debe tener un objeto de tipo 
movimiento en su interior, no un int ID_movimiento ni tampoco string 
descripción_movimiento.
10) No tiene que haber desde los JSP, llamados al DAO ni al NEGOCIO 
desde los JSP se tiene que llamar al SERVLET y el SERVLET llama al 
negocio. Por último, el negocio llama al DAO. El SERVLET es el 
“controlador” de nuestras aplicaciones web.


PARA PODER APROBAR EL TP INTEGRADOR DEBE CUMPLIR LAS 
SIGUIENTES PAUTAS:


12) En los descolgables deben aparecer también las descripciones y
no solo sus identificadores.
13) Manejar bajas lógicas y no físicas.
14) Trabajar con VALORES CON DECIMALES.
15) No guardar campos vacíos en la base de datos. Para eso usar 
validaciones. Ejemplo: validación de números, de textos, correo 
electrónico, etc. validar que si se hace clic sobre el botón y no hay nada 
cargado entonces no se guarde ese registro en la base de datos.
16) Al modificar, se podrán modificar todos los campos de la tabla, 
obviamente no se modificará el campo clave. Se deben cargar 
automáticamente todos los campos que se le va a permitir modificar al 
usuario, luego este cambia solo el dato que necesita. Al modificar un solo 
campo de la base de datos, no se deben borrar los demás campos, solo 
se deberá actualizar el campo que el usuario esté cambiando.
17) Utilizar mensajes de confirmación. Ejemplo: ¿Está seguro que desea 
eliminar el registro?
18) Al dar de alta un usuario pedir la clave dos veces y usar
asteriscos para no mostrarla.
19) Tener cuidado con los repetidos en la base de datos, por ejemplo: 
no podría haber dos personas con el mismo DNI en la base de datos.
20) Luego de realizar un cambio sobre un registro por ejemplo al 
agregar, limpiar todos los controles. Es decir, se deberá borrar la
información que acaba de ingresar el usuario.
21) Incluir reportes/estadísticas con parámetros. NO ES LO MISMO UN 
LISTADO QUE UN REPORTE, UN REPORTE ES INFORMACIÓN QUE SE 
OBTIENE A PARTIR DE LOS DATOS QUE SE ENCUENTRAN EN LA BASE DE
DATOS. Ejemplo: Seleccionar fecha de inicio y fecha de fin, y obtener el 
monto total de egreso e ingreso en la empresa. Los parámetros en este 
caso sería la selección de fechas.
22) Utilizar descolgables en los casos que sea necesario. Ejemplo: para 
provincia, localidades, géneros, etc. Si se modifica dentro de una grilla y 
tienen campos que aplican para ser descolgables, entonces utilizar dicho 
control.
23) En el caso de dar de alta un usuario, un usuario común NO
PUEDE DAR DE ALTA UN ADMINISTRADOR.

24) Cambiar el nombre de las columnas de las grillas y dejar uno
apropiado. Usar para ello la instrucción AS del lenguaje SQL. Ejemplo: 
“Select p_nombre AS nombre from Persona.
25) Antes de rendir, se deberá cargar la base de datos con varios 
registros con información válida para la prueba. Mínimamente 15 
registros por tabla para poder probar búsquedas y filtros.


ENTREGAS OBLIGATORIAS TP INTEGRADOR


Habrá dos entregas del TP integrador. Es necesario aprobar la primera 
entrega, para poder presentarse a la segunda. Cada entrega tendrá su 
recuperatorio. Si se desaprueba el recuperatorio se desaprueba el TP 
integrador y por ende la materia. La primera entrega se realizará por aula 
virtual; deberán realizar toda la parte gráfica de la aplicación, el DER y el 
funcionamiento del Login junto al ABML de clientes (No olvidar leer las 
pautas y hacerlo en tres capas). La segunda entrega es el TP integrador 
funcionando completo y deberán defenderlo por videollamada.
RECORDAR PARTICIPAR EN LOS FOROS, YA QUE EVALUAREMOS SU 
PARTICIPACIÓN A PARTIR DE LOS APORTES QUE VEREMOS ALLÍ. LUEGO, 
TODOS DEBEN SABER REALIZAR TODO, POR EJEMPLO: A VECES NOS DICEN 
“YO SOLO HICE LA CONEXIÓN A LA BASE DE DATOS”, ESTO NO ES 
CORRECTO, TIENEN QUE PARTICIPAR Y SABER REALIZAR TODA LA 
FUNCIONALIDAD DEL TP. EN LAS DEFENSAS POR VIDEOLLAMADA, PUEDEN 
RECIBIR PREGUNTAS DE CUALQUIER PARTE DEL CÓDIGO.
PRIMERA ENTREGA: DOMINGO 23/06/2024 23:55 pm. Se deberá subir al
aula virtual una carpeta comprimida que tenga:
➢ El proyecto que deberá llamarse TPINT_GRUPO_X_LAB4. Para el 
diseño de las pantallas se deberán utilizar JSP.
➢ Un Word que contenga el DER y las impresiones de pantalla de cada
JSP y en cada imagen explicar el funcionamiento que se podrá realizar 
sobre la pantalla.
➢ En cuanto a funcionalidad, entregar el Login y el ABML de clientes
funcionando, incluir el SCRIPT de la base de datos con datos para 
poder probar y mencionar con que dato se debe ingresar al sistema.
➢ Leer y cumplir las pautas para aprobar el TP integrador.
Página 9 de 10
También se puede entregar el TP Integrador:
*El jueves 11/07/2024 (Semana de receso) 18 a 22 hs
*El jueves 18/07/2024 . (Primer llamado a final) 18 a 22 hs
* El jueves 25/07/2024. (Segundo llamado a final) 18 a 22 hs 
Recordar que se deben postularse en el foro, en la fecha que elijan, por 
aula virtual. 
Tener en cuenta que si rinden la defensa del TP Integrador en el 2do
llamado a final, es decir el jueves 25/07/2024, regularizaran en esa 
fecha y luego para anotarse a los turnos de finales de exámenes 
deberán esperar el siguiente llamado, es decir diciembre 2024
SEGUNDA ENTREGA: JUEVES 04/07/2024 de 18 a 22hs . Se realizará a
distancia a través de ZOOM y se deberá entregar el TP integrador 
completo funcionando.
➢ A cada grupo se le asignará un horario.
➢ Es importante que a la hora de entregar el TP integrador completo, 
se haya probado dicho funcionamiento y se hayan cargado datos en 
la base de datos.
➢ Utilizamos la herramienta ZOOM para realizar la defensa del TP, es
RECOMENDABLE utilizar la cámara y el audio, además respetar el 
horario asignado. No presentarse en el horario, es equivalente a 
desaprobar la entrega.
➢ La defensa del TP integrador es individual, es decir que se presenta 
el grupo completo y luego se realizan preguntas individuales a cada 
integrante para evaluarlo de manera particular. Por ejemplo: puede 
suceder que, en un grupo de 3 integrantes, aprueben 2.
Página 10 de 10
Importante: los alumnos que no entreguen las entregas intermedias 
del TP Integrador o no lo aprueben en los plazos indicados quedarán 
libres en la materia y deberán recursar.
REGULARIZACION DE LA MATERIA
Recuerden que para regularizar la materia es necesario:
➢ Aprobar la primera parte de la materia (aplicaciones de 
consola/escritorio/web en java).
➢ Aprobar todas las entregas del TP integrador y entregar el TP
integrador funcionando.
➢ Recuerden que si aprobaron la primera parte de la materia y el TP 
Integrador significa que regularizaron la materia. Para “pasarles la 
nota” deben inscribirse en los turnos de exámenes.
Final de la materia:
➢ LOS ALUMNOS QUE DEBAN RENDIR EL FINAL de la materia deberán 
traer los cambios pedidos por el docente al momento de entregar el 
TP integrador para regularizar la cursada. Si al momento de rendir el 
final, el alumno no trae los cambios pedidos por el docente, 
entonces desaprobará dicho final.
