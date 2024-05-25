import java.util.Scanner;

public class Mediana {
    private int mP, mP1, mP2, tamanho;
    private int[] vetor;

    public int getTamanho(){
        return this.tamanho;
    }
    public void setTamanho(int tamanho){
        this.tamanho = tamanho;
    }
    public int[] getVetor(){
        return this.vetor;
    }
    public void setVetor(int[] v){
        this.vetor = v;
    }
    public int getMP(){
        return this.mP;
    }
    public void setMP(int MP){
        this.mP = MP;
    }

    public int getMP1(){
        return this.mP1;
    }
    public void setMP1(int MP){
        this.mP1 = MP;
    }

    public int getMP2(){
        return this.mP2;
    }
    public void setMP2(int MP){
        this.mP2 = MP;
    }

    Mediana(Scanner input, int tamanho, int[] vetor){
        for(int i = 0; i < tamanho; i++){
            vetor[i] = input.nextInt();
        }
        this.setVetor(vetor);
        this.setTamanho(tamanho);
        input.close();
    }

    Mediana(int[] vetor){
        this.setVetor(vetor);
        this.setTamanho(vetor.length);
    }

    public float mediana(){
        int tamanho = this.getTamanho();
        int[] vetor = this.getVetor();
        for(int i = 0; i < tamanho; i++){
            int qntdNumero = 1;
            int qntdMaiorQue = 0;
            for(int j = 0; j < tamanho; j++){
                if(i == j){}
                else{
                    if(vetor[i] == vetor[j]){
                        qntdNumero++;
                    }
                    else{
                        if(vetor[i] > vetor[j]){
                            qntdMaiorQue++;
                        }
                        else{}
                    }
                }
            }
            int posInicial = qntdMaiorQue;
            int posFinal = qntdNumero + posInicial - 1;
            if(this.getTamanho() % 2 != 0){
                int posMediana = (tamanho - 1) / 2;
                if(posFinal == posInicial){
                    if(posFinal == posMediana){
                        this.setMP(vetor[i]);
                    }
                    else{}
                }
                else {
                    if(posMediana >= posInicial && posMediana <= posFinal){
                        this.setMP(vetor[i]);
                    }
                    else{}
                }
            }
            else{
                int posMediana = tamanho / 2;
                if(posFinal == posInicial){
                    if(posFinal == posMediana){
                        this.setMP1(vetor[i]);
                    }
                    else if(posFinal == posMediana - 1){
                        this.setMP2(vetor[i]);
                    }
                }
                else {
                    if(posMediana >= posInicial && posMediana <= posFinal){
                        this.setMP1(vetor[i]);
                    }
                    else if(posMediana -1  >= posInicial && posMediana - 1 <= posFinal){
                        this.setMP2(vetor[i]);
                    }
                }
            }
        }
        if(this.getTamanho() % 2 == 0){
            float mediana = (this.getMP1() + this.getMP2()) / 2.0f;
            return mediana;
        }
        else{
            return this.getMP();
        }
    }
}