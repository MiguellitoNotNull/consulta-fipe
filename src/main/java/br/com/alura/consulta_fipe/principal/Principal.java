package br.com.alura.consulta_fipe.principal;

import br.com.alura.consulta_fipe.model.*;
import br.com.alura.consulta_fipe.service.ConsumoApi;
import br.com.alura.consulta_fipe.service.ConvertorDados;
import tools.jackson.databind.ObjectMapper;

import java.util.*;

import java.util.stream.Collectors;


public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1";

    private ConsumoApi consumir = new ConsumoApi();
    private ConvertorDados convertor = new ConvertorDados();


    public void exibeMenu(){
        System.out.println("*** OPÇÕES ***");
        System.out.println("Carro");
        System.out.println("Moto");
        System.out.println("Caminhão");
        System.out.println();
        System.out.println("Digite uma das opções para consultar os valores: ");

        String veiculo = scanner.nextLine().toLowerCase();

        String enderecamento;

        if (veiculo.contains("car")){
            enderecamento = ENDERECO+"/carros/marcas/";

        } else if (veiculo.contains("mo")) {
            enderecamento = ENDERECO+"/motos/marcas/";
        }else {
            enderecamento = ENDERECO+"/caminhoes/marcas/";
        }

        var json = consumir.consumirApi(enderecamento);

        var dados = convertor.obterLista(json, DadosFlipe.class);

        dados.stream()
                .sorted(Comparator.comparing(DadosFlipe::codigo))
                .forEach(n -> System.out.println("Código: "+n.codigo()+" | Nome: "+n.nome()));


        System.out.println();

        System.out.println("Diga o codigo da marca a consultar: ");
        String codigo = scanner.nextLine();

        enderecamento=enderecamento+codigo+"/modelos/";

        json = consumir.consumirApi(enderecamento);

        ModeloVeiculo modeloVeiculo = convertor.obterDados(json, ModeloVeiculo.class);

        modeloVeiculo.getModelos().forEach(n -> System.out.println("Código: "+n.codigo()+" | Nome: "+n.nome()));;

        System.out.println();

        System.out.println("Digite o nome do modelo do veículo: ");

        String nomeModelo = scanner.nextLine().toLowerCase();

        var modelosFiltrados = modeloVeiculo.getModelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeModelo))
                .collect(Collectors.toList());


        if (!modelosFiltrados.isEmpty()){

            modelosFiltrados.forEach(n -> System.out.println("Código: "+n.codigo()+" | Nome: "+n.nome()));

            System.out.println();

            System.out.println("Digite o código do modelo para consultar valores: ");
            String codigoModelo = scanner.nextLine();

            enderecamento=enderecamento+codigoModelo+"/anos/";
            json = consumir.consumirApi(enderecamento);

            System.out.println();

            List<DadosAno> listaAnos = convertor.obterLista(json, DadosAno.class);

            for (DadosAno ano : listaAnos) {
                String urlBase = enderecamento;
                String codigoAno = ano.codigo();

                urlBase = enderecamento+codigoAno ;
                json = consumir.consumirApi(urlBase);

                DadosVeiculo dadosVeiculo = convertor.obterDados(json, DadosVeiculo.class);
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Valor: "+dadosVeiculo.valor()+" | Marca: "+ dadosVeiculo.marca() + " | Modelo: "+ dadosVeiculo.modelo() + " | Ano: "+ dadosVeiculo.ano() + " | Combustível: "+ dadosVeiculo.combustivel()+ " | Código FIPE: "+ dadosVeiculo.codigoFipe()+ " | Mês referência: "+ dadosVeiculo.mesReferencia());
                System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

            }

        }else {
            System.out.println("Não contém este modelo");
        }
        scanner.close();
    }
}
