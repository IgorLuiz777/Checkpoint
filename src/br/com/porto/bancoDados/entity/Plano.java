package br.com.porto.bancoDados.entity;

public class Plano {
    private int idPlano;
    private String nomePlano;
    private String cobertura;
    private String prazoVigencia;
    private String carencia;
    private double limiteCobertura;
    private double valor;

    public int getIdPlano() {
        return idPlano;
    }

    public void setIdPlano(int idPlano) {
        this.idPlano = idPlano;
    }

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getCobertura() {
        return cobertura;
    }

    public void setCobertura(String cobertura) {
        this.cobertura = cobertura;
    }

    public String getPrazoVigencia() {
        return prazoVigencia;
    }

    public void setPrazoVigencia(String prazoVigencia) {
        this.prazoVigencia = prazoVigencia;
    }

    public String getCarencia() {
        return carencia;
    }

    public void setCarencia(String carencia) {
        this.carencia = carencia;
    }

    public double getLimiteCobertura() {
        return limiteCobertura;
    }

    public void setLimiteCobertura(double limiteCobertura) {
        this.limiteCobertura = limiteCobertura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "----------------------------------------" + '\n' +
                "| Plano: " + '\n' +
                "| Nome do plano: " + nomePlano + '\n' +
                "| Cobertura: " + cobertura + '\n' +
                "| Prazo de vigência: " + prazoVigencia + '\n' +
                "| Carencia: " + carencia + '\n' +
                "| limite da cobertura: " + limiteCobertura + '\n' +
                "| valor: " + valor + '\n' +
                "| ID: " + idPlano + '\n' +
                "----------------------------------------";
    }
}

