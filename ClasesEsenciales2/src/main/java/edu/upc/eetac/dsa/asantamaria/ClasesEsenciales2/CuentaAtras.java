package edu.upc.eetac.dsa.asantamaria.ClasesEsenciales2;

/*
 * 
 * Ejercicios 8, 9, 10 y 11
 * Realizados uno sobre el anterior de manera que 
 * se mustra la solucion del 11.
 * 
 */

public class CuentaAtras implements Runnable {

	Thread hilo;
	String id;
	static String ultimo = "Primera escritura";
	int cont;
	static int activos = 0;

	public CuentaAtras(String id, int cont) {
		hilo = new Thread(this);
		this.id = id;
		this.cont = cont;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hilo.start();
	}

	public void run() {

		try {
			activos++;
			for (int i = cont; i >= 0; i--) {

				System.out.println(id + " - " + i + " - " + getUltimo());

				setUltimo(id);

				Thread.sleep(1500);

			}
			activos--;
			if (activos == 0) {
				System.out.print(id + " Finalizado. "
						+ "No quedan threads activos \n");
			} else {
				System.out.print(id + " Finalizado. " + "Quedan " + activos
						+ " Threads activos \n");
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	private synchronized String getUltimo() {

		return ultimo;
	}

	private synchronized void setUltimo(String id2) {

		ultimo = "Ultima escritura de " + id2;

	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		CuentaAtras contador1 = new CuentaAtras("ID1", 4);
		CuentaAtras contador2 = new CuentaAtras("ID2", 7);
		CuentaAtras contador3 = new CuentaAtras("ID3", 8);
	}

}
