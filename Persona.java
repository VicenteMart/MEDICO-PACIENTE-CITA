
public abstract class Persona
{
    private String nombre;
    private String apaterno;
    private String amaterno;
    private char sexo;
    
    /*Recibe en su parámetro 3 String y un char, para inicializar nombre,apellido paterno, materno y género*/
    public Persona(String nombre,String pater,String mater,char s){
    this.nombre=nombre;
    apaterno=pater;
    amaterno=mater;
    sexo=s;
    }
    
    /*Cambia de valor a la variable nombre, recibiendo en su parámetro un String*/
    public void setNombre(String n){
    nombre=n;
    }
    
    /*Regresa  valor de la variable nombre*/
    public String getNombre(){
    return nombre;
    }
    
    /*Cambia de valor a la variable apaterno, recibiendo en su parámetro un String*/
     public void setApaterno(String p){
    apaterno=p;
    }
    
    /*Regresa  valor de la variable apaterno*/
    public String getApaterno(){
    return apaterno;
    }
    
    /*Cambia de valor a la variable amaterno, recibiendo en su parámetro un String*/
     public void setAmaterno(String m){
    amaterno=m;
    }
    
    /*Regresa  valor de la variable amaterno*/
    public String getAmaterno(){
    return amaterno;
    }
    
    /*Cambia de valor a la variable sexo, recibiendo en su parámetro un char*/
    public void setSexo(char s){
    sexo=s;
    }
    
    /*Regresa  valor de la variable sexo*/
    public char getSexo(){
    return sexo;
    }
}
