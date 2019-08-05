package classes;

public class Proposta {
    private int id_proposta;
    private String titulo_proposta;
    private String tipo_proposta;
    private String descricao_proposta;
    private double orcamento_proposta;
    private String local_servico;

    public Proposta() {
    }

    public Proposta(int id_proposta, String titulo_proposta, String tipo_proposta, String descricao_proposta, double orcamento_proposta, String local_servico) {
        this.id_proposta = id_proposta;
        this.titulo_proposta = titulo_proposta;
        this.tipo_proposta = tipo_proposta;
        this.descricao_proposta = descricao_proposta;
        this.orcamento_proposta = orcamento_proposta;
        this.local_servico = local_servico;
    }

    public int getId_proposta() {
        return id_proposta;
    }

    public void setId_proposta(int id_proposta) {
        this.id_proposta = id_proposta;
    }

    public String getTitulo_proposta() {
        return titulo_proposta;
    }

    public void setTitulo_proposta(String titulo_proposta) {
        this.titulo_proposta = titulo_proposta;
    }

    public String getTipo_proposta() {
        return tipo_proposta;
    }

    public void setTipo_proposta(String tipo_proposta) {
        this.tipo_proposta = tipo_proposta;
    }

    public String getDescricao_proposta() {
        return descricao_proposta;
    }

    public void setDescricao_proposta(String descricao_proposta) {
        this.descricao_proposta = descricao_proposta;
    }

    public double getOrcamento_proposta() {
        return orcamento_proposta;
    }

    public void setOrcamento_proposta(double orcamento_proposta) {
        this.orcamento_proposta = orcamento_proposta;
    }

    public String getLocal_servico() {
        return local_servico;
    }

    public void setLocal_servico(String local_servico) {
        this.local_servico = local_servico;
    }

}
