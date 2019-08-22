package modelo;

public class Usuario {
    private int id_usuario;
    private long cpf_usuario;
    private String nomecompleto_usuario;
    private String area_usuario;
    private double valorhora_usuario;
    private int idade_usuario;
    private String sexo_usuario;
    private long numero_conta;
    private String email_usuario;
    private String senha_usuario;

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    public Usuario() {
    }

    public Usuario(int id_usuario, long cpf_usuario, String nomecompleto_usuario, String area_usuario, double valorhora_usuario, int idade_usuario, String sexo_usuario, long numero_conta, String email_usuario, String senha_usuario) {
        this.id_usuario = id_usuario;
        this.cpf_usuario = cpf_usuario;
        this.nomecompleto_usuario = nomecompleto_usuario;
        this.area_usuario = area_usuario;
        this.valorhora_usuario = valorhora_usuario;
        this.idade_usuario = idade_usuario;
        this.sexo_usuario = sexo_usuario;
        this.numero_conta = numero_conta;
        this.email_usuario = email_usuario;
        this.senha_usuario = senha_usuario;
    }

    public long getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(long numero_conta) {
        this.numero_conta = numero_conta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public long getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(long cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public String getNomecompleto_usuario() {
        return nomecompleto_usuario;
    }

    public void setNomecompleto_usuario(String nomecompleto_usuario) {
        this.nomecompleto_usuario = nomecompleto_usuario;
    }

    public String getArea_usuario() {
        return area_usuario;
    }

    public void setArea_usuario(String area_usuario) {
        this.area_usuario = area_usuario;
    }

    public double getValorhora_usuario() {
        return valorhora_usuario;
    }

    public void setValorhora_usuario(double valorhora_usuario) {
        this.valorhora_usuario = valorhora_usuario;
    }

    public int getIdade_usuario() {
        return idade_usuario;
    }

    public void setIdade_usuario(int idade_usuario) {
        this.idade_usuario = idade_usuario;
    }

    public String getSexo_usuario() {
        return sexo_usuario;
    }

    public void setSexo_usuario(String sexo_usuario) {
        this.sexo_usuario = sexo_usuario;
    }
}
