import java.io.*;
import javax.swing.JOptionPane;
import java.util.*;
public class Prueba
{
    private static ArrayList<String> nombresH=new ArrayList<String>();
    private static ArrayList<String> nombresM=new ArrayList<String>();
    private static ArrayList<String> Apellidos=new ArrayList<String>();
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        try{
            Lectura.leerArchivo("NombresH.txt",nombresH);
            Lectura.leerArchivo("NombresM.txt", nombresM);
            Lectura.leerArchivo("Apellidos.txt", Apellidos);
        }catch(FileNotFoundException e){
            JOptionPane.showInternalMessageDialog(null, "Archivo no encontrado");
        }catch(Exception e){
            System.out.print(e.toString());
        }
        menu();
    }

    public static void menu(){
        try{
            ArrayList<Medico> medicos=Lectura.crearMedicos(nombresH,nombresM,Apellidos, Apellidos);
            ArrayList<Paciente> pacientes=Lectura.crearPacientes(nombresH,nombresM,Apellidos, Apellidos);
            ArrayList<Paciente> mujpacientes=Filtro.filtrarPersonas(pacientes, 'F');
            ArrayList<Paciente> hompacientes=Filtro.filtrarPersonas(pacientes, 'M');
            ArrayList<Medico> mujMedicos=Filtro.filtrarPersonas(medicos,'F');
            ArrayList<Medico> homMedicos=Filtro.filtrarPersonas(medicos,'M');
            ArrayList<Cita> citas=Lectura.crearCitas(pacientes, medicos);
            int x=0;
            while(x!=14){
                try{
                    int numero=Lectura.leerEnteroPositivo(Integer.parseInt(JOptionPane.showInputDialog("                                           MENÚ\nPara elegir una opción, "
                                    +"ingresa el número que les corresponde:\n1.- Listar mujeres mayores de (?) edad\n2.- Listar hombres mayores de (?) edad\n3.- Listar médicos Hombres"+
                                    "\n4.- Listar médicos Mujeres\n5.- Listar pacientes que tuvieron cita un dia (?)\n6.- Listar pacientes que tuvieron cita una hora (?)\n7.- "+
                                    "Listar pacientes del médico(nombre)\n8.- Buscar paciente con número NSS\n9.- Listar médicos que su nombre empiece con la letra(?)\n10.- "+
                                    "Encontrar el médico que tiene más pacientes\n11.- Agregar paciente\n12.- Agregar médico\n13.- Agregar cita\n14.- Salir")));
                    switch(numero){
                        case 1:
                            {
                                
                                try{
                                    int n=Lectura.leerEnteroPositivo();
                                    ArrayList<Paciente> p=Filtro.filtrarMayoresaX(mujpacientes, n);
                                    if(p.size()!=0){
                                    Lectura.imprimirElementosMedicoPacienteCita(p);
                                    }else{
                                    JOptionPane.showMessageDialog(null, "No está registrado esa edad.");
                                    }
                                        
                                }catch(NumberFormatException e){
                                    JOptionPane.showMessageDialog(null, "Porfavor ingresa un numero.");
                                }catch(IllegalArgumentException e){
                                    JOptionPane.showMessageDialog(null, "Porfavor ingresa un numero positivo.");
                                }catch(InputMismatchException e){
                                    JOptionPane.showMessageDialog(null, "Por cuentiones técnicas existe límete de 120 años.");
                                }
                                catch(Exception e){
                                    JOptionPane.showMessageDialog(null, "Error");
                                }

                            }
                            break;
                        case 2:
                            {   try{
                                    int n=Lectura.leerEnteroPositivo();
                                    ArrayList<Paciente> p=Filtro.filtrarMayoresaX(hompacientes, n);
                                    if(p.size()!=0){
                                     Lectura.imprimirElementosMedicoPacienteCita(p);
                                    }else{
                                    JOptionPane.showMessageDialog(null, "No está registrado esa edad.");
                                    }
                                       
                                }catch(NumberFormatException e){
                                    JOptionPane.showMessageDialog(null, "Porfavor ingresa un numero.");
                                }catch(IllegalArgumentException e){
                                    JOptionPane.showMessageDialog(null, "Porfavor ingresa un numero positivo.");
                                }catch(InputMismatchException e){
                                    JOptionPane.showMessageDialog(null, "Por cuentiones técnicas existe límete de 120 años.");
                                }
                                catch(Exception e){
                                    JOptionPane.showMessageDialog(null, "Error");
                                }
                            }
                            break;
                        case 3:
                            {
                                Lectura.imprimirElementosMedicoPacienteCita(homMedicos);
                            }
                            break;
                        case 4:
                            {
                                Lectura.imprimirElementosMedicoPacienteCita(mujMedicos);              
                            }
                            break;
                        case 5:
                            {   
                                Lectura.imprimirFechasCitas(citas);
                                String fe=JOptionPane.showInputDialog("Ingresa la fecha con el siguiente formato: DD/MM/YY");
                                ArrayList<Paciente> p=Filtro.filtrarPacientesXdia(fe, citas, pacientes);
                                if(p.size()!=0){
                                    Lectura.imprimirElementosMedicoPacienteCita(p);
                                }else{
                                    JOptionPane.showMessageDialog(null, "No encontró a ningún paciente con ese dia.");
                                }
                            }

                            break;
                        case 6:
                            {
                                Lectura.imprimirHoraCitas(citas);
                                String hora=JOptionPane.showInputDialog("Ingresa la hora con el siguiente formato: ##:##");
                                ArrayList<Paciente> p=Filtro.filtrarPacientesXhora(hora, citas, pacientes);
                                if(p.size()!=0){
                                    Lectura.imprimirElementosMedicoPacienteCita(p);
                                }else{
                                    JOptionPane.showMessageDialog(null, "No encontró a ningún paciente con ese dia.");
                                }
                            }
                            break;
                        case 7:
                            {
                                try{
                                Lectura.imprimirNombres(medicos);
                                String n=JOptionPane.showInputDialog("Ingresa el nombre del médico:");
                                String ap=JOptionPane.showInputDialog("Ingresa el apellido paterno del médico:");
                                String am=JOptionPane.showInputDialog("Ingresa el apellido materno del médico:");
                                ArrayList<Paciente> s=Filtro.filtrarPacientesDeMedico(n, ap, am, Filtro.filtrarexistenciaMedico(medicos,n, ap, am), citas, pacientes);
                                if(s.size()!=0){
                                    Lectura.imprimirElementosMedicoPacienteCita(s);
                                }else{
                                    JOptionPane.showMessageDialog(null, "El médico no cuenta con pacientes aún.");
                                }
                                
                                }catch(NullPointerException e){
                                 JOptionPane.showMessageDialog(null, "No existe, no está registrado el médico.");
                                }
                            }
                            break;
                        case 8:
                            {
                                String palabra=JOptionPane.showInputDialog("Ingresa el NSS:");
                                Paciente p=Filtro.filtrarPacienteNss(pacientes, palabra);
                                if(p!=null){
                                    Lectura.imprimirElementosPaciente(p);
                                }else{
                                    JOptionPane.showMessageDialog(null, "No lo encontró.");
                                }
                            }
                            break;
                        case 9:
                            {
                                try{
                                String letra=JOptionPane.showInputDialog("Ingresa una letra Mayúscula:");
                                char primerCaracter = letra.charAt(0);
                                if(Filtro.filtrarAbecedario(primerCaracter)!='0'){

                                    ArrayList<Medico> m=Filtro.filtrarNombresLetrasMedicos(Filtro.filtrarAbecedario(primerCaracter),medicos);
                                    if(m.size()!=0){
                                        Lectura.imprimirElementosMedicoPacienteCita(m);
                                    }else{
                                        JOptionPane.showMessageDialog(null,"No encontró.");
                                    } 
                                }else{
                                    JOptionPane.showMessageDialog(null,"Porfavor ingresa una letra Mayúscula.");
                                }
                                }catch(StringIndexOutOfBoundsException e){
                                JOptionPane.showMessageDialog(null,"Porfavor ingresa una letra Mayúscula.");
                                }
                            }
                            break;
                        case 10:
                            {
                                Lectura.imprimirElementosMedico(Filtro.filtraMedicoConMasPacientes(medicos,citas));
                            }
                            break;
                        case 11:
                            {
                                String n,p,m;
                                n=JOptionPane.showInputDialog("Ingresa un nombre: ");
                                p=JOptionPane.showInputDialog("Ingresa un apellido paterno: ");
                                m=JOptionPane.showInputDialog("Ingresa un apellido materno: ");
                                if(Filtro.filtrarNombreApellidoPM(n)&&Filtro.filtrarNombreApellidoPM(p)&&Filtro.filtrarNombreApellidoPM(m)){
                                    String s=JOptionPane.showInputDialog("Ingresa F (Femenino) ó M (Masculino): ");
                                    if(Filtro.filtrarSexo(s)==true){
                                        String nss=JOptionPane.showInputDialog("Ingresa nss entre 1 a 10 dígitos: ");
                                        if(Filtro.filtrarNss(nss)&&!Lectura.validarNss(citas, nss)) {
                                            JOptionPane.showMessageDialog(null,"Ingresa tu edad:");
                                            int e=Lectura.leerEnteroPositivo();
                                            if(Filtro.filtrarEdad(e)){
                                                char sex=s.charAt(0);
                                                Paciente g= new Paciente(n, p,m, sex,nss,e);
                                                pacientes.add(g);
                                                if(g.getSexo()=='F'){
                                                mujpacientes.add(g);
                                                JOptionPane.showMessageDialog(null,"Se ingresaron los datos exitosamente.");
                                                }
                                                
                                                 if(g.getSexo()=='M'){
                                                 hompacientes.add(g);
                                                JOptionPane.showMessageDialog(null,"Se ingresaron los datos exitosamente.");
                                                }
                                                
                                            }else{
                                                JOptionPane.showMessageDialog(null,"Porfavor verifica tu edad.");
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null,"Es posible que te hayas pasado de límite permitido o el NSS"+"\n"+
                                                "que ingresaste ya existe, porfavor verifique...");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Porfavor F (Femenino) o M (Masculino)");
                                    }

                                }else{
                                    JOptionPane.showMessageDialog(null,"Lo siento, es necesario escribir correctamente tu nombre o apellidos.");  
                                }

                            }
                            break;
                        case 12:
                            {
                                String n,p,m;
                                n=JOptionPane.showInputDialog("Ingresa un nombre: ");
                                p=JOptionPane.showInputDialog("Ingresa un apellido paterno: ");
                                m=JOptionPane.showInputDialog("Ingresa un apellido materno: ");
                                if(Filtro.filtrarNombreApellidoPM(n)&&Filtro.filtrarNombreApellidoPM(p)&&Filtro.filtrarNombreApellidoPM(m)){
                                    String s=JOptionPane.showInputDialog("Ingresa F (Femenino) ó M (Masculino): ");
                                    if(Filtro.filtrarSexo(s)==true){
                                        String ced=JOptionPane.showInputDialog("Ingresa una cédula entre 1 a 9 dígitos: ");
                                        if(Filtro.filtrarCedula(ced)&&!Lectura.validarCedula(medicos, ced)) {
                                            char sex=s.charAt(0);
                                            Medico g=new Medico(n,p,m,sex,ced);
                                            medicos.add(g);
                                            if(g.getSexo()=='F'){
                                             mujMedicos.add(g);
                                            JOptionPane.showMessageDialog(null,"Se ingresaron los datos exitosamente.");
                                            }else 
                                            if(g.getSexo()=='M'){
                                            homMedicos.add(g);
                                            JOptionPane.showMessageDialog(null,"Se ingresaron los datos exitosamente.");
                                            }
                                            

                                        }else{
                                            JOptionPane.showMessageDialog(null,"Es posible que te hayas pasado de límite permitido para la cédula"+"\n"+
                                                "ó ingresaste uno ya existente, porfavor verifique...");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Porfavor F (Femenino) o M (Masculino)");
                                    }

                                }else{
                                    JOptionPane.showMessageDialog(null,"Lo siento, es necesario escribir correctamente tu nombre o apellidos.");  
                                }

                            }

                            break;
                        case 13:
                            {
                             String n,p,m,f;
                                n=JOptionPane.showInputDialog("Ingresa la Fecha: ");
                                if(Filtro.filtrarFormato(n)&&!Lectura.validarFecha(citas, n)){
                                p=JOptionPane.showInputDialog("Ingresa una NSS: ");
                                   if(Filtro.filtrarNss(p)&&Lectura.validarNssPaciente(pacientes,p)){
                                    m=JOptionPane.showInputDialog("Ingresa una Cedula: ");
                                    if(Filtro.filtrarCedula(m)&&Lectura.validarCedula(medicos, m)){
                                    
                                    f=JOptionPane.showInputDialog("Ingresa una Hora: ");
                                    if(Filtro.filtrarFormatoHora(f)&&!Lectura.validarHora(citas, f)){
                                    citas.add(new Cita(n,p,m,f));
                                    JOptionPane.showMessageDialog(null,"Se agregó correctamente la Cita.");
                                    }else{
                                    JOptionPane.showMessageDialog(null,"Porfavor verifica la Hora.");
                                    
                                    }
                                    }else{
                                    JOptionPane.showMessageDialog(null,"Porfavor verifica tu Cédula.");
                                    }
                                    
                                    
                                    }else{
                                    JOptionPane.showMessageDialog(null,"Porfavor verifica tu NSS.");
                                    }
                                
                                }else{
                                 JOptionPane.showMessageDialog(null,"Porfavor verifica tu fecha.");
                                
                                }
                                
                            }
                            break;
                        case 14:
                            x=14;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Porfavor acate las instrucciones ;)");
                            break;
                    }
                }catch(InputMismatchException e){
                    JOptionPane.showMessageDialog(null,"Se acepta números.");
                }catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null,"Introduzca el numero que se le está pidiendo");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null,"No se puede crear Medico, Paciente o Citas, posiblemente eliminastes algo fundamental...");
        }catch(ClassCastException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Hay un problema.");
        }
    }
}
