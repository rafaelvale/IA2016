package exemplos;

import busca.BuscaIterativo;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;

import java.util.LinkedList;
import java.util.List;


public class AspiradorDePo implements Estado{
	
	

	public int custo(){
		return 1;
	}
	
	public boolean ehMeta(){
		if(this.ladoEsquerdo==Apto.LIMPO && this.ladoDireito==Apto.LIMPO)
			return true;
		else
			return false;
	}
	public String getDescricao(){
		return "Problema Classico do Aspirador de Pó.";
	}
	public List<Estado> sucessores(){
		List<Estado> sucessores = new LinkedList<Estado>();
		//mover para a esquerda
		sucessores.add(new AspiradorDePo(Apto.ESQUERDA,this.ladoDireito, this.ladoEsquerdo,"Para_a_esquerda"));
		//mover para a direita
		sucessores.add(new AspiradorDePo(Apto.DIREITA, this.ladoDireito, this.ladoEsquerdo,"Para_a_direita"));
		
		if
		(this.posicao ==Apto.DIREITA) sucessores.add(new AspiradorDePo(this.posicao,Apto.LIMPO,this.ladoEsquerdo
				,"Limpar o quarto da direita"));
		else
			sucessores.add(new AspiradorDePo(this.posicao, this.ladoDireito, Apto.LIMPO
					,"Limpar o quarto da esquerda"));
		
		return sucessores;
		}
	
	public AspiradorDePo(int posicao, int situacaoDireita, int situacaoEsquerda, String op){
		// TODO Auto-generated constructor stub
		this.posicao = posicao;
		
		this.ladoDireito = situacaoDireita;
		this.ladoEsquerdo = situacaoEsquerda;
		this.op = op;
		
	}
	
	private int ladoEsquerdo = Apto.SUJO;
	
	private int ladoDireito = Apto.SUJO;
	
	private int posicao = Apto.DIREITA;
	
	private String op;
	
	
	public String toString(){
		return op +"_->_";
	}
	
	
	public static void main(String args[]){
		AspiradorDePo inicial = new AspiradorDePo(Apto.DIREITA, Apto.SUJO, Apto.SUJO, "");
		
		System.out.println("busca em largura");
		
		Nodo n = new BuscaLargura().busca(inicial);
		
		if(n==null){
			System.out.println("sem solução");
		}else{
			System.out.println("solucao:\n"+ n.montaCaminho()+"\n\n");
		}
		
		AspiradorDePo inicial2 = new AspiradorDePo(Apto.DIREITA, Apto.SUJO, Apto.SUJO,"");
		
		System.out.println("busca em profundidade");
		
		Nodo n2 = new BuscaProfundidade(3).busca(inicial2);
		
		if(n2 == null){
			System.out.println("sem solução");
		}
		else{
			System.out.println("solucao:\n"+ n2.montaCaminho()+"\n\n");
		}
		
		AspiradorDePo inicial3 = new AspiradorDePo(Apto.DIREITA, Apto.SUJO, Apto.SUJO,"");
		
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
}

