
public class Medico extends Persona
{
    private String cedula;
    
    /*Inicializa los atributos de la clase, recibiendo en su parámetro 5, 4 de tipo String y uno de tipo char*/
    public Medico(String n,String p,String m,char s,String cedula){
        super(n,p,m,s);
        this.cedula=cedula;
    }
    
    /*Cambia de valor a la variable Cedula, recibiendo en su parámetro de tipo String*/
    public void setCedula(String ce){
    cedula=ce;
    }
    
    /*Regresa el valor que contiene la variable Cedula*/
    public String getCedula(){
    return cedula;
    }
}
