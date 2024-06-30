
public class Cita
{
    private String fecha;
    private String nss;
    private String cedula;
    private String hora;
    
    /*Inicializa los atributos de la clase, recibiendo 4 en su parámetro del mismo tipo de String*/
    public Cita(String f,String n,String ce,String h){
    fecha=f;
    nss=n;
    cedula=ce;
    hora=h;
    }
    
    /*Cambia de valor a la variable fecha, recibiendo en su parámetro un String*/
    public void setFecha(String f){
    fecha=f;
    }
    
    /*Regresa el valor que contiene la variable fecha*/
    public String getFecha(){
    return fecha;
    }
    
    /*Cambia de valor a la variable nss, recibiendo en su parámetro un String*/
    public void setNss(String n){
    nss=n;
    }
    
    /*Regresa el valor que contiene la variable nss*/
    public String getNss(){
    return nss;
    }
    
    /*Cambia de valor a la variable cedula, recibiendo en su parámetro un String*/
    public void setCedula(String ce){
    cedula=ce;
    }
    
    /*Regresa el valor que contiene la variable Cedula*/
    public String getCedula(){
    return cedula;
    }
    
    /*Cambia de valor a la variable hora, recibiendo en su parámetro un String*/
    public void setHora(String h){
    hora=h;
    }
    
    /*Regresa el valor que contiene la variable hora*/
    public String getHora(){
    return hora;
    }
}
