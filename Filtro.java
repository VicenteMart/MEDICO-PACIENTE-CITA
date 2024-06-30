import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

public class Filtro
{   
    /*Filtra todos los paciente de X Medico*/
    public static ArrayList filtrarPacientesDeMedico(String nombre,String ap,String am,Medico medico,ArrayList<Cita> cita,ArrayList<Paciente> paciente)throws Exception{
        ArrayList<Paciente> pacientes=new ArrayList<Paciente>();
        
            if(nombre.equals(medico.getNombre())&&ap.equals(medico.getApaterno())&&am.equals(medico.getAmaterno())){
             
                int i=0;
                while(i<cita.size()){
                    if(medico.getCedula().equals(cita.get(i).getCedula())){
                        boolean encontrado=false;
                        int y=0;
                        while(y<paciente.size()&&encontrado==false){
                            if(cita.get(i).getNss().equals(paciente.get(y).getNss())){
                                encontrado=true;
                                pacientes.add(paciente.get(y));
                            }
                            y++;
                        }
                    }
                    i++;
                }

            }    
    
        

        return pacientes;
    }

    /*Filtra todo los pacientes que tiene la misma hora de Cita*/
    public static ArrayList<Paciente> filtrarPacientesXhora(String hora,ArrayList<Cita> cita,ArrayList<Paciente> paciente){
        ArrayList<Paciente> nuevoPac=new ArrayList<Paciente> ();
        if(Filtro.filtrarFormatoHora(hora)){
            String separado[]=hora.split(":");
            for(int i=0;i<cita.size();i++){
                String hor[]=(cita.get(i).getHora()).split(":");
                if(separado[0].equals(hor[0])&&separado[1].equals(hor[1])){
                    boolean bandera=false;
                    int x=0;
                    while(x<paciente.size()&&bandera==false){
                        if(cita.get(i).getNss().equals(paciente.get(x).getNss())){
                            nuevoPac.add(paciente.get(x));
                            bandera=true;
                        }
                        x++;
                    }
                }
            }
            return nuevoPac;
        }
        return nuevoPac;
    }

    /*Filtra todo los pacientes que tienen la misma fecha de Cita*/
    public static ArrayList<Paciente> filtrarPacientesXdia(String fecha,ArrayList<Cita> cita,ArrayList<Paciente> paciente){
        ArrayList<Paciente> nuevoPac=new ArrayList<Paciente> ();
        if(Filtro.filtrarFormato(fecha)){
            String separado[]=fecha.split("/");
            for(int i=0;i<cita.size();i++){
                String fec[]=(cita.get(i).getFecha()).split("/");
                if(separado[0].equals(fec[0])&&separado[1].equals(fec[1])&&separado[2].equals(fec[2])){
                    boolean bandera=false;
                    int x=0;
                    while(x<paciente.size()&&bandera==false){
                        if(cita.get(i).getNss().equals(paciente.get(x).getNss())){
                            nuevoPac.add(paciente.get(x));
                            bandera=true;
                        }
                        x++;
                    }
                }
            }
            return nuevoPac;
        }
        return nuevoPac;
    }

    /*Filtra todo los Pacientes y Medicos Femeninos o Masculinos y lo regresa en un ArrayList*/
    public static ArrayList filtrarPersonas(ArrayList m,char c){
        ArrayList personas=new ArrayList();

        if(m.get(0) instanceof Paciente){
            ArrayList<Paciente> l=m;
            if(c=='F'){
                for(int i=0;i<m.size();i++){
                    if((l.get(i)).getSexo()=='F'){
                        personas.add(l.get(i));
                    }
                }        
            }else if(c=='M'){
                for(int i=0;i<m.size();i++){
                    if((l.get(i)).getSexo()=='M'){
                        personas.add(l.get(i));
                    }
                }    
            }
        }

        if(m.get(0) instanceof Medico){
            ArrayList<Medico> l=m;
            if(c=='F'){
                for(int i=0;i<m.size();i++){
                    if((l.get(i)).getSexo()=='F'){
                        personas.add(l.get(i));
                    }
                }
            }else if(c=='M'){
                for(int i=0;i<m.size();i++){
                    if((l.get(i)).getSexo()=='M'){
                        personas.add(l.get(i));
                    }
                }
            }

        }

        return personas;
    }

    /*Filtra nombres con X letra, regresa un ArrayList de Medico*/
    public static ArrayList<Medico> filtrarNombresLetrasMedicos(char c, ArrayList<Medico> e){
        ArrayList<Medico> la=new ArrayList<Medico>();
        for(int i=0;i<e.size();i++){
            if((e.get(i)).getNombre().charAt(0)==c){
                la.add(e.get(i));
            }
        }
        return la;
    }

    /*Filtra Pacientes de mayor X de edad y regresa un ArrayList de Paciente*/
    public static ArrayList<Paciente> filtrarMayoresaX(ArrayList<Paciente> a,int n)throws Exception{

        if(n>-1&&n<121){
            ArrayList<Paciente> mayores=new ArrayList<Paciente>();
            for(int i=0;i<a.size();i++){
                if((a.get(i)).getEdad()>n){
                    mayores.add(a.get(i));
                }
            }
            return mayores;

        }else{

            throw new InputMismatchException ();
        }
    }

    /////////////////////////////////////////////////7
    /*Filtra el médico con más Pacientes y recibe en su parámetro dos ArrayList*/
    public static Medico filtraMedicoConMasPacientes(ArrayList<Medico> medico,ArrayList<Cita> cita){
        Medico mayorPaciente=null;
        int numeroMayor=0;
        for(int i=0;i<medico.size();i++){
            int cont=0;
            for(int x=0;x<cita.size();x++){
                if(medico.get(i).getCedula()==cita.get(x).getCedula()){
                    cont++;
                }
            }
            if(numeroMayor<cont){
                numeroMayor=cont;
                mayorPaciente=medico.get(i);
            }
        }
        return mayorPaciente;
    }

    /*Filtra pacientes con un X NSS*/
    public static Paciente filtrarPacienteNss(ArrayList<Paciente> paciente,String nss){
        int x=0;
        Paciente h=null;
        while(x<paciente.size()){
            if(paciente.get(x).getNss().equals(nss)){
                h=paciente.get(x);
            }
            x++;
        }
        return h;
    }

    public static boolean filtrarFormato(String fecha){
        String letra[]=fecha.split("/");
        boolean bandera=false;
        if(fecha.length()>0&&fecha.length()<=10&&letra.length==3){
            bandera=true;
        }
        return bandera;
    }

    public static boolean filtrarFormatoHora(String hora){
        String letra[]=hora.split(":");
        boolean bandera=false;
        if(hora.length()>0&&hora.length()<=5&&letra.length==2){
            bandera=true;
        }
        return bandera;
    }

    public static char filtrarAbecedario(char c){
        char abecedario[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int x=0;
        while(x<abecedario.length){
            if(c==abecedario[x]){
                return c;
            }
            x++;
        }
        return c='0';
    }

    public static boolean filtrarAbecedario(String c){
        char e=c.charAt(0);
        char abecedario[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int x=0;
        boolean bandera=false;
        while(x<abecedario.length&&bandera==false){
            if(e==abecedario[x]){
                bandera=true;
            }
            x++;
        }
        return bandera;
    }

    public static boolean filtrarSexo(String n){
        char s=n.charAt(0);
        char abecedario[]={'F','M'};
        int x=0;
        boolean bandera=false;
        while(x<abecedario.length&&bandera==false){
            if(abecedario[x]==s){
                bandera=true;
            }
            x++;
        }
        return bandera;
    }

    public static boolean filtrarSexo(char n){
        char abecedario[]={'F','M'};
        int x=0;
        boolean bandera=false;
        while(x<abecedario.length&&bandera==false){
            if(abecedario[x]==n){
                bandera=true;
            }
        }
        return bandera;
    }

    public static boolean filtrarNss(String n){
        boolean bandera=false;
        if(n.length()>=1&&n.length()<=10){
            bandera=true;
        }
        return bandera;
    }

    public static boolean filtrarCedula(String n){
        boolean bandera=false;
        if(n.length()<=9&&n.length()>0){
            bandera=true;
        }
        return bandera;
    }

    public static boolean filtrarEdad(int edad)throws Exception{
        boolean bandera=false;
        if(edad!=0){
            if(edad>0&&edad<=120){
                bandera=true;

            }
        }
        return bandera;
    }

    public static boolean filtrarNombreApellidoPM(String n){
        boolean bandera=false;
        if(filtrarAbecedario(n)){
            bandera=true;
        }
        return bandera;
    }

    public static Medico filtrarexistenciaMedico(ArrayList<Medico> medicos,String n,String ap, String am){
        Medico medic=null;
        int x=0;
        while(x<medicos.size()){
            if((medicos.get(x)).getNombre().equals(n)&&(medicos.get(x)).getApaterno().equals(ap)&&(medicos.get(x)).getAmaterno().equals(am)){
                return medic=medicos.get(x);
            }
            x++;
        }
        return medic;
    }
}
