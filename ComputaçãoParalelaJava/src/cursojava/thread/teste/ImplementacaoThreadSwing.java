package cursojava.thread.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.swing.JTextField;

public class ImplementacaoThreadSwing extends Thread{
	
	
	private static ConcurrentLinkedQueue<ObjetoThreadSwing> lote_fila = new ConcurrentLinkedQueue<ObjetoThreadSwing>();
	
	public static void add(ObjetoThreadSwing objetoThreadSwing) {
		lote_fila.add(objetoThreadSwing);
	}
	
	@Override
	public void run() {
		
		System.out.println("sistema rodando!");
		
		while(true) {
			
			synchronized (lote_fila) {
				
				Iterator iteracao = lote_fila.iterator();
				
				while(iteracao.hasNext()) {
					ObjetoThreadSwing processar = (ObjetoThreadSwing) iteracao.next();
					
					
					System.out.println("--------------------");
					System.out.println("Nome: " + processar.getNome());
					System.out.println("E-mail: " + processar.getEmail());
					
					iteracao.remove();
					
					try {
						Thread.sleep(1000);
					
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
