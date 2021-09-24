package edu.problems.code;


import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Gene {
    private static String geneStr;
    public Gene(String geneStr) {
    }
/*
   Summary:
   GENES are commonly represented in computer software as a sequence of characters A, C, G, T.
   Each letter represents a NUCLEOTIDE, and the combination of 3 NUCLEOTIDES is called a CODON.
   A CODON codes for a specific amino acid that together with other amino acids can form a protein.
   Our task is to find a particular CODON within a GENE.
*/


    public static void main(String[] args) {
        geneStr = "ACGTGGCTCTCTAACGTACGTACGTACGGGGTTTATATATACCCTAGGACTCCCTTT";

        Gene myGene = new Gene(geneStr);
        Codon acg = new Codon("ACG");
        Codon gat = new Codon("GAT");

        System.out.println(myGene.linearContains(acg));
        System.out.println(myGene.linearContains(gat));

        System.out.println(myGene.binaryContains(acg));
        System.out.println(myGene.binaryContains(gat));
    }


    private boolean linearContains(Codon acg) {
        Codon codon;
        for (int i = 0; i < geneStr.length(); i+=3) {
            codon = new Codon(geneStr.substring(i,i+3));
            if(codon.compareTo(acg) == 0)
                return true;
        }
        return false;
    }

    private boolean binaryContains(Codon acg) {
        Set<Codon> codonTree = new TreeSet<>();
        for (int i = 0; i < geneStr.length(); i+=3) {
            codonTree.add(new Codon(geneStr.substring(i,i+3)));
        }
        return codonTree.contains(acg);
    }

}

class Codon implements Comparable<Codon> {

    private String fn;
    private String sn;
    private String tn;
    static Comparator<Codon> comparator = Comparator.comparing((Codon c) -> c.fn).
            thenComparing((Codon c) -> c.sn).
            thenComparing((Codon c) -> c.tn);

    public Codon(String nucleotides){
        this.fn = nucleotides.substring(0,1);
        this.sn = nucleotides.substring(1,2);
        this.tn = nucleotides.substring(2,3);
    }

    @Override
    public int compareTo(Codon other) {
        return comparator.compare(this, other);
    }
}

