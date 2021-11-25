package mensagem;
import cliente.Cliente;

public class Mensagem {

	private Cliente cliente;
	private String msg;

	public Mensagem(Cliente cliente, String msg) {
		this.cliente = cliente;
		this.msg = msg;
	}

	public String getCliente() {
		return cliente.getNome() + " (ID: " + cliente.getId() + ")";
	}

	public String getMsg() {
		return msg;
	}

}
