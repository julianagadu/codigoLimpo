package limpandoCodigo;

import java.util.Scanner;

/*
 * Eu não quis mudar a lógica utilizada, então eu alterei os nomes
 * das variaveis para que fizessem mais sentido e tentei estruturar cada ação em funcoes
 * */

public class JogoDaVelha {
	
	String[][] matriz = new String [3][3];
	String tabuleiro;
	Integer jogador = 1;
	
	//gerando a matriz que vai ser usada pra criar e popular o tabuleiro
	public void gerarMatriz() {
						
		for (int i = 0; i < 3; i++) {
			 for (int j = 0; j < 3; j++) {
				 matriz[i][j] = " ";
			 }
		}		
	}
	
	//mostrando o tabuleiro
	public void mostrarTabuleiro() {
				
		tabuleiro = "    1   2   3";
		tabuleiro += "\n---------------\n";
		for (int i = 0; i < 3; i++) {
			tabuleiro += (i + 1) + " | ";
			for (int j = 0; j < 3; j++) {
				tabuleiro += matriz[i][j] + " | ";
			}
			tabuleiro += "\n---------------\n";
		}
		
		System.out.println(tabuleiro);
		
	}
	
	
	//playing XD
		public void jogar(){
			
			Scanner scanner = new Scanner(System.in);
			//loop até haver um empate ou ganhador
			while (!(empate(matriz) || ganhador(matriz, "X") || ganhador(matriz, "O"))) {
				
				//abre o console e pede para o usuario informar a posiçao = linha + coluna
				System.out.println("Jogador " + jogador + " digite a posição (linha e coluna): ");
				String entrada = scanner.nextLine();
				//o valor informado vai ser divido atraves do espaço, o primeiro numero antes do espaço será a linha e o segundo após o espaço será a coluna
				String[] split = entrada.split(" ");
				Integer linha = Integer.valueOf(split[0]);
				Integer coluna = Integer.valueOf(split[1]);
				
				validarJogada(linha,coluna);
				
			}
			
			resultado();
			
			scanner.close();
		}

		
		//verificar se a jogada é valida
		public void validarJogada(Integer linha,Integer coluna) {
			
			Integer i = linha-1;
			Integer j = coluna-1;	
			if (i < 3 && j < 3 && matriz[i][j].equals(" ")) {
				marcarNoTabuleiro(linha,coluna);
			} else {
				System.out.println("Jogada Inválida, digite novamente!");
			}

		}
		
		
		public void marcarNoTabuleiro( Integer linha, Integer coluna) {
			
				//changing between the players
				if (jogador == 1) {
					matriz[linha-1][coluna-1] = "X";
					jogador = 2;
				} else {
					matriz[linha-1][coluna-1] = "O";
					jogador = 1;
				}
				mostrarTabuleiro();
		}
		
		
		public void resultado() {
			
			//Verifica o resultado final
			if (ganhador(matriz, "X")) {
				System.out.println("O jogador 1 ganhou!");
			} else if (ganhador(matriz, "O")) {
				System.out.println("O jogador 2 ganhou!");
			} else if (empate(matriz)) {
				System.out.println("O jogo terminou empatado!");
			}
		}
		
		//verifica se ganhou
		public boolean ganhador(String matriz[][], String jogada) {
			boolean ganhou = false;
			//verifica se ganhou nas linhas
			for (int i = 0; i < 3; i++) {
		    	int count = 0;
		        for (int j = 0; j < 3; j++) {
		            if (matriz[i][j] == jogada) {
		                count++;
		            }
		        }
		        if (count == 3) {
		            ganhou = true;
		        }
		    }
		    //verifica se ganhou nas colunas
		    for (int j = 0; j < 3; j++) {
		    	int count = 0;
		        for (int i = 0; i < 3; i++) {
		            if (matriz[i][j] == jogada) {
		                count++;
		            }
		        }
		        if (count == 3) {
		            ganhou = true;
		        }
		    }
		    //verifica se ganhou nas diagonais
		    if (matriz[0][0] == jogada && matriz[1][1] == jogada && matriz[2][2] == jogada) {
				ganhou = true;
			} else if (matriz[0][2] == jogada && matriz[1][1] == jogada && matriz[2][0] == jogada) {
				ganhou = true;
			}
		    return ganhou;
		}
		
			
			//verifica se houve empate
			public boolean empate(String matriz[][]) {
				boolean empate = false;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						 if (matriz[i][j] == " ") {
							 empate = true;
						 }
					}
				}
				return !empate;
			}
		
}
