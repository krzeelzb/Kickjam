import java.util.LinkedList;

public class Case {
    int N;
    int K;

    LinkedList<LinkedList<Integer>> robots=new LinkedList<>();

    public Case(int n, int k, LinkedList<LinkedList<Integer>> robots) {
        N = n;
        K = k;
        this.robots = robots;
    }

    LinkedList<LinkedList<Integer>> toCheck=new LinkedList<>();


    public int toBinaryChange(){
        int numberOfCase=0;
        for(int i=0;i<robots.get(i).size();i++){
            for (int j=0;j<robots.get(i).size();j++) {
                for (int k=0;k<robots.get(i).size();k++) {
                    for (int l=0;l<robots.get(i).size();l++) {
                        LinkedList<Integer> tmp=new LinkedList<>();
                        tmp.add(i);
                        tmp.add(j);
                        tmp.add(k);
                        tmp.add(l);
                        toCheck.add(tmp);

                    }
                }
            }

        }


        for (LinkedList<Integer> el:toCheck){

            int result=robots.get(0).get(el.get(0))^robots.get(1).get(el.get(1))^robots.get(2).get(el.get(2))^robots.get(3).get(el.get(3));
            if (result==K){
                numberOfCase++;
            }
        }

        return numberOfCase;
    }
}