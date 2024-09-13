import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	@Override
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair novoPar = new Pair(elemento,prioridade);
		fila.add(novoPar);
	}


	@Override
	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		if (fila.isEmpty()) throw new RuntimeException("Empty");

		Pair parAux = this.fila.get(0);
		int indice = 0;

		for(int i = 1; i < this.fila.size();i++){
			if(this.fila.get(i).getPrioridade() > parAux.getPrioridade()){
				parAux = this.fila.get(i);
				indice = i;
			}
		}

		this.fila.remove(indice);
		return parAux.getElemento();
	}
}