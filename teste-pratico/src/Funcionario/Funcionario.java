package Funcionario;

import pessoa.Pessoa;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Funcionario  extends Pessoa {

   private  BigDecimal salario;
   private String  funcao;

    public Funcionario(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
        super(nome, data_nascimento);
        this.salario = salario;
        this.funcao = funcao;
    }



    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome = " + nome + '\'' +
                " ,data_nascimento = " + data_nascimento +
                " ,salario = " + salario +
                ", funcao = " + funcao +
                '}';
    }
}
