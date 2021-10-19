public class pilhaEstatica {
    private String dados[];
    private int topo;

    public pilhaEstatica(int tamanho){
        this.dados = new String[tamanho];
        this.topo = 0; 
    }

    public void push(String elemento){
        if(this.dados.length > this.topo){
            this.dados[this.topo] = elemento;
            this.topo++;
        }
    }

    public int size(){
        return this.topo;
    }

    public String pop(){
        if (this.topo > 0){ 
            this.topo--;
            return this.dados[this.topo];
        } else{
            return "Pilha vazia!";
        }
    }

    public boolean isFull(){
        if (this.topo == this.dados.length) {
            return true;
        } else{
            return false;
        }
    }

    public boolean isEmpty(){
        if (this.topo == 0) {
            return true;
        } else{
            return false;
        }
    }

    public void reset(){
        this.topo = 0;
    }
}
