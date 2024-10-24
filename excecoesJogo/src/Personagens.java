import java.util.ArrayList;

public class Personagens {

    private ArrayList<Personagens> lado1 = new ArrayList<>();
    private ArrayList<Personagens> lado2 = new ArrayList<>();

    public ArrayList<Personagens> getLado1() {
        return lado1;
    }


    public ArrayList<Personagens> getLado2() {
        return lado2;
    }

    public Personagens(int codigo, String nome) {

    }

    public Personagens() {
    }

    public void adicionarLado1(Personagens p) {
        lado1.add(p);
    }

    public void removerLado1(Personagens p) {
        lado1.remove(p);
    }

    public void adicionarLado2(Personagens p) {
        lado2.add(p);
    }

    public void removerLado2(Personagens p) {
        lado2.remove(p);
    }

    public void moverParaLado1(Personagens p) {
        if (lado2.contains(p)) {
            removerLado2(p);
            adicionarLado1(p);
        }
    }

    public void moverParaLado2(Personagens p) {
        if (lado1.contains(p)) {
            removerLado1(p);
            adicionarLado2(p);
        }
    }

    public Boolean verificaBarcoLado1(Barco barco) {
        if(lado1.contains(barco)){
            return true;
        }
        return false;
    }
    public Boolean verificaBarcoLado2(Barco barco) {
        if(lado2.contains(barco)){
            return true;
        }
        return false;
    }

    public Boolean verificarLados() {
        boolean ovelhaLado1 = false;
        boolean loboLado1 = false;
        boolean alfaceLado1 = false;
        boolean barcoLado1 = false;

        for (Personagens p : lado1) {
            if (p instanceof Ovelha) ovelhaLado1 = true;
            if (p instanceof Lobo) loboLado1 = true;
            if (p instanceof Alface) alfaceLado1 = true;
            if (p instanceof Barco) barcoLado1 = true;
        }

        if (ovelhaLado1 && loboLado1 && !alfaceLado1 && !barcoLado1) {
            throw new LoboOvelhaException();
        }
        if (ovelhaLado1 && alfaceLado1 && !loboLado1 && !barcoLado1) {
            throw new AlfaceOvelhaException();
        }
        if (!ovelhaLado1 && !loboLado1 && alfaceLado1 && barcoLado1) {
            throw new LoboOvelhaException();
        }
        if (!ovelhaLado1 && !alfaceLado1 && loboLado1 && barcoLado1) {
            throw new LoboOvelhaException();
        }
        if (ovelhaLado1 && loboLado1 && alfaceLado1 && !barcoLado1) {
            throw new LoboOvelhaException();
        }

        return false;
    }
}