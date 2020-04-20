import java.util.LinkedList;

public class SmartTV extends Televisao{
    private int polegadas;

    public SmartTV(String id, LinkedList<Canal> canais, int polegadas){
        super(id, canais);
        this.polegadas = polegadas;
    }
    @Override
    public void cadastrarCanais(){
        for (Canal canal : canaisDisponiveis) {
            this.canaisCadastrados.add(canal);
        }
        this.ordenarCanais();
        this.setCanalAtual(this.canaisCadastrados.getFirst());
    }

}