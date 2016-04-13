package exemplos;

import java.util.LinkedList;
import java.util.List;

import busca.BuscaIterativo;
import busca.BuscaLargura;
import busca.BuscaProfundidade;
import busca.Estado;
import busca.Nodo;

public class Prova implements Estado {
	
	
	public int Love[][] = new int [4][4];	
	private int posicao = Love[0][0];
	private int situacaoDireita = Apto.SUJO;
	private int situacaoEsquerda = Apto.SUJO;
	private int situacaoCima = Apto.SUJO;
	private int situacaoBaixo = Apto.SUJO;
	
	
	public int custo(){
		return 1;
	}
	public void EstadoInicial(){
		Love[0][3] = Apto.SUJO;
		Love[1][0] = Apto.SUJO;
		Love[2][2] = Apto.SUJO;
		Love[3][3] = Apto.SUJO;
		
	}
	
	
	public boolean ehMeta(){
		
		for (int i = 0; i<Love.length;i++){
			for(int x = 0; x<Love.length;x++){
				if(Love[i][x] == Apto.SUJO && this.posicao == Love[0][0])
				{
					return false;
				}
				
			}
		}
		return true;
		
	}
	
	public List<Estado> sucessores(){
		List<Estado> sucessores = new LinkedList<Estado>();
		
		
		
		return sucessores;
		}
	
	public Prova(int posicao, int situacaoDireita, int situacaoEsquerda, int situacaoCima, int situacaoBaixo){
		
		this.posicao = posicao;
		this.situacaoDireita = situacaoDireita;
		this.situacaoEsquerda = situacaoEsquerda;
		this.situacaoCima = situacaoCima;
		this.situacaoBaixo = situacaoBaixo;
		
		
	}
	
	
	public static void main(String args[]){
		
	}
	public String getDescricao() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

class Apto{
	public static int SUJO = 1;
	public static int LIMPO = 0;
	public static int DIREITA = 1;
	public static int ESQUERDA = 0;
	public static int CIMA = 1;
	public static int BAIXO = 0;
}
