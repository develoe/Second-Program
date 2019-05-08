package math;

public class MathAurelVlaicu{

    public static void binary(int number){
        int cont[] = new int[100];

        int i = 0;
        while (number>0){
            cont[i] = number%2;
            i++;
            number=number/2;
        }
        for (int j =i-1;j>=0;j--){
            System.out.println();
            System.out.print(cont[j]);
        }
    }


}
