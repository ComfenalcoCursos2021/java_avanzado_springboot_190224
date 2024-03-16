package com.spring.lanzador;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner(System.in);
		int a = 15;
		int b = 3;
		int c = 0;
		System.out.println("por favor ingrese el valor del divisor");
		
		try {
			b = teclado.nextInt();
			c = a / b;
			
		} catch (ArithmeticException e) {
			System.out.println("QUE POR FAVOR EL NUMERO SEA UN ENTERO POSITIVO DIFERENTE DE 0 !!!");
		} catch (InputMismatchException e) {
			System.out.println("que por favor sea un numero");
		} catch (Exception e) {
			System.out.println(e.toString());			
		}
		
		
		System.out.println("El resultado es " + c);
		System.out.println("Termino !!!");
	}

}
