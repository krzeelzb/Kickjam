import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Function {
    int lineCounter=1;
    int caseNumber=0;
    private String N;
    LinkedList<Case> caseList=new LinkedList<>();


    void read(String path){
        try {

            FileWriter fw = new FileWriter("/home/ela/Pulpit/kick/output.txt");
            PrintWriter pw = new PrintWriter(fw);

            Scanner input = new Scanner("/home/ela/Pulpit/kick/tmp.txt");
            File file = new File(input.nextLine());
            input = new Scanner(file);


            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
                if (lineCounter==1){
                    caseNumber=Integer.parseInt(line);
                }
                if (lineCounter%5==2 ){
                    String[] tmp=line.split(" ");
                    int n= Integer.parseInt(tmp[0]);
                    int k= Integer.parseInt(tmp[1]);
                    LinkedList<LinkedList<Integer>> big=new LinkedList<>();
                    for (int j=0;j<4;j++) {
                        LinkedList<Integer> small=new LinkedList<>();
                        if (input.hasNextLine()) {
                            String aLine = input.nextLine();
                            String[] aSplit = aLine.split(" ");
                            for (int i = 0; i < aSplit.length; i++) {
                                small.add(Integer.parseInt(aSplit[i]));
                            }
                            big.add(small);
                        }
                    }
                    lineCounter+=4;
                    caseList.add(new Case(n,k,big));
                }

                lineCounter++;



            }
            int ct=1;
            for (Case c:caseList){
                pw.println("Case #"+ ct++ + ": "+ c.toBinaryChange());
            }
            pw.close();
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void cases(){

    }


}
