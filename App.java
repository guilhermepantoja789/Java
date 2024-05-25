import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int tamanho = input.nextInt();
        int[] vetor = new int[tamanho];
        Mediana med = new Mediana(input, tamanho, vetor);
        med.mediana();
    }
}
