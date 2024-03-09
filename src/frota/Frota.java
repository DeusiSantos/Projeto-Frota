package frota;

import java.util.ArrayList;
import java.util.List;

import veiculos.Veiculos;

public class Frota {
    private List<Veiculos> veiculos;

    public Frota() {
        veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculos veiculo) {
        veiculos.add(veiculo);
    }

    public int numVeiculos(){
        return this.veiculos.size();
    }
}

