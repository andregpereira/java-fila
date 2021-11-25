package filaMensagens;
import mensagem.Mensagem;

public class FilaMensagens {

	private final int N = 10;
	private Mensagem dados[] = new Mensagem[N];
	private int ini, fim, cont;

	public void init() {
		ini = fim = cont = 0;
	}

	public boolean isEmpty() {
		return (cont == 0);
	}

	public boolean isFull() {
		return (cont == N);
	}

	public void enqueue(Mensagem msg) {
		if (isFull())
			System.out.println("Fila Cheia!");
		else {
			dados[fim] = msg;
			cont++;
			fim = (fim + 1) % N;
		}
	}

	public Mensagem dequeue() {
		Mensagem valor = dados[ini];
		cont--;
		ini = (ini + 1) % N;
		return (valor);
	}

}
