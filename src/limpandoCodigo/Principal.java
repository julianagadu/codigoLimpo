package limpandoCodigo;

public class Principal {

	public static void main(String[] args) {
		
		JogoDaVelha jogo = new JogoDaVelha();
			
		jogo.gerarMatriz();
		jogo.mostrarTabuleiro();		
		jogo.jogar();
		
		
	}
}
