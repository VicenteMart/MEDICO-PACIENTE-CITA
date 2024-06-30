
public class Paciente extends Persona
{
    private String nss;
    private int edad;
    
    /*Inicializa los atributos de la clase, recibiendo 4 en su parámetro del mismo tipo de String más un char y un int*/
    public Paciente(String n,String p,String m,char s,String nss,int e){
    super(n,p,m,s);
    this.nss=nss;
    edad = e;

    }
    
    /*Cambia de valor a la variable NSS, recibiendo en su parámetro un String*/
     public void setNss(String n){
    nss=n;
    }
    
    /*Regresa el valor que contiene la variable NSS*/
    public String getNss(){
    return nss;
    }
    
    /*Cambia de valor a la variable Edad, recibiendo en su parámetro un int*/
     public void setEdad(int e){
    edad=e;
    }
    
    /*Regresa el valor que contiene la variable Edad*/
    public int getEdad(){
    return edad;
    }
    
}
