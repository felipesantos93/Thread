package cursoJavaThreads;

import javax.swing.JOptionPane;

public class AulaThreads {

	public static void main(String[] args) throws InterruptedException {

		/* Thread processando em paralelo no envio de email */
		Thread threadEmail = new Thread(thread1);
		threadEmail.start();

		/* Thread processando em paralelo no envio de nota fiscal */
		Thread threadNotaFiscal = new Thread(thread2);
		threadNotaFiscal.start();

		/* código do sistema do usuário continua o fluxo de trabalho */
		System.out.println("Processo finalizado!");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para o usuário");

	}

	private static Runnable thread2 = new Runnable() {

		@Override
		public void run() {
			/* código da rotina que eu quero executar em paralelo */
			for (int pos = 0; pos < 10; pos++) {

				/* Quero executar esse envio com tempo de parada */
				System.out.println("Executando rotina de email");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // dá um tempo;

			}

		}
	};

	private static Runnable thread1 = new Runnable() {
		@Override
		public void run() {

			/* código da rotina que eu quero executar em paralelo */
			for (int pos = 0; pos < 10; pos++) {

				/* Quero executar esse envio com tempo de parada */
				System.out.println("Executando rotina de nota fical");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // dá um tempo;

			}

		}

	};

}
