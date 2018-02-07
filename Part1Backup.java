/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;

/**
 * Write a description of EmpiezaCero2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1Backup {
    public int findStopCodon ( String dnaStr, int startIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, startIndex);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 ==0 ) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex+1);
            }
        }
        return dnaStr.length();
    }
    
    public String findGene(String dna, int where) {
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");
        int temp = Math.min(taaIndex,tagIndex);
        int minIndex = Math.min(temp, tgaIndex);
        if(minIndex == dna.length()){
            return "";
        }
        return dna.substring(startIndex, minIndex + 3);
    }
    public void printAllGenes(String dna){
        int startIndex = 0;
        while (true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            System.out.println(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
        }
    }
    
    public StorageResource getAllGenes(String dna){
        StorageResource geneList = new StorageResource();
        int startIndex = 0;
        while (true){
            String currentGene = findGene(dna, startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            geneList.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
        }
        return geneList;
    }
    public void testOn(String dna){
        System.out.println("testing printallgenes on "+dna);
        StorageResource genes = getAllGenes(dna);
        for (String gene : genes.data()){
            System.out.println("This is the list of genes: "+ gene);
        }
            
        }
        
     public void testProcessGenes(){
        processGenes(CreationofSR());
    }
     
    public StorageResource CreationofSR(){
        StorageResource sr = new StorageResource();
        sr.add("ATGCCCCGGTAA");
        sr.add("ATGCCCGGGTTTTTTTTTTTTTTTTAA");
        sr.add("ATGTTTTTTTTTTTTTTTTAA");
        for(String s : sr.data()){
            System.out.println("this is my list of genes: " + s);
        }
        return sr;
    }
    
    public StorageResource srIsFile(){
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        String Newdna = dna.toUpperCase();
        System.out.println(Newdna);
        StorageResource sr = new StorageResource();
        int startIndex = 0;
        while (true){
            String currentGene = findGene(Newdna, startIndex);
            if (currentGene.isEmpty()){
                System.out.println("Not ffound");
                break;

            }
            sr.add(currentGene);
            startIndex = Newdna.indexOf(currentGene, startIndex) + 
                         currentGene.length();
           }
           int count = 0;
           for (String gene9 : sr.data()){
           
                count = count + 1;
            
        }
        System.out.println("this file has this genes: " + count);
        
        return sr;
    }
    
    public void processGenes2(StorageResource sr){
        for (String getGenes : sr.data()){
            /*while (longer60.length() > 60) {
                if (takeString.length() == -1){
                    break;
                }
                
            }
            System.out.println(takeString+ " length = " + takeString.length() );
            takeString = longer60.substring(takeString.length(),60);*/
            }
        }
    
    
    public void testProcessGenes2(){
        processGenes(srIsFile());
    }
    
       public void processGenes(StorageResource sr){
        int count = 0;
        int counting = 0;
        System.out.println("Printing genes with +60 charas:");
        for (String gene60 : sr.data()){
            if (gene60.length() > 60){
                System.out.println(gene60);
            }
        }
        for (String plus9 : sr.data()){
          if (plus9.length() > 60){
              count = count +1;
            }
        }
        System.out.println("Printing number of strings above: " + count);
        for (String cgRat : sr.data()){
           cgRatio(cgRat);
            if (cgRatio(cgRat) > 0.35){
               System.out.println("Gene with C-G ratio higher than 0.35 = " + cgRat + " and the ratio is: "+ cgRatio(cgRat));
               count = count +1;
            }
        }
        System.out.println("Genes with cgRatio greater than 0.35: " +count);
        for (String longest : sr.data()){
            if (longest.length() > counting){
                counting = longest.length();
            }
        }
        System.out.println("Length of the longest gene= " + counting);
        
    }
    
    
    public float cgRatio (String dna){
        int firstOccurC = dna.indexOf("C");
        int firstOccurG = dna.indexOf("G");
        int countC = 0;
        int countG = 0;
        if (firstOccurC > -1) {
            countC = countC+1;
            while (dna.indexOf("C", firstOccurC) != -1 && firstOccurC !=-1){
                countC = countC + 1;
                firstOccurC = dna.indexOf("C", firstOccurC + 1);
            }
            countC = countC - 1;
        }
        else {
            countC = 0;
        }
        if (firstOccurG > -1) {
            countG = countG+1;
            while (dna.indexOf("G", firstOccurG) != -1 && firstOccurG !=-1){
                countG = countG + 1;
                firstOccurG = dna.indexOf("G", firstOccurG + 1);
            }
            countG = countG - 1;
        }
        else {
            countG = 0;
        }
        //System.out.println(countC +" y "+ countG);
        float Finalresult = (float)countC / countG;
        return Finalresult;
    }
    
    public void testcgRatio(){
        String dna="CCCCAAGCCC";
        System.out.println("Result of all should be 7 and is: "+cgRatio(dna));
        dna="CCCGGGGGAAAGGG";
        System.out.println("Number of all should be 0.37 and is: "+cgRatio(dna));
        dna = "AAACCCCAAGG";
        System.out.println("Number of all should be 2 and is: "+cgRatio(dna));
    }
    public void test(){
        //      ATGv  TAAV  ATGvvv      TGA
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
    public void testFindStop(){
       String dna = "xxxyyyzzzTAAAxxxyyyzzzTAAxx";
       int dex = findStopCodon(dna,0,"TAA");
       if (dex!=10) System.out.println("error on 9");
       System.out.println("test finished");
    }
    
}
