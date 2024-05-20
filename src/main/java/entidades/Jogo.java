package entidades;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQuery(name = "Jogo.buscarMaiorNumeroSorteado", query = "SELECT MAX(j.numeroSorteado) FROM Jogo j")
public class Jogo {
	
	Random random = new Random();
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datacad", nullable = false)
    private Date dataCadastro = new Date();

    @Column(nullable = false)
    private Integer numeroSorteado = random.nextInt(10);

    @Column(nullable = false)
    private Integer v1;

    @Column(nullable = false)
    private Integer v2;

    @Column(nullable = false)
    private Integer v3;

    @Column(nullable = false)
    private Integer v4;

    @Column(nullable = false)
    private Integer v5;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getNumeroSorteado() {
        return numeroSorteado;
    }

    public void setNumeroSorteado(Integer numeroSorteado) {
        this.numeroSorteado = numeroSorteado;
    }

    public Integer getV1() {
        return v1;
    }

    public void setV1(Integer v1) {
        this.v1 = v1;
    }

    public Integer getV2() {
        return v2;
    }

    public void setV2(Integer v2) {
        this.v2 = v2;
    }

    public Integer getV3() {
        return v3;
    }

    public void setV3(Integer v3) {
        this.v3 = v3;
    }

    public Integer getV4() {
        return v4;
    }

    public void setV4(Integer v4) {
        this.v4 = v4;
    }

    public Integer getV5() {
        return v5;
    }

    public void setV5(Integer v5) {
        this.v5 = v5;
    }
}
