package proceso;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Procesador {

	//La calculadora espera que le digas que metodo vas a usar. y sus parametros.
	//POR EJEMPLO:
	//java -jar CalculadoraFechas.jar CalcularPeriodoEntreFechas "10 03 2024" "07 02 2023"
	//java -jar CalculadoraFechas.jar calcularDiaDeLaSemana "03 04 2024"
	//java -jar CalculadoraFechas.jar calcularDiasLaborablesEnUnPeriodo "02 08 2023" "03 04 2024"
	//java -jar CalculadoraFechas.jar calcularEdad "01 08 1985"
	//java -jar CalculadoraFechas.jar cambiarFormatoFechas "01 08 1985"

	public static void main(String[] args) {
	    if (args.length == 0 || args[0].equalsIgnoreCase("h") || args[0].equalsIgnoreCase("help")) {
	    	System.out.println("Funciones disponibles: \n" + 
	    		    "- CalcularPeriodoEntreFechas <argumento1> <argumento2> \n" +
	    		    "- calcularDiaDeLaSemana <argumento1> \n" + 
	    		    "- calcularDiasLaborablesEnUnPeriodo <argumento1> <argumento2> \n" + 
	    		    "- calcularEdad <argumento1> \n" + 
	    		    "- cambiarFormatoFechas. <argumento1> \n\n");
            System.out.println("Uso: \n java -jar CalculadoraFechas.jar CalcularPeriodoEntreFechas \"10 03 2024\" \"07 02 2023\"");
            return;
        }

        String funcion = args[0];
        LocalDate argumento1 = (args.length >= 2 && args[1] != null && !args[1].isEmpty()) ? stringALocalDate(args[1]) : null;
        LocalDate argumento2 = (args.length >= 3 && args[2] != null && !args[2].isEmpty()) ? stringALocalDate(args[2]) : null;

        switch (funcion) {
            case "CalcularPeriodoEntreFechas":
            	CalcularPeriodoEntreFechas(argumento1, argumento2);
                break;
            case "calcularDiaDeLaSemana":
            	calcularDiaDeLaSemana(argumento1);
                break;
            case "calcularDiasLaborablesEnUnPeriodo":
            	calcularDiasLaborablesEnUnPeriodo(argumento1, argumento2);
                break;
            case "calcularEdad":
            	calcularEdad(argumento1);
                break;
            case "cambiarFormatoFechas":
            	cambiarFormatoFechas(argumento1);
                break;
            default:
                System.out.println("Función o parametros incorrectos");
        }
    }

	private static LocalDate stringALocalDate(String fechaEntrada) {
		DateTimeFormatter patronBasico = DateTimeFormatter.ofPattern("dd MM yyyy");	
		LocalDate fechaSalida = LocalDate.parse(fechaEntrada, patronBasico);
		return fechaSalida;
      }	

    private static void cambiarFormatoFechas(LocalDate argumento1) {
    	DateTimeFormatter patronAmericano = DateTimeFormatter.ofPattern("MM dd yyyy");	
    	String fechaAmericana = argumento1.format(patronAmericano);
    	System.out.println("El formato americano de la fecha introducida es: " + fechaAmericana);
		
	}

	private static void calcularEdad(LocalDate fechaEntrada) {
		Period edadActual = fechaEntrada.until(LocalDate.now());
	    System.out.println("El usuario tiene: " + edadActual.getYears() + "años y " + edadActual.getMonths() + "meses.");
		
	}

	private static void calcularDiasLaborablesEnUnPeriodo(LocalDate fechaInicio, LocalDate fechaFin) {
		int diasLaborables = 0;       
        while (!fechaInicio.isAfter(fechaFin)) {
            // Excluir fines de semana (sábado y domingo)
            if (fechaInicio.getDayOfWeek() != DayOfWeek.SATURDAY && fechaInicio.getDayOfWeek() != DayOfWeek.SUNDAY) {
                diasLaborables++;
            }
            // Avanzar al siguiente día
            fechaInicio = fechaInicio.plusDays(1); 
        }
		System.out.println("Días laborables en el período: " + diasLaborables);	
	}

	private static void calcularDiaDeLaSemana(LocalDate fechaEntrada) {
		// Obtener el nombre del día de la semana en español
	    String diaSemana = fechaEntrada.getDayOfWeek().getDisplayName(TextStyle.FULL,new Locale("es"));
	    System.out.println("El " + fechaEntrada + " cae en " + diaSemana);		
	}

	private static void CalcularPeriodoEntreFechas(LocalDate fecha1, LocalDate fecha2) {
		Period periodo = fecha1.until(fecha2);
		 int años = Math.abs(periodo.getYears());
		 int meses = Math.abs(periodo.getMonths());
		 int dias = Math.abs(periodo.getDays());
		
		// Imprimir el período
		System.out.println("Entre las fechas " + fecha1 + " y " + fecha2 + " hay: ");
		System.out.println("Años: " + años);
		System.out.println("Meses: " + meses);
		System.out.println("Días: " + dias);   
	}

}
	
