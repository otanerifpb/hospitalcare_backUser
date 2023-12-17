package br.edu.ifpb.pdist.back.model;

import java.io.Serializable;
//import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.PastOrPresent;

//import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
//@EqualsAndHashCode(exclude = {"instituicao", "declaracoes"})
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    // Para garantir que a assinatura de um número seja única , para o uso do @Id
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String nome;

    private String username;

    private String password;

    private Boolean enabled;
    
    // Relacionamento User com Authority
    @OneToMany(mappedBy = "username")
    @ToString.Exclude
    List<Authority> authorities;

    public User(String name, String username, String password) {
        this.nome = name;
        this.username = username;
        this.password = password;
    }

}
