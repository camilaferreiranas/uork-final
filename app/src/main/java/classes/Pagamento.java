package classes;

public class Pagamento {
    private int id_ususario;
    private double cpf_usuario;
    private double conta_usuario;
    private double valor_pago;
    private boolean pedido_entregue;

    public Pagamento() {
    }

    public Pagamento(int id_ususario, double cpf_usuario, double conta_usuario, double valor_pago, boolean pedido_entregue) {
        this.id_ususario = id_ususario;
        this.cpf_usuario = cpf_usuario;
        this.conta_usuario = conta_usuario;
        this.valor_pago = valor_pago;
        this.pedido_entregue = pedido_entregue;
    }

    public int getId_ususario() {
        return id_ususario;
    }

    public void setId_ususario(int id_ususario) {
        this.id_ususario = id_ususario;
    }

    public double getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(double cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public double getConta_usuario() {
        return conta_usuario;
    }

    public void setConta_usuario(double conta_usuario) {
        this.conta_usuario = conta_usuario;
    }

    public double getValor_pago() {
        return valor_pago;
    }

    public void setValor_pago(double valor_pago) {
        this.valor_pago = valor_pago;
    }

    public boolean isPedido_entregue() {
        return pedido_entregue;
    }

    public void setPedido_entregue(boolean pedido_entregue) {
        this.pedido_entregue = pedido_entregue;
    }
}
