import java.util.LinkedList;
public class TVHD extends Televisao{
    public String modelo;
    public TVHD(String id, LinkedList<Canal> canais, String modelo){
        super(id, canais);
        this.modelo = modelo;
    }
    @Override
    public void cadastrarCanais(){
        for (Canal canal : canaisDisponiveis) {
            if(canal.isHD())
                this.canaisCadastrados.add(canal);
        }
        this.ordenarCanais();
        this.setCanalAtual(this.canaisCadastrados.getLast());
    }
}