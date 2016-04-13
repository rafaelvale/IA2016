package exemplos;

import java.util.LinkedList;
import java.util.List;

import busca.BuscaIterativo;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;

public class Numeros implements Estado {
	
	private int i;
	private String op;
	private static int Meta = 10;
	

	public Numeros(int i, String op) {
		this.i = i;
		this.op = op;
		
		}
	public String toString(){
		return op;
	}

	
	public String getDescricao() {

		return "Implementa o problema dos numeros";
	}

	public boolean ehMeta() {
		
		return i == Meta;
	}

	public int custo() {
		return 1;
	}

	public List<Estado> sucessores() {
		List<Estado> suc = new LinkedList<Estado>();
		//soma 1
		suc.add(new Numeros(i+1, "+ 1"));
		//soma 2
		suc.add(new Numeros(i+2, "+ 2"));
		
		return suc;
	}
	
	public static void main(String[] args){
		Numeros inicial = new Numeros(1,"");
		
		//Nodo n = new BuscaLargura().busca(inicial);
		//Nodo n = new BuscaProfundidade().busca(inicial);
		Nodo n = new BuscaIterativo().busca(inicial);
		
		if (n == null)
			System.out.println("Não tem solução");
		else
			System.out.println("Solução : " + n.montaCaminho());
		
	}

}