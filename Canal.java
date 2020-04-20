public class Canal {
    private int numero;
    private boolean HD;
    private String nome;

    public Canal(int numero, String nome, boolean HD){
        this.HD = HD;
        this.numero = numero;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return this.nome + " - Canal " + this.numero; 
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isHD() {
        return HD;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHD(boolean hD) {
        HD = hD;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}