import java.util.Scanner;

public class Main {

    private static Personagens personagens = new Personagens();
    private static Ovelha ovelha = new Ovelha(1, "ovelha");
    private static  Lobo lobo = new Lobo(2, "lobo");
    private static Alface alface = new Alface(3, "alface");
    private static Barco barco = new Barco(4, "barco");
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        personagens.adicionarLado1(ovelha);
        personagens.adicionarLado1(lobo);
        personagens.adicionarLado1(alface);
        personagens.adicionarLado1(barco);

        int jogar = 0;

        do{
            mostrarLados();
            mostrarOpcoes();
            int escolha = sc.nextInt();
            try {
                executarOpcoes(escolha);
                personagens.verificarLados();
            } catch (AlfaceOvelhaException | LoboOvelhaException e) {
                System.err.println(e.getMessage());

                System.out.println("1 - Sair | 2 - Tentar novamente");
                jogar = sc.nextInt();
                if (jogar == 1) {
                    System.exit(0);
                } else {
                    reiniciar();
                }
            }
        } while (personagens.getLado1().size() != 0 && personagens.getLado2().size() != 4);

        System.out.println("Você ganhou!");

    }
    public static void mostrarLados(){
        System.out.println("Lado 1:");
        System.out.println(personagens.getLado1());
        System.out.println("Lado 2:");
        System.out.println(personagens.getLado2());
    }

    public static void reiniciar(){
        personagens.getLado1().clear();
        personagens.getLado2().clear();
        personagens.adicionarLado1(ovelha);
        personagens.adicionarLado1(lobo);
        personagens.adicionarLado1(alface);
        personagens.adicionarLado1(barco);
    }

    public static void mostrarOpcoes(){
        System.out.println("O que deseja fazer:" +
                "\n1 - colocar ovelha no barco e passar para o lado2"+
                "\n2 - colocar lobo no barco e passar para o lado2"+
                "\n3 - colocar alface no barco e passar para o lado2"+
                "\n4 - colocar ovelha no barco e passar para o lado1"+
                "\n5 - colocar lobo no barco e passar para o lado1"+
                "\n6 - colocar alface no barco e passar para o lado1"+
                "\n7 - passar o barco para o lado 1" +
                "\n8 - passar o barco para o lado 2");;
    }

    public static void executarOpcoes(int escolha){
        switch (escolha) {
            case 1:
                if (personagens.verificaBarcoLado1(barco)) {
                    personagens.moverParaLado2(ovelha);
                    personagens.moverParaLado2(barco);

                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            case 2:
                if (personagens.verificaBarcoLado1(barco)) {
                        personagens.moverParaLado2(lobo);
                        personagens.moverParaLado2(barco);
                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            case 3:
                if (personagens.verificaBarcoLado1(barco)) {
                    personagens.moverParaLado2(alface);
                    personagens.moverParaLado2(barco);
                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            case 4:
                if (personagens.verificaBarcoLado2(barco)) {
                    personagens.moverParaLado1(ovelha);
                    personagens.moverParaLado1(barco);
                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            case 5:
                if (personagens.verificaBarcoLado2(barco)) {
                    personagens.moverParaLado1(lobo);
                    personagens.moverParaLado1(barco);
                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            case 6:
                if (personagens.verificaBarcoLado2(barco)) {
                    personagens.moverParaLado1(alface);
                    personagens.moverParaLado1(barco);

                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            case 7:
                if (personagens.verificaBarcoLado2(barco)) {
                    personagens.moverParaLado1(barco);
                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            case 8:
                if (personagens.verificaBarcoLado1(barco)) {
                        personagens.moverParaLado2(barco);
                } else {
                    System.err.println("Barco está do outro lado ( ação inválida )");
                }
                break;

            default:
                System.err.println("Escolha inválida!");
                break;
        }
    }
}