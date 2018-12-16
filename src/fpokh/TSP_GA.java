/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpokh;

import java.io.BufferedWriter;
 import java.io.File;
 import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
 import java.util.Scanner;
 import java.util.logging.Level;
 import java.util.logging.Logger;
 import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author fariz and prema
 */
public class TSP_GA {
    public static void main(String[] args) {        
        long start = System.currentTimeMillis();
        String filepath = "hasil.csv";
        String fileName = "C:\\Users\\fariz\\Desktop\\datasets\\hiddeninstance2.csv";
        File file = new File(fileName); // TODO: read about File Names
        try {
                Scanner inputStream = new Scanner(file);
                //buat array
                int getisi = inputStream.nextInt();
                City city[]=new City[getisi];
                //get size array
                int  index=0;
                //int  isiCity=0;
            while (inputStream.hasNext()){
                String coordinate=inputStream.next();
                String array[]= coordinate.split(",");

                city[index]=new City(Integer.toString(index+1), Integer.parseInt(array[0]),Integer.parseInt(array[1]));

                TourManager.addCity(city[index]);
                //System.out.print(city[index]);
                index++;
            /*    String data = inputStream.next();
                System.out.println(data); */
            //masukin data ke array
            }
            inputStream.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
        // Initialize population
        Population pop = new Population(50, true);
        int awal = pop.getFittest().getDistance();
        Tour TourAwal = null;
        Tour TourAkhir = null;
        TourAwal = pop.getFittest();
        // initialize time
        System.out.println("Initial distance: " + pop.getFittest().getDistance());
        System.out.println("Initial Tour    : " + TourAwal); 
        // Evolve population for 100 generations 
        // diganti untuk menentukan generations dan looping disamakan dengan algoritma ant
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }
        int akhir = pop.getFittest().getDistance();
        TourAkhir = pop.getFittest();
        // Print final results
        System.out.println("Final distance  : " + pop.getFittest().getDistance());
        System.out.println("Best Tour       : " + TourAkhir);
        //System.out.println(); 
        long end = System.currentTimeMillis();
        long hasilwaktu = end-start;
        System.out.println("Build Time "+hasilwaktu+" ms.");
        saveRecord(TourAwal, TourAkhir, awal, akhir, filepath, hasilwaktu);
    }
    
    public static void saveRecord(Tour TourAkhir, Tour TourAwal, int awal, int akhir, String filepath, long hasilwaktu){
        try{
            FileWriter fw = new FileWriter(filepath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.println("----------HASIL CSV GENETIC ALGORITHM----------");
            pw.println("Initial Tour     : "+TourAwal);
            pw.println("Initial Distance : "+awal);
            pw.println("Best Tour        : "+TourAkhir);
            pw.println("Final Distance   : "+akhir);
            pw.println("Build Time       : "+hasilwaktu);
            pw.println("----------HASIL CSV GENETIC ALGORITHM----------");
            pw.println(" ");
            pw.flush();
            pw.close();
        }
        catch(Exception E){
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        }
    }
    
}