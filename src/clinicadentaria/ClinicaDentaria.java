package clinicadentaria;

import java.io.*;
import java.text.DecimalFormat;

public class ClinicaDentaria {

    public static void main(String[] args) throws IOException {
        BufferedReader ler = new BufferedReader(
                             new InputStreamReader(System.in));
        DecimalFormat mt = new DecimalFormat("###,###,###.00 MT");
        
        byte op;
        char opTipo, opServico;
        
        int cod;
        String tipo;
        String servico;
        
        final int RESTAURACAO = 14000;
        final int EXTRACAO    = 8000;
        final int LIMPEZA     = 7000;
        final int CONSULTA    = 2000;
        final short CAMBIO    = 65;
                  
        float valorClinicaMT, valorClinicaUSD;
        float valorPagarMT, valorPagarUSD;
        
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
                        System.out.println("Opcao: ");
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
                    
                    System.out.println("R - Resturacao");
                    System.out.println("X - Extracao");
                    System.out.println("L - Limpeza");
                    System.out.println("G - Consulta Geral");
                    do{
                        System.out.println("Opcao: ");
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
                    
                    if(opTipo == 'E')
                        valorPagarMT -= (valorPagarMT*0.15);
                    
                    
                break;
                case 2:
                    
                break;
                case 3:
                    
                break;
                case 4:
                    
                break;
                case 5:
                    
                break;
                case 6:
                    
                break;
                case 7:
                    
                break;
            }
        }while(op != 0);
    }
    
}
