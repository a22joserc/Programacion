package ejmplosBasicosRecursividad;

public class Recursividad {
	
	
	public int sumarNumeros(int num) {
		int suma;
		if (num == 1) {
			suma = 1;
		}
		else {
			suma = num + sumarNumeros(num-1);
		}
		return suma;	
	}
	
	public void imprimirNumerosDescendentes(int num) {
		if (num == 0) {
			System.out.println("");
		}
		else {
			System.out.print(num + " ");
			imprimirNumerosDescendentes(num-1);
		}
		
	}
	
	public int multiplicar(int a, int b) {
		int producto;
		if (b==1) {
			producto = a;
		}
		else {
			producto = a + multiplicar(a,b-1);
		}
		return producto;
	}
	
	public int factorial(int num) {
		int resultado;
		if(num==0) {
			resultado = 1;
		}
		else {
			resultado = num * factorial(num-1);
		}
		return resultado;
		
	}
	
	// ARRAYS
	
	public int acumuladorRecursivoArray(int[] array, int pos) {
		int suma;	
		if (pos == array.length - 1) {
			suma = array[pos];
		}
		else {
			suma = array[pos] + acumuladorRecursivoArray(array,pos+1); 
		}
		
		return suma;
	}
	
	public int posicionElementoArray(int[] array, int elementoBuscado, int indice) {
		// Retorna -1 si no encuentra el elemento
		int pos;
		if (indice > array.length-1) {
			return -1;
		}
		else {
			if(array[indice] == elementoBuscado) {
				return indice;
			}
			else {
				pos = posicionElementoArray(array, elementoBuscado, indice+1);
			}
		}
		
		return pos;
	}
	
	public void recorrerArray(int[] array, int indice) {
		if (indice == array.length-1) {
			System.out.print(array[indice] + "\n");
		}
		else {
			System.out.print(array[indice] + " ");
			recorrerArray(array,indice+1);
		}
	}
	
	public void recorrerMatrix(int[][] matrix, int i, int j) {
		System.out.print(matrix[i][j] + "\t");
		if (i < matrix.length -1 || j < matrix[i].length -1) {
			if (j == matrix[i].length -1) {
				System.out.println("");
				j = 0;
				i++;
			}
			else if (i < matrix.length) {
				j++;
			}
			recorrerMatrix(matrix, i, j);
		}

	}
	
	
	public void recorrerMatrixV2(int[][] matrix, int i, int j) {
			System.out.print(matrix[i][j] + "\t");
			if (i < matrix.length -1 || j < matrix[i].length -1) {
				if (j == matrix[i].length -1) {
					System.out.println("");
					recorrerMatrix(matrix, i+1, 0);
				}
				else if (i < matrix.length) {
					recorrerMatrix(matrix, i, j+1);
				}
				
			}
	
		}
	
	public int[] posicionElementoMatrix(int[][] matrix, int elementoBuscar, int i, int j) {
		
		int[] pos = new int[2];
		
		if (matrix[i][j] == elementoBuscar) {
			pos[0] = i;
			pos[1] = j;
			return pos;
		}
		
		if (i < matrix.length -1 || j < matrix[i].length -1) {
			if (j == matrix[i].length -1) {
				System.out.println("");
				j = 0;
				i++;
			}
			else if (i < matrix.length) {
				j++;
			}
			pos = posicionElementoMatrix(matrix,elementoBuscar, i, j);
		}
		
		return pos;
	}
	
	// Contar número elementos en un Array
	public int contarElementoArray(int[] array, int elemento, int indice) {
		int cont;
		if (indice == array.length-1) {
			if(array[indice] == elemento) {
				cont = 1;
			}
			else {
				cont = 0;
			}
		}
		else {
			if(array[indice] == elemento) {
				cont = contarElementoArray(array, elemento, indice+1) + 1;
			}
			else {
				cont = contarElementoArray(array, elemento, indice+1);
			}
		}
		return cont;
	}
	
	// SUMAR DIGITOS Número recursivamente
	 public int sumaDigitos(int numero){
        if(numero < 10){ //caso base
            return numero; //devuelvo el numero
        }else{
        	System.out.println(numero/10);
            return (numero % 10) + sumaDigitos(numero/10); //Cojo el digito y llamo a la funcion
        }
	         
	         
	}
	
	/*public void posicionElementoMatrix(int[][] matrix, int elementoBuscar, int i, int j) {
		
		
		if (matrix[i][j] == elementoBuscar) {
			System.out.println("El elemento " + elementoBuscar + " está en la posición (" + i + ", " + j + ")");
		}
		
		if (i < matrix.length -1 || j < matrix[i].length -1) {
			if (j == matrix[i].length -1) {
				System.out.println("");
				j = 0;
				i++;
			}
			else if (i < matrix.length) {
				j++;
			}
			posicionElementoMatrix(matrix,elementoBuscar, i, j);
		}

	}*/
	 
	 // FIBONACCI
	 
	 public int fibonacciRecursivo(int n) { 
        //CASO BASE, si es cero devuelve un cero
        //Puedes poner n&lt;=0 tamvien para incluir negativos
        if (n == 0) {
            return 0;
        //CASO BASE, si es 1 devuelve un 1    
        } else if (n == 1) {
            return 1;
        } else {
            //Hago la suma
            return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
        }
 
    }

}
