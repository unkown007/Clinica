package clinicadentaria;

import java.io.*;
import java.text.DecimalFormat;

public class ClinicaDentaria {

    public static void main(String[] args) throws IOException {
        BufferedReader ler = new BufferedReader(
                             new InputStreamReader(System.in));
        DecimalFormat mt = new DecimalFormat("###,###,###.00 MT");
        DecimalFormat usd = new DecimalFormat("###,###,###.00 USD");
        
        byte op;
        char opTipo, opServico;
        
        int cod = 0;
        String tipo;
        String servico;
        
        cod = 0;
        tipo = servico = "";
        
        final int RESTAURACAO = 14000;
        final int EXTRACAO    = 8000;
        final int LIMPEZA     = 7000;
        final int CONSULTA    = 2000;
        final short CAMBIO    = 65;
                  
        float valorClinicaMT, valorClinicaUSD;
        float valorPagarMT, valorPagarUSD;
        float valorDesconto, desconto;
        
        valorDesconto = desconto = 0;
        valorClinicaUSD = valorPagarUSD = 0;
        valorClinicaMT = valorPagarMT = 0;
        
        int qtdRestauracao;
        int qtdExtracao;
        int qtdLimpeza;
        int qtdConsulta;
        
        int qtdNormal, qtdEstudante;
        
        
        qtdRestauracao = qtdExtracao = qtdLimpeza = qtdConsulta = 0;
        
        qtdNormal = qtdEstudante = 0;
        
        do {
            System.out.println("1. Receber dados");
            System.out.println("2. Visualizar dados");
            System.out.println("3. Valor total recebido da clinica");
            System.out.println("4. Valor total recebido da clinica em USD");
            System.out.println("5. Valor total do desconto");
            System.out.println("6. Quantidade de pacientes por cada tipo");
            System.out.println("7. Visualizar o servico mais aderido");
            System.out.println("0. Sair");
            do{
                System.out.print("Opcao: ");
                op = Byte.parseByte(ler.readLine());
                if(op > 7 || op < 0) {
                    System.out.println("Opcao invalida");
                }
            }while(op > 7 || op < 0);
            
            switch(op) {
                case 1:
                    do {
                       System.out.print("Codigo: ");
                       cod = Integer.parseInt(ler.readLine());
                       if(cod < 10001 || cod > 99999){
                           System.out.println("Codigo Invalido");
                       }
                    }while(cod < 10001 || cod > 99999);
                    
                    System.out.println("N - Paciente Normal");
                    System.out.println("E - Paciente Estudante");
                    do {
                        System.out.print("Opcao: ");
                        opTipo = ler.readLine().charAt(0);
                        if(opTipo != 'N' && opTipo != 'E') {
                            System.out.println("Opcao Invalida");
                        }
                    }while(opTipo != 'N' && opTipo != 'E');
                    
                    switch(opTipo){
                        case 'N': 
                            tipo = "Paciente Normal";
                            qtdNormal++;
                        break;
                        case 'E':
                            tipo = "Paciente Estudante";
                            qtdEstudante++;
                        break;
                    }
                    
                    System.out.println();
                    
                    System.out.println("R - Restauracao");
                    System.out.println("X - Extracao");
                    System.out.println("L - Limpeza");
                    System.out.println("G - Consulta Geral");
                    do{
                        System.out.print("Opcao: ");
                        opServico = ler.readLine().charAt(0);
                        if(opServico != 'R' && opServico != 'X' && opServico != 'L' && opServico != 'G'){
                            System.out.println("Opcao Ivalida");
                        }
                    }while(opServico != 'R' && opServico != 'X' && opServico != 'L' && opServico != 'G');
                    
                    switch(opServico) {
                        case 'R':
                            servico = "Restauracao";
                            qtdRestauracao++;
                            valorPagarMT = RESTAURACAO;
                        break;
                        case 'X':
                            servico = "Extracao";
                            qtdExtracao++;
                            valorPagarMT = EXTRACAO;
                        break;
                        case 'L':
                            servico = "Limpeza";
                            qtdLimpeza++;
                            valorPagarMT = LIMPEZA;
                        break;
                        case 'G':
                            servico = "Consulta Geral";
                            qtdConsulta++;
                            valorPagarMT = CONSULTA;
                        break;
                    }
                    
                    if(opTipo == 'E') {
                        desconto = valorPagarMT*0.15f;
                        valorPagarMT -= desconto;
                    }
                    
                    valorPagarUSD = valorPagarMT/CAMBIO;
                    
                    System.out.println("Valor a Pagar(MT): " + mt.format(valorPagarMT));
                    System.out.println("Valor a Pagar(USD): " + usd.format(valorPagarUSD));
                    
                    valorDesconto += desconto;
                    valorClinicaMT += valorPagarMT;
                    valorClinicaUSD += valorPagarUSD;
                break;
                case 2:
                    System.out.printf("\n%8s%10s%10s%s%s\n", " ==============","===========","==========================",
                            "=========================","============================");
                    System.out.printf("%-10s%-25s%-25s%-22s%-20s  |\n", "| Codigo","| Tipo","| Servico","| Valor a pagar (MT)",
                            "| Valor a pagar (USD)");
                    System.out.printf("%8s%10s%10s%s%s\n", " ==============","===========","=============================",
                            "======================","============================");
                    System.out.printf("| %-7d%-4s%-18s%5s%14s%11s%20s%s%21s |\n", cod, " |", tipo, " |", servico,
                                    " |", mt.format(valorClinicaMT), " |", usd.format(valorClinicaUSD));
                    System.out.printf("%8s%10s%10s%s%s\n", " ==============","===========","==========================",
                            "=========================","============================");
                    System.out.println("\n");
                break;
                case 3:
                    System.out.println("Valor da Clinica(MT): " + mt.format(valorClinicaMT));
                break;
                case 4:
                    System.out.println("Valor da Clinica(USD): " + usd.format(valorClinicaUSD));
                break;
                case 5:
                    System.out.println("Valor de Desconto(MT): " + mt.format(valorDesconto));
                break;
                case 6:
                    System.out.println("Pacientes Normais: " + qtdNormal);
                    System.out.println("Pacientes Estudantes: " + qtdEstudante);
                break;
                case 7:
                    if((qtdRestauracao > qtdExtracao) && (qtdRestauracao > qtdLimpeza) && (qtdRestauracao > qtdConsulta)) {
                        System.out.println("O servico mais solicitado e de Restauracao: " + qtdRestauracao + " Pacientes");
                    }else{
                        if((qtdExtracao > qtdRestauracao) && (qtdExtracao > qtdLimpeza) && (qtdExtracao > qtdConsulta)) {
                            System.out.println("O servico mais solicitado e de Extracao: " + qtdExtracao + " Pacientes");
                        }else{
                            if((qtdLimpeza > qtdRestauracao) && (qtdLimpeza > qtdExtracao) && (qtdLimpeza > qtdConsulta)) {
                                System.out.println("O servico mais solicitado e de Limpeza: " + qtdLimpeza + " Pacientes");
                            }else
                                System.out.println("O servico mais solicitado e de Consulta Geral: " + qtdConsulta + " Pacientes");
                        }
                    }
                break;
            }
            System.out.println();
            System.out.println();
        }while(op != 0);
    }
    
}
