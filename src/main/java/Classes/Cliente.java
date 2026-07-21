package Classes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Cliente")
    private Long id;

    @Column(name = "NomeRazao", nullable = false)
    private String nomeRazao;

    @Column(name = "NomeFantasia")
    private String nomeFantasia;

    @Column(name = "CNPJ_CPF", nullable = false, length = 18)
    private String cnpjCpf;

    @Column(name = "Nascimento")
    private LocalDate nascimento;

    @Column(name = "ProfissaoAtividade")
    private String profissao;

    @Column(name = "Rua")
    private String rua;

    @Column(name = "Bairro")
    private String bairro;

    @Column(name = "Cidade")
    private String cidade;

    @Column(name = "Estado", length = 2)
    private String estado;

    @Column(name = "CEP", length = 9)
    private String cep;

    @Column(name = "Telefone")
    private String telefone;

    @Column(name = "Whatsapp")
    private String whatsapp;

    @Column(name = "Email")
    private String email;

    @Column(name = "observacao", columnDefinition = "TEXT")
    private String observacao;
    
     public Cliente() {
    }

    // Construtor completo para facilitar instanciação rápida
    public Cliente(Long id, String nomeRazao, String cnpjCpf, LocalDate nascimento, String email) {
        this.id = id;
        this.nomeRazao = nomeRazao;
        this.cnpjCpf = cnpjCpf;
        this.nascimento = nascimento;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRazao() {
        return nomeRazao;
    }

    public void setNomeRazao(String nomeRazao) {
        this.nomeRazao = nomeRazao;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
