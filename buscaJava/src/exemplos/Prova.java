package exemplos;

import java.util.LinkedList;
import java.util.List;

import busca.BuscaIterativo;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;

public class Prova implements Estado {
	
	public int custo(){
		return 1;
	}
	
	public boolean ehMeta(){
		
	}
	public List<Estado> sucessores(){
		List<Estado> sucessores = new LinkedList<Estado>();
		//mover para a esquerda
		sucessores.add(new AspiradorDePo(Casa.ESQUERDA,this.ladoDireito, this.cima, this.baixo, this.ladoEsquerdo,"Para_a_esquerda"));
		//mover para a direita
		sucessores.add(new AspiradorDePo(Casa.DIREITA, this.ladoDireito, this.ladoEsquerdo,"Para_a_direita"));
		//mover para baixo
		sucessores.add(new AspiradorDePo(Casa.BAIXO, this.ladoDireito, this.ladoEsquerdo,"Para_a_direita"));
		//mover para cima
		sucessores.add(new AspiradorDePo(Casa.DIREITA, this.ladoDireito, this.ladoEsquerdo,"Para_a_direita"));
		
		
		
		if
		(this.posicao ==Casa.DIREITA) sucessores.add(new AspiradorDePo(this.posicao,Casa.LIMPO,this.ladoEsquerdo
				,"Limpar o quarto da direita"));
		else
			sucessores.add(new AspiradorDePo(this.posicao, this.ladoDireito, Casa.LIMPO
					,"Limpar o quarto da esquerda"));
		
		return sucessores;
		}
	
	public AspiradorDePo(int posicao, int situacaoDireita, int situacaoEsquerda, int situacaoBaixo, int situacaoCima, String op){
		// TODO Auto-generated constructor stub
		this.posicao = posicao;
		
		this.ladoDireito = situacaoDireita;
		this.ladoEsquerdo = situacaoEsquerda;
		this.cima = situacaoCima;
		this.baixo = situacaoBaixo;
		this.op = op;
		
	}
	
	private int ladoEsquerdo = Casa.SUJO;
	
	private int ladoDireito = Casa.SUJO;
	
	private int cima = Casa.SUJO;
	
	private int baixo = Casa.SUJO;
	
	private int posicao = Casa.DIREITA;
	
	private String op;
	
	
	public String toString(){
		return op +"_->_";
	}
	
	
	public static void main(String args[]){
		AspiradorDePo inicial = new AspiradorDePo(Casa.DIREITA, Casa.SUJO, Casa.SUJO, "");
		
		System.out.println("busca em largura");
		
		Nodo n = new BuscaLargura().busca(inicial);
		
		if(n==null){
			System.out.println("sem solução");
		}else{
			System.out.println("solucao:\n"+ n.montaCaminho()+"\n\n");
		}
		
		AspiradorDePo inicial2 = new AspiradorDePo(Casa.DIREITA, Casa.SUJO, Casa.SUJO,"");
		
		System.out.println("busca em profundidade");
		
		Nodo n2 = new BuscaProfundidade(3).busca(inicial2);
		
		if(n2 == null){
			System.out.println("sem solução");
		}
		else{
			System.out.println("solucao:\n"+ n2.montaCaminho()+"\n\n");
		}
		
		AspiradorDePo inicial3 = new AspiradorDePo(Casa.DIREITA, Casa.SUJO, Casa.SUJO,"");
		
		Nodo n3 = new BuscaIterativo().busca(inicial3);
		
		if(n3 == null){
			System.out.println("sem solução");
		}
		else{
			System.out.println("solucao:\n"+ n3.montaCaminho()+"\n\n");
		}
		
		
		
	}
	

}

class Casa{
	public static int SUJO = 1;
	public static int LIMPO = 0;
	public static int DIREITA = 1;
	public static int ESQUERDA = 0;
	public static int CIMA = 1;
	public static int BAIXO = 0;
}
