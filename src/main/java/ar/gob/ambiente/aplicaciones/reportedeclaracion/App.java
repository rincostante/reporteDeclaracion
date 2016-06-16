package ar.gob.ambiente.aplicaciones.reportedeclaracion;

import ar.gob.ambiente.aplicaciones.reportedeclaracion.modelo.DeclaracionJurada;
import ar.gob.ambiente.aplicaciones.reportedeclaracion.modelo.Firmante;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DeclaracionJurada dec = new DeclaracionJurada();
        dec.setCude("990-5555-1");
        dec.setObservaciones("Levantada por la app");
        dec.setId(Long.valueOf(1));
        
        Firmante fir = new Firmante();
        fir.setCuit(Long.valueOf("20140083780"));
        fir.setDni(14008378);
        fir.setId(Long.valueOf(1));
        fir.setNombreYApellido("Firmante de prueba");
        
        dec.setFirmante(fir);
        
        System.out.println("Levantando el modelo");
        System.out.println("********************************************");
        System.out.println("************* Declaración ***********");
        System.out.println("Id: " + dec.getId());
        System.out.println("CUDE: " + dec.getCude());
        System.out.println("Obs: " + dec.getObservaciones());
        System.out.println("*************** Firmante ************");
        System.out.println("Id: " + dec.getFirmante().getId());
        System.out.println("Nombre: " + dec.getFirmante().getNombreYApellido());
        System.out.println("DNI: " + dec.getFirmante().getDni());
        System.out.println("CUIT: " + dec.getFirmante().getCuit());
        System.out.println("********************************************");
        System.out.println("Modelo levantado");
    }
}
