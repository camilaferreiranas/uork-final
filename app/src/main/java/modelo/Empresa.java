package modelo;

public class Empresa {
    private int id_empresa;
    private String nome_empresa;
    private boolean empresa_assinante;
    private long cnpj_empresa;
    private String tipo_empresa;
    private String email_empresa;
    private String senha_empresa;

    public Empresa() {
    }

    public Empresa(int id_empresa, String nome_empresa, boolean empresa_assinante, long cnpj_empresa, String tipo_empresa, String email_empresa, String senha_empresa) {
        this.id_empresa = id_empresa;
        this.nome_empresa = nome_empresa;
        this.empresa_assinante = empresa_assinante;
        this.cnpj_empresa = cnpj_empresa;
        this.tipo_empresa = tipo_empresa;
        this.email_empresa = email_empresa;
        this.senha_empresa = senha_empresa;
    }

    public String getEmail_empresa() {
        return email_empresa;
    }

    public void setEmail_empresa(String email_empresa) {
        this.email_empresa = email_empresa;
    }

    public String getSenha_empresa() {
        return senha_empresa;
    }

    public void setSenha_empresa(String senha_empresa) {
        this.senha_empresa = senha_empresa;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNome_empresa() {
        return nome_empresa;
    }

    public void setNome_empresa(String nome_empresa) {
        this.nome_empresa = nome_empresa;
    }

    public boolean isEmpresa_assinante() {
        return empresa_assinante;
    }

    public void setEmpresa_assinante(boolean empresa_assinante) {
        this.empresa_assinante = empresa_assinante;
    }

    public long getCnpj_empresa() {
        return cnpj_empresa;
    }

    public void setCnpj_empresa(long cnpj_empresa) {
        this.cnpj_empresa = cnpj_empresa;
    }

    public String getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(String tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }
}
