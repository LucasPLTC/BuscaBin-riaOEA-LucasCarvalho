package cep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public class BinaryBSC {
    static int loop = 0;
    
       
    
    public static void main(String args[])
    {
        String Filename;
        
        Filename = "cep_ordenado.dat";
        String Busc = JOptionPane.showInputDialog(null, "CEP", "Insira o CEP",0);
        try{
            RandomAccessFile C = new RandomAccessFile("cep_ordenado.dat","r");
            Cep lin = new Cep();
            long top = 0;
            long bot = ((C.length()/300)-1);
            long mid = 0;
                while(top<=bot){
                    loop++;
                    mid = ((top+bot)/2);
                    C.seek(mid*300);
                    lin.leEndereco(C);
                        if(Integer.parseInt(lin.getCep())==Integer.parseInt(Busc)){
                            System.out.println(lin.getLogradouro());
                            System.out.println(lin.getBairro());
                            System.out.println(lin.getCidade());
                            System.out.println(lin.getEstado());
                            System.out.println(lin.getSigla());
                            System.out.println(lin.getCep());
                            System.out.println(loop);
                            break;
                        }else if(Integer.parseInt(lin.getCep())>Integer.parseInt(Busc)){
                                 bot = mid-1;
                        }else if(Integer.parseInt(lin.getCep())<Integer.parseInt(Busc)){
                                 top = mid+1;
                        }
                }
        }
        catch(Exception e){
            System.out.println("SE FODEO");
            
        }
    }
}
