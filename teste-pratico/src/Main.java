import Funcionario.Funcionario;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /*
    * classe com os todos os metodos pedidos no teste tecnico usando map,filter,stream api. */

    /*
    * só não consegui fazer o metodo 3.9 pedido no teste
    * */
    private static Map<String, List<Funcionario>> listfuncionariosagrupados;

    public static void main(String[] args) {


        List<Funcionario>  funcionariosList = new ArrayList<>();

        funcionariosList.add(new Funcionario("Maria", LocalDate.of(2000, Month.OCTOBER,18), new BigDecimal("2009.44"),"Operador"));
        funcionariosList.add(new Funcionario("João", LocalDate.of(1990, Month.OCTOBER,05), new BigDecimal("2284.38"),"Operador"));

        funcionariosList.add(new Funcionario("João", LocalDate.of(1990, Month.MAY, 12), new BigDecimal("2284.38"), "Operador"));
        funcionariosList.add(new Funcionario("Caio", LocalDate.of(1961, Month.MAY, 2), new BigDecimal("9836.14"), "Coordenador"));

        funcionariosList.add(new Funcionario("Miguel", LocalDate.of(1988, Month.OCTOBER, 14), new BigDecimal("19119.88"), "Diretor"));

        funcionariosList.add(new Funcionario("Alice", LocalDate.of(1995, Month.JANUARY, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionariosList.add(new Funcionario("Heitor", LocalDate.of(1999, Month.NOVEMBER, 19), new BigDecimal("1582.72"), "Operador"));

        funcionariosList.add(new Funcionario("Arthur", LocalDate.of(1993, Month.MARCH, 31), new BigDecimal("4071.84"), "Contador"));
        funcionariosList.add(new Funcionario("Laura", LocalDate.of(1994, Month.JULY, 8), new BigDecimal("3017.45"), "Gerente"));

        funcionariosList.add(new Funcionario("Heloísa", LocalDate.of(2003, Month.MAY, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionariosList.add(new Funcionario("Helena", LocalDate.of(1996, Month.JUNE, 2), new BigDecimal("2799.93"), "Gerente"));


        //Metodo que remove a pessoa joão
        funcionariosList.removeIf(funcionario -> funcionario.getNome().equals("João"));

        //metodo que imprimi todos os funcionarios atuais depois de remover o joão
        System.out.println();
        System.out.println("---lista atualizada----");
        funcionariosList.forEach(System.out::println);

        //metodo usando map parta agrupar os funcionarios com a suas devidas funções
        Map<String, List<Funcionario>> funcionariosAgrupados = funcionariosList.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));


        //soutprint com a lista atualizada  com os funcionarios agrupados  para funcoes
        System.out.println();
        System.out.println("-----fduncionarios agrupados-----");
        funcionariosAgrupados.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(System.out::println);
        });

        //metodo usando filter e straeam para agrupar  funcionario que fazem aniversario no mes de maio
        System.out.println();
        System.out.println("--Funcionarios que fazem aniversario no Mês de Maio");
        funcionariosList.stream().filter(funcionario -> funcionario.getData_nascimento().getMonth() == Month.OCTOBER)
                .forEach(System.out::println);


        //lsta em ordem alfabetica usando stream e  sorted
        System.out.println();
        System.out.println("---lista em ordem alfabetica");
        funcionariosList.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);




        //metodo que lista os funcionarios com o salario minimo de R$1212.00
        System.out.println();
        System.out.println("---quantidade minima de salario que o funcionario ganha---");
        DecimalFormat  format= new DecimalFormat("#,##0.00", new DecimalFormatSymbols(Locale.getDefault()));
        funcionariosList.forEach(funcionario -> {
            BigDecimal qtdSalariosMinimos = funcionario.getSalario().divide(new BigDecimal("1212.00"), 2, RoundingMode.HALF_UP);
            String salarioMinimoFormatado = format.format(qtdSalariosMinimos).replace(".", ",");
            System.out.println(funcionario.getNome() + ": " + salarioMinimoFormatado);
        });



    }
}