import java.util.Vector;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
public class Lectura
{
    /*Regresa un entero. */
    public static int leerEntero()throws Exception{
        int num=Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero:"));
        return num;
    }

    /*Regresa un entero positivo, */
    public static int leerEnteroPositivo()throws Exception{
        int num=Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero:"));
        if(num>0){
            return num;
        }else{
            throw new IllegalArgumentException();
        }
    }

    
    public static int leerEnteroPositivo(int n)throws Exception{
        if(n>0){
            return n;
        }else{
            throw new IllegalArgumentException();
        }
    }
    

    /*Regresa un entero negativo, si regresa un 0 no es negativo.*/
    public static int leerEnteroNegativo()throws Exception{
        int num=Integer.parseInt(JOptionPane.showInputDialog("Ingresa un numero:"));
        if(num<0){
            return num;
        }else{
            throw new IllegalArgumentException();
        }
    }

    /*Lee un archivo y lo integra dentro de un ArrayList, en su parámetro recibe el nombre del archivo y el objeto del ArrayList.*/
    public static void leerArchivo(String n,ArrayList s)throws IOException {
        BufferedReader lectorbuf=new BufferedReader(new FileReader(new File(n)));
        String nombre;
        int x=0;
        while((nombre=lectorbuf.readLine())!=null){
            s.add(x, nombre);
            x++;
        }
    }

    /*Crea Medico, regresa un ArrayList de Medicos*/
    public static ArrayList crearMedicos(ArrayList<String> nomH,ArrayList<String> nomM,ArrayList<String> ap, ArrayList<String> am)throws Exception{
        ArrayList<Medico> medicos=new ArrayList<Medico>();

        for(int i=0; i<100;i+=2){
            String cedula=(int)(Math.random()*500)+1+""+""+(int)(Math.random()*500)+1+""+""+(int)(Math.random()*500)+1;
            medicos.add(new Medico(nomH.get((int)(Math.random()*99)),ap.get((int)(Math.random()*99)),am.get((int)(Math.random()*99)),'M',cedula));
            cedula=(int)(Math.random()*500)+1+""+""+(int)(Math.random()*500)+1+""+""+(int)(Math.random()*500)+1;
            medicos.add(new Medico(nomM.get((int)(Math.random()*99)),ap.get((int)(Math.random()*99)),am.get((int)(Math.random()*99)),'F',cedula));
        }
        return medicos;
    }

    
    public static Medico crearMedicos(String nm,String ap,String am,char s,String ced)throws Exception{
        if(Filtro.filtrarNombreApellidoPM(nm)&&Filtro.filtrarNombreApellidoPM(ap)&&Filtro.filtrarNombreApellidoPM(am)&&Filtro.filtrarSexo(s)&&Filtro.filtrarCedula(ced)){
            return new Medico(nm,ap,am,s,ced);
        }else{
            return null;
        }
    }

    /*Crea Paciente y regresa un ArrayList de Pacientes*/
    public static ArrayList crearPacientes(ArrayList nomH,ArrayList nomM,ArrayList ap, ArrayList am)throws Exception{
        ArrayList<Paciente> pacientes=new ArrayList<Paciente>();

        for(int i=0; i<200;i+=2){
            String nss=(int)(Math.random()*1000)+1+""+""+(int)(Math.random()*500)+1+""+""+(int)(Math.random()*500)+1;
            pacientes.add(new Paciente((String)nomH.get((int)(Math.random()*99)),(String)ap.get((int)(Math.random()*99)),(String)am.get((int)(Math.random()*99)),'M',nss,(int)(Math.random()*99)+1));
            nss=(int)(Math.random()*1000)+1+""+""+(int)(Math.random()*500)+1+""+""+(int)(Math.random()*500)+1;
            pacientes.add(new Paciente((String)nomM.get((int)(Math.random()*99)),(String)ap.get((int)(Math.random()*99)),(String)am.get((int)(Math.random()*99)),'F',nss,(int)(Math.random()*99)+1));
        }
        return pacientes;
    }

    
    public static Paciente crearPaciente(String nom,String ap,String am,char sex,String nss,int ed) throws Exception {
        if(Filtro.filtrarNombreApellidoPM(nom)&&Filtro.filtrarNombreApellidoPM(ap)&&Filtro.filtrarNombreApellidoPM(am)&&Filtro.filtrarSexo(sex)&&Filtro.filtrarNss(nss)&&Filtro.filtrarEdad(ed)){
            Paciente s=new Paciente(nom,ap,am,sex,nss,ed);
            return s;
        }else{
            return null;
        }

    }

    /*Crea Cita y regresa un ArrayList de Citas*/
    public static ArrayList crearCitas(ArrayList<Paciente> pac, ArrayList<Medico> med)throws Exception{
        ArrayList<Cita> cita=new ArrayList<Cita>();
        Date d=new Date();
        d.setYear(2024);
        for(int i=0;i<200;i++){
            String fecha=((int)(Math.random()*28)+1)+"/"+((int)(Math.random()*12)+1)+"/"+d.getYear();
            String hora=(int)(Math.random()*23)+":"+(int)(Math.random()*59);
            cita.add(new Cita(fecha,pac.get((int)(Math.random()*(pac.size()-1))+1).getNss(),med.get((int)(Math.random()*(med.size()-1))+1).getCedula(),hora));
        }
        return cita;
    }

    public static void crearCitas(){
    
    }

    /*Imprime todo sus datos de Medicos, Pacientes y citas*/
    public static void imprimirElementosMedicoPacienteCita(ArrayList a){
        if(a.get(0) instanceof Medico){
            ArrayList<Medico> b=a;
            String[] palabra=new String[b.size()];
            for(int i=0;i<b.size();i++){
                palabra[i]="Nombre: "+b.get(i).getNombre()+" "+b.get(i).getApaterno()+" "+b.get(i).getAmaterno()+" Género: "+b.get(i).getSexo()+" Cedula: "+b.get(i).getCedula();
            }
            JOptionPane.showMessageDialog(null,palabra);
        }

        if(a.get(0) instanceof Paciente){
            ArrayList<Paciente> b=a;
            String[] palabra=new String[a.size()];
            for(int i=0;i<b.size();i++){
                palabra[i]="Nombre: "+b.get(i).getNombre()+" "+b.get(i).getApaterno()+" "+b.get(i).getAmaterno()+" Género: "+b.get(i).getSexo()+" Número de seguro:"+b.get(i).getNss()+" Edad: "+b.get(i).getEdad();
            }
            JOptionPane.showMessageDialog(null,palabra);
        }

        if(a.get(0) instanceof Cita){
            ArrayList<Cita> b=a;
            String[] palabra=new String[a.size()];
            for(int i=0;i<b.size();i++){
                palabra[i]="Fecha: "+b.get(i).getFecha()+" Número de seguro: "+b.get(i).getNss()+" Cédula: "+b.get(i).getCedula()+" Hora: "+b.get(i).getHora();
            }
            JOptionPane.showMessageDialog(null,palabra);

        }
    }

    
    public static void imprimirFechasCitas(ArrayList<Cita> citas){
        String[] palabra=new String[citas.size()];
        for(int i=0;i<citas.size();i++){
            palabra[i]=citas.get(i).getFecha();
        }
        JOptionPane.showMessageDialog(null,palabra);
    }

    
    public static void imprimirHoraCitas(ArrayList<Cita> citas){
        String[] palabra=new String[citas.size()];
        for(int i=0;i<citas.size();i++){
            palabra[i]=citas.get(i).getHora();
        }
        JOptionPane.showMessageDialog(null,palabra);
    }

    /*Imprime datos de un Medico*/
    public static void imprimirElementosMedico(Medico a){
        String palabra="Nombre: "+a.getNombre()+" "+a.getApaterno()+" "+a.getAmaterno()+" Género: "+a.getSexo()+" Cédula: "
            +a.getCedula();
        JOptionPane.showMessageDialog(null,palabra);
    }

    /*Imprime todo sus datos de un Paciente*/
    public static void imprimirElementosPaciente(Paciente p){
        String palabra="Nombre: "+p.getNombre()+" "+p.getApaterno()+" "+p.getAmaterno()+" Género: "+p.getSexo()+" Número de seguro: "+p.getNss()+" Edad: "+p.getEdad();
        JOptionPane.showMessageDialog(null,palabra);
    }

    /*Imprime solamente los nombres de Medicos o Pacientes*/
    public static void imprimirNombres(ArrayList persona){
        if(persona.get(0) instanceof Paciente){
            ArrayList<Paciente> p=persona;
            String[] palabra=new String[p.size()];
            for(int i=0;i<p.size();i++){
                palabra[i]=p.get(i).getNombre()+" "+p.get(i).getApaterno()+" "+p.get(i).getAmaterno();
            }
            JOptionPane.showMessageDialog(null,palabra);
        }
        if(persona.get(0) instanceof Medico){
            ArrayList<Medico> p=persona;
            String[] palabra=new String[p.size()];
            for(int i=0;i<p.size();i++){
                palabra[i]=p.get(i).getNombre()+" "+p.get(i).getApaterno()+" "+p.get(i).getAmaterno();
            }
            JOptionPane.showMessageDialog(null,palabra);
        }
    }

    /*Busca si está registrado el NSS en citas*/
    public static boolean validarNss(ArrayList<Cita> citas,String preNss){
        boolean bandera=false;
        int x=0;
        while(x<citas.size()&&bandera==false){
            if(citas.get(x).getNss().equals(preNss)){
                bandera=true;
            }
            x++;
        }
        return bandera;
    }
    
    public static boolean validarNssPaciente(ArrayList<Paciente> pacientes,String Nss){
        boolean bandera=false;
        int x=0;
        while(x<pacientes.size()&&bandera==false){
            if(pacientes.get(x).getNss().equals(Nss)){
                bandera=true;
            }
            x++;
        }
        return bandera;
    }
    
    public static boolean validarCedula(ArrayList<Medico> e,String ced){
    boolean bandera=false;
        int x=0;
        while(x<e.size()&&bandera==false){
            if(e.get(x).getCedula().equals(ced)){
                bandera=true;
            }
            x++;
        }
        return bandera;
    
    }
    
    public static boolean validarFecha(ArrayList<Cita> citas,String fecha){
    boolean bandera=false;
    int x=0;
    while(x<citas.size()&&bandera==false){
    if((citas.get(x)).getFecha().equals(fecha)){
    bandera=true;
    }
    x++;
    }
    return bandera;
    }
    
    public static boolean validarHora(ArrayList<Cita> citas,String hora){
    boolean bandera=false;
    int x=0;
    while(x<citas.size()&&bandera==false){
    if((citas.get(x)).getHora().equals(hora)){
    bandera=true;
    }
    x++;
    }
    return bandera;
    }
}
