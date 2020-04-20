import java.util.LinkedList;

public class ControleRemoto {
    private LinkedList<Televisao> televisoes = new LinkedList<>();

    public void adicionarTV(Televisao tv) throws TVJaCadastrada {
        if(!this.televisoes.contains(tv)){
            this.televisoes.add(tv);
        }else{
            throw new TVJaCadastrada("Esta TV já foi cadastrada");
        }
    }

    public void aumentarVolume(int num_tv){
        if(num_tv >= 0 && num_tv < this.televisoes.size())
            this.televisoes.get(num_tv).alterarVolume(true);
    }

    public void diminuirVolume(int num_tv){
        if(num_tv >= 0 && num_tv < this.televisoes.size())
            this.televisoes.get(num_tv).alterarVolume(false);
    }

    public void sintonizarCanal(int num_tv, int canal){
        if(num_tv >= 0 && num_tv < this.televisoes.size()){
            try{
                this.televisoes.get(num_tv).sintonizar(canal);
            }catch(CanalNaoEncontrado e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void proximoCanal(int num_tv){
        if(num_tv >= 0 && num_tv < this.televisoes.size())
            this.televisoes.get(num_tv).alterarCanal(true);
    }

    public void canalAnterior(int num_tv){
        if(num_tv >= 0 && num_tv < this.televisoes.size())
            this.televisoes.get(num_tv).alterarCanal(false);
    }

    public void informarDados(int num_tv){
        if(num_tv >= 0 && num_tv < this.televisoes.size())
            this.televisoes.get(num_tv).informarDados();
    }

    public void mostrarGrade(int num_tv){
        if(num_tv >= 0 && num_tv < this.televisoes.size())
            this.televisoes.get(num_tv).mostrarGrade();
    }
}