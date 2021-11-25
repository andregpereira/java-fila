package main;
import java.util.Scanner;

import cliente.Cliente;
import filaMensagens.FilaMensagens;
import mensagem.Mensagem;

public class Chat {

	public static void main(String[] args) {
		Scanner le = new Scanner(System.in);
		FilaMensagens fila = new FilaMensagens();
		fila.init();
		Cliente clientes[] = new Cliente[10];
		int n = 0;
		int opcao;

		do {
			System.out.println(" \n 0 - para sair do sistema " + "\n 1 - para enviar mensagem pelo chat"
					+ "\n 2 - ler e responder mensagem de chat");
			System.out.print("Digite opção: ");
			opcao = le.nextInt();

			switch (opcao) {
			case 0:
				System.out.println("\nFinalizado o atendimento...");
				break;
			case 1:
				System.out.print("\nDigite seu id: ");
				int id = le.nextInt();
				int i;
				boolean achou = false;
				i = 0;
				while (i < n && !achou) {
					if (clientes[i].getId() == id)
						achou = true;
					else
						i++;
				}

				if (!achou) {
					System.out.println("Fazendo o cadastro deste id...");
					System.out.print("Digite seu nome: ");
					String nome = le.next();
					Cliente cli = new Cliente(id, nome);
					clientes[n] = cli;
					n++;
				}
				
				System.out.print("Digite a mensagem a ser enviada: ");
				le.nextLine();
				String msg = le.nextLine();
				Mensagem m = new Mensagem(clientes[i], msg);
				fila.enqueue(m);
				break;
			case 2:
				if (!fila.isEmpty()) {
					m = fila.dequeue();
					System.out.println("\nEnviado pelo cliente: " + m.getCliente());
					System.out.println("Mensagem: " + m.getMsg());
				} else
					System.out.println("\nNão há mensagens na fila");
				break;
			default:
				System.out.println("\nOpção inválida!");
			}
		} while (opcao != 0);

		le.close();
	}

}
