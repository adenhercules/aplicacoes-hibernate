/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplo2.crudannotations;



import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table (name = "contato")
public class ContatoAnnotations{
    @Id
    @GeneratedValue
    @Column (name="id_contato")
    private Integer codigo;
    
    @Column (name="nome", length=50, nullable=true)
    private String nome;
    
    @Column (name="telefone", length=50, nullable=true)
    private String telefone;
    
    @Column (name="email", length=50, nullable=true)
    private String email;
    
    @Column (name="data_cadastro", length=50, nullable=true)
    private Date dataCadastro;
    
    @Column (name="observacao", length=50, nullable=true)
    private String observacao;

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}

