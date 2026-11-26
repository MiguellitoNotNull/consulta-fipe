package br.com.alura.consulta_fipe.model;

import java.util.List;

public class ModeloVeiculo {
    private List<DadosModelo> modelos;
    private List<DadosAno> anos;

    public List<DadosModelo> getModelos() {
        return modelos;
    }

    public void setModelos(List<DadosModelo> modelos) {
        this.modelos = modelos;
    }

    public List<DadosAno> getAnos() {
        return anos;
    }

    public void setAnos(List<DadosAno> anos) {
        this.anos = anos;
    }

    @Override
    public String toString() {
        return
                "modelo= " + modelos +
                ", ano= " + anos
                ;
    }
}
