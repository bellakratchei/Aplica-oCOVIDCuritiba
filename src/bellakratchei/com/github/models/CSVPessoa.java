package bellakratchei.com.github.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CSVPessoa {

    private int posicao;
    private String dataNotificacao;
    private String classificacaoFinal;
    private int idadeAnos;
    private String sexo;
    private String evolucao;
    private String dataObito;

    public CSVPessoa(int posicao, String dataNotificacao, String classificacaoFinal, int idadeAnos, String sexo, String evolucao, String dataObito) {
        this.posicao = posicao;
        this.dataNotificacao = dataNotificacao;
        this.classificacaoFinal = classificacaoFinal;
        this.idadeAnos = idadeAnos;
        this.sexo = sexo;
        this.evolucao = evolucao;
        this.dataObito = dataObito;
    }
/*
    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Date getDataNotificacao() {
        return dataNotificacao;
    }

    public void setDataNotificacao(Date dataNotificacao) {
        this.dataNotificacao = dataNotificacao;
    }

    public String getClassificacaoFinal() {
        return classificacaoFinal;
    }

    public void setClassificacaoFinal(String classificacaoFinal) {
        this.classificacaoFinal = classificacaoFinal;
    }

    public int getIdadeAnos() {
        return idadeAnos;
    }

    public void setIdadeAnos(int idadeAnos) {
        this.idadeAnos = idadeAnos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEvolucao() {
        return evolucao;
    }

    public void setEvolucao(String evolucao) {
        this.evolucao = evolucao;
    }

    public Date getDataObito() {
        return dataObito;
    }

    public void setDataObito(Date dataObito) {
        this.dataObito = dataObito;
    }

 */
}
