import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Personagens personagens = new Personagens();
        Ovelha ovelha = new Ovelha(1, "ovelha");
        Lobo lobo = new Lobo(2, "lobo");
        Alface alface = new Alface(3, "alface");
        Barco barco = new Barco(4, "barco");

        personagens.adicionarLado1(ovelha);
        personagens.adicionarLado1(lobo);
        personagens.adicionarLado1(alface);
        personagens.adicionarLado1(barco);

        while (personagens.getLado1().size() != 0 && personagens.getLado2().size() != 4) {
            System.out.println("O que deseja fazer:" +
                    "\n1 - colocar ovelha no barco e passar para o lado2"+
                    "\n2 - colocar lobo no barco e passar para o lado2"+
                    "\n3 - colocar alface no barco e passar para o lado2"+
                    "\n4 - colocar ovelha no barco e passar para o lado1"+
                    "\n5 - colocar lobo no barco e passar para o lado1"+
                    "\n6 - colocar alface no barco e passar para o lado1"+
                    "\n7 - passar o barco para o lado 1" +
                    "\n8 - passar o barco para o lado 2");
            int escolha = sc.nextInt();

            switch (escolha) {
                case 1:
                    try{
                        personagens.moverParaLado2(ovelha);
                        personagens.moverParaLado2(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    try{
                        personagens.moverParaLado2(lobo);
                        personagens.moverParaLado2(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    try {
                        personagens.moverParaLado2(alface);
                        personagens.moverParaLado2(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    try {
                        personagens.moverParaLado1(ovelha);
                        personagens.moverParaLado1(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 5:
                    try {
                        personagens.moverParaLado1(lobo);
                        personagens.moverParaLado1(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    try {
                        personagens.moverParaLado1(alface);
                        personagens.moverParaLado1(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 7:
                    try {
                        personagens.moverParaLado1(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 8:
                    try {
                        personagens.moverParaLado2(barco);
                    } catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
            if (personagens.verificarLados()){
                System.out.println("Perdeu playboy");
                return;
            }

        }
        System.out.println("Você ganhou!");
    }
}