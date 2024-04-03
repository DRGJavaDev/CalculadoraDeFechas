# CalculadoraDeFechas
Herramienta  que permite realizar operaciones con fechas utilizando Java.


## Funciones Disponibles
La calculadora de fechas ofrece las siguientes funciones:
- calcularPeriodoEntreFechas: Calcula el período entre dos fechas.
- calcularDiaDeLaSemana: Calcula el día de la semana para una fecha dada.
- calcularDiasLaborablesEnUnPeriodo: Calcula el número de días laborables en un período de tiempo.
- calcularEdad: Calcula la edad de una persona a partir de su fecha de nacimiento.
- cambiarFormatoFechas: Convierte el formato de una fecha al formato americano.


## Uso
Para usar la calculadora de fechas, puedes ejecutar el programa Java especificando la función deseada y los argumentos necesarios. 

Los argumentos deben proporcionarse en el formato indicado:
  calcularPeriodoEntreFechas <argumento1> <argumento2> 
  calcularDiaDeLaSemana <argumento1> 
  calcularDiasLaborablesEnUnPeriodo <argumento1> <argumento2> 
  calcularEdad <argumento1> 
  cambiarFormatoFechas. <argumento1>


Si necesitas ayuda, puedes ejecutar el programa sin argumentos o con h o help como argumento para obtener una lista de funciones disponibles y ejemplos de uso.

## A continuación se muestran algunos ejemplos de uso:
java -jar CalculadoraFechas.jar CalcularPeriodoEntreFechas "10 03 2024" "07 02 2023"

java -jar CalculadoraFechas.jar calcularDiaDeLaSemana "03 04 2024"

java -jar CalculadoraFechas.jar calcularDiasLaborablesEnUnPeriodo "02 08 2023" "03 04 2024"

java -jar CalculadoraFechas.jar calcularEdad "01 08 1985"

java -jar CalculadoraFechas.jar cambiarFormatoFechas "01 08 1985"




