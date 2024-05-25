import java.util.Scanner;

public class Mediana {
    private int mP, mP1, mP2, tamanho;   //mediana parcial(caso impar), mediana parcial 1(caso par), mediana parcial 2(caso par), tamanho do vetor
    private int[] vetor;

    Mediana(Scanner input, int tamanho, int[] vetor){
        for(int i = 0; i < tamanho; i++){
            vetor[i] = input.nextInt();
        }
        this.setVetor(vetor);
        this.setTamanho(tamanho);
        input.close();
    } //construtor para leitura

    Mediana(int[] vetor){
        this.setVetor(vetor);
        this.setTamanho(vetor.length);
    } //construtor dado um vetor predefinido

    public float mediana(){
        int tamanho = this.getTamanho(); 
        int[] vetor = this.getVetor();
        for(int i = 0; i < tamanho; i++){                   //executa o bloco abaixo para cada elemento do vetor
            int qntdNumero = 1;                             //quantidade do elemento no vetor
            int qntdMaiorQue = 0;                           //quantitda de numeros que dado elemento é maior que
            for(int j = 0; j < tamanho; j++){               //comparar o elemento de indice i com todos os elementos do vetor
                if(i != j){
                    if(vetor[i] == vetor[j]){
                        qntdNumero++;                       //caso o elemento seja igual, temos um elemento repetido
                    }
                    else if(vetor[i] > vetor[j]){
                        qntdMaiorQue++;                     //caso o elemento seja maior que o outro valor comparado, encrementamos
                    }
                }
                else{}                                      //se o elemento nao for maior nem igual ao valor comparado, nao faz nada
            }
            int posInicial = qntdMaiorQue;                  //determinamos dois inteiros que determinarão a posicao do elemento no vetor
            int posFinal = qntdNumero + posInicial - 1;     //se o elemento se repete, ele vai ser tratado como um grupamento, possuindo posicao inicial e final
            if(this.getTamanho() % 2 != 0){                 //caso o numero de elementos do vetor seja impar, sua mediana vai ser exatamente no meio da lista
                int posMediana = (tamanho - 1) / 2;         
                if(posFinal == posInicial && posFinal == posMediana){  //caso o numero nao se repita, sua posicao inicial e final serao iguais
                    this.setMP(vetor[i]);                              //e caso essa posicao coincida com a posicao da mediana, encontramos ela! 
                }
                else if(posMediana >= posInicial && posMediana <= posFinal){    //se o numero se repetir, devemos verificar se a posicao mediana esta no intervalo entre as posicoes incial e final
                    this.setMP(vetor[i]);                                       //se a posicao mediana estiver nesse intervalo, acahamos a mediana!
                }
            }
            else{                                           //caso o numero de elementos seja par, precisaremos encontrar os dois elementos centrais e tirar a media entre eles
                int posMediana = tamanho / 2;
                if((posFinal == posInicial && posFinal == posMediana) || (posMediana >= posInicial && posMediana <= posFinal)){ //verifica se o numero esta posicionado na "primeira mediana"
                    this.setMP1(vetor[i]);
                }
                else{ 
                    if((posFinal == posInicial && posFinal == posMediana - 1) || (posMediana -1  >= posInicial && posMediana - 1 <= posFinal)){ //verifica se o numero esta posicionado na "segunda mediana"
                        this.setMP2(vetor[i]);
                    }
                }
            }
        }
        if(this.getTamanho() % 2 == 0){
            float mediana = (this.getMP1() + this.getMP2()) / 2.0f;  //media dos elementos centrais do vetor par
            return mediana;
        }
        else{
            float mediana = this.getMP();
            return mediana;
        }
    }

    //getters e setters
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

}