#include <stdio.h>

int soma(float num1, float num2){ return num1 + num2; }

int subtracao(float num1, float num2){ return num1 - num2; }

int multiplicacao(float num1, float num2){ return num1 * num2; }

int divisao(float num1, float num2) { return num1 / num2; }

void mostrarFalhaDivisao(){
    printf("Erro! Divisão por zero.\n");
}
int divisaoPossivel(float num2){
    if(num2 == 0){
        mostrarFalhaDivisao();
        return 0;
    }
    
    return 1;
}
void mostrarResultado(float res){
    printf("Resultado: %.2f\n", res);
}
void escolherOperacao(float num1,float num2,char operador,float resultado){
    switch (operador) {
    	case '+':
        	resultado = soma(num1,num2);
        	mostrarResultado(resultado);
        	break;
    	case '-':
        	resultado = subtracao(num1,num2);
        	mostrarResultado(resultado);
        	break;
    	case '*':
        	resultado = multiplicacao(num1,num2);
            mostrarResultado(resultado);
        	break;
    	case '/':
            if(divisaoPossivel(num2)){
                resultado = divisao(num1,num2);
                mostrarResultado(resultado);
            }
        	break;
    	default:
        	printf("Operador inválido.\n");
	}
}
int main() {
	char operador;
	float num1, num2, resultado=0;
	printf("Digite a operacao (+, -, *, /): ");
	scanf("%c", &operador);
	printf("Digite o primeiro numero: ");
	scanf("%f", &num1);
	printf("Digite o segundo número: ");
	scanf("%f", &num2);
    escolherOperacao(num1,num2,operador,resultado);
	return 0;
}







