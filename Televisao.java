import java.util.LinkedList;

public abstract class Televisao {
    private String id;
    private int volume;
    private Canal canalAtual;
    protected LinkedList<Canal> canaisCadastrados = new LinkedList<>();
    protected LinkedList<Canal> canaisDisponiveis;
    private final int MAX_VOLUME = 10;
    private final int MIN_VOLUME = 0;

    public Televisao(String id, LinkedList<Canal> canais){
        this.id = id;
        this.volume = 5;
        this.canaisDisponiveis = canais;
    }

    public abstract void cadastrarCanais();

    protected void ordenarCanais(){
        for (int i = 0; i < this.canaisCadastrados.size(); i++) {
            for (int j = i + 1; j < this.canaisCadastrados.size(); j++) {
                if(this.canaisCadastrados.get(j).getNumero() < this.canaisCadastrados.get(i).getNumero()){
                    Canal new_j = this.canaisCadastrados.get(j);
                    this.canaisCadastrados.remove(j);
                    this.canaisCadastrados.add(i, new_j);
                }
            } 
        }
    }
    
    @Override
    public String toString(){
        return "Televisão modelo " + this.id + "\nCanal atual: " + this.canalAtual + "\nVolume atual: " + this.volume;
    }

    public int getVolume() {
        return volume;
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canal) {
        this.canalAtual = canal;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void alterarVolume(boolean aumenta){
        if(aumenta && this.volume < this.MAX_VOLUME)
            this.volume++;
        else if(!aumenta && this.volume > this.MIN_VOLUME)
            this.volume--;
    }

    public boolean canalExiste(Canal canal){
        return canaisDisponiveis.contains(canal);
    }

    public void sintonizar(int numero) throws CanalNaoEncontrado{
        for (Canal canal : canaisCadastrados)
            if(canal.getNumero() == numero){
                this.canalAtual = canal;
                return;
            }
        
        throw new CanalNaoEncontrado("O canal não foi encontrado");
    }

    public void alterarCanal(boolean prox){
        int i = this.canaisCadastrados.indexOf(this.canalAtual);
        if(prox){
            i++;
            if(i < this.canaisCadastrados.size())
                this.canalAtual = this.canaisCadastrados.get(i);
            else
                this.canalAtual = this.canaisCadastrados.getFirst();
        }else{
            i--;
            if(i >= 0)
                this.canalAtual = this.canaisCadastrados.get(i);
            else
                this.canalAtual = this.canaisCadastrados.getLast();
        }
    }

    public void informarDados(){
        System.out.println(this);
    }

    public void mostrarGrade(){
        for(Canal canal : canaisCadastrados) {
            System.out.println(canal);
        }
    }
}