package cursoJavaThreads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_filha = 
			new ConcurrentLinkedQueue<ObjetoFilaThread>();
	
	
	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_filha.add(objetoFilaThread);
		
	}
	
	@Override
	public void run() {
		
		System.out.println("fila rodando");
		
		
		
		while(true) {
		
		Iterator iterator = pilha_filha.iterator();
		
		synchronized (iterator) { // bloqueia acesso a esta lista por outros processos
			while (iterator.hasNext()) { // enquanto tive dados na lista continua processando
				ObjetoFilaThread processar = (ObjetoFilaThread) iterator.next();
				
				//gerar lista de PDF
				//gerar envio de emails em massa
				System.out.println("---------------------------");
			System.out.println(processar.getNome());
			System.out.println(processar.getEmail());
			
			iterator.remove();
			
			try {
				Thread.sleep(100); // dá um tempo para descarga de memoria 
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) { // depois de processar toda lista irá dar um tempo para limpar a mémoria
				e.printStackTrace();
			}
			
			}
				
			}
			
			
			}
			
		}
		
		
		}
	