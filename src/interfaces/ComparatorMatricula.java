/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Comparator;
import vehiculo.Vehiculo;

/**
 *
 * @author irene
 */
public class ComparatorMatricula implements Comparator<Vehiculo>{

    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        String mat1 = o1.getMatricula().substring(3);
        String mat2 = o1.getMatricula().substring(3);
       
        if(mat1.equalsIgnoreCase(mat2)){
            return o1.getMatricula().compareTo(o2.getMatricula());
        }
        return mat1.compareTo(mat2);
    }

   
    
}
