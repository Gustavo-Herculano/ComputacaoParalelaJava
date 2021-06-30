package cursojava.thread.teste;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TelaThreadSwing extends JDialog {
	
	
	//==== Components ====
	
	private JLabel nomeCliente = new JLabel("Nome do cliente");
	private JTextField InsertName = new JTextField();
	private JLabel emailCliente = new JLabel("E-mail do cliente");
	private JTextField InsertEmail = new JTextField();
	private JButton gerarNotaFiscal = new JButton("Gerar nota fiscal");
	private JButton enviarEmail = new JButton("Enviar e-mail");
	private JButton btnCancelar = new JButton("Cancelar operação");
	//--2--
	private JTextField painelAtivado = new JTextField(); 
	public JTextArea monitorGeral = new JTextArea(); 
	
	//==
	

	private ImplementacaoThreadSwing fila = new ImplementacaoThreadSwing();
	
	public TelaThreadSwing() {
		
		//==== JFRAME ====
		
		JFrame frame =  new JFrame();
		frame.setTitle("Gerador de notas fiscais e e-mails");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		frame.setResizable(false);
		frame.setLayout( new BorderLayout());
		
		
		//=== Panels ===
		
		JPanel panel1 = new JPanel(new GridBagLayout());
		panel1.setPreferredSize(new Dimension(300, 500)); 
		GridBagConstraints bagConstraints = new GridBagConstraints();
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;

		//---
		JPanel panel2 = new JPanel(new GridBagLayout());
		panel2.setPreferredSize(new Dimension(500, 500));
		GridBagConstraints bagConstraints2 = new GridBagConstraints();
		panel2.setBackground(Color.DARK_GRAY);
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
	
		//===============================================
		
		bagConstraints.insets = new Insets(-50, 5, 5, 5);
		nomeCliente.setFont(new Font("Serif", Font.ITALIC, 25));
		nomeCliente.setPreferredSize(new Dimension(200, 25));
		bagConstraints.gridy ++;
		panel1.add(nomeCliente, bagConstraints);
		
		//--
		bagConstraints.insets = new Insets(-10, 5, 5, 5);
		InsertName.setPreferredSize(new Dimension(200, 25));
		bagConstraints.gridy ++;
		panel1.add(InsertName, bagConstraints);
		//--
		bagConstraints.insets = new Insets(10, 5, 5, 5);
		emailCliente.setFont(new Font("Serif", Font.ITALIC, 25));
		emailCliente.setPreferredSize(new Dimension(200, 25));
		bagConstraints.gridy ++;
		panel1.add(emailCliente, bagConstraints);
		//--
		bagConstraints.insets = new Insets(8, 5, 5, 5);
		InsertEmail.setPreferredSize(new Dimension(200, 25));
		bagConstraints.gridy ++;
		panel1.add(InsertEmail, bagConstraints);
		//--
		bagConstraints.insets = new Insets(30, 5, 5, 5);
		gerarNotaFiscal.setPreferredSize(new Dimension(200, 35));
		bagConstraints.gridy ++;
		panel1.add(gerarNotaFiscal, bagConstraints);
		//--
		bagConstraints.insets = new Insets(5, 5, 5, 5);
		enviarEmail.setPreferredSize(new Dimension(200, 35));
		bagConstraints.gridy ++;
		panel1.add(enviarEmail, bagConstraints);
		//--
		bagConstraints.insets = new Insets(5, 5, 5, 5);
		btnCancelar.setPreferredSize(new Dimension(200, 35));
		btnCancelar.setBackground(Color.pink);
		bagConstraints.gridy ++;
		panel1.add(btnCancelar, bagConstraints);
		//--2--
		bagConstraints2.insets = new Insets(-10, 0, 5, 5);
		painelAtivado.setPreferredSize(new Dimension(430, 25));
		painelAtivado.setEditable(false);
		bagConstraints2.gridy ++;
		panel2.add(painelAtivado, bagConstraints2);
		//--
		bagConstraints2.insets = new Insets(0, 0, 5, 5);
		monitorGeral.setPreferredSize(new Dimension(430, 400));
		monitorGeral.setBackground(Color.lightGray);
		monitorGeral.setEditable(false);
		bagConstraints2.gridy ++;
		panel2.add(monitorGeral, bagConstraints2);
		
		//------
		
		
		int valorTotal = 5;
	
		
		
		
		gerarNotaFiscal.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fila == null) {
					fila = new ImplementacaoThreadSwing();
					fila.start();
					
				}
					
					for(int qtd = 0; qtd < valorTotal; qtd++) {
						ObjetoThreadSwing objetoThreadSwing = new ObjetoThreadSwing();
						objetoThreadSwing.setNome(InsertName.getText());
						objetoThreadSwing.setEmail(InsertEmail.getText());
						painelAtivado.setText(new String("Gerando nota fiscal eletronica para " + InsertName.getText()));
						painelAtivado.setFont(new Font("Serif", Font.ITALIC, 18));
						monitorGeral.setFont(new Font("Serif", Font.ITALIC, 20));
						monitorGeral.setText(new String("Aguarde enquanto o sistema emite as notas fiscais\n para o cliente " + InsertName.getText()));
						
						
						fila.add(objetoThreadSwing);
						
					
						
					}
			}
		});
		
		enviarEmail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fila == null) {
					fila = new ImplementacaoThreadSwing();
					fila.start();
					
				}
					
					for(int qtd = 0; qtd < valorTotal; qtd++) {
						ObjetoThreadSwing objetoThreadSwing = new ObjetoThreadSwing();
						objetoThreadSwing.setNome(InsertName.getText());
						objetoThreadSwing.setEmail(InsertEmail.getText());
						painelAtivado.setText(new String("Gerando envio de e-mail para " + InsertEmail.getText()));
						painelAtivado.setFont(new Font("Serif", Font.ITALIC, 18));
						monitorGeral.setFont(new Font("Serif", Font.ITALIC, 20));
						monitorGeral.setText(new String("Aguarde enquanto o sistema envia o e-mail\n para " + InsertEmail.getText()));
						
			
						fila.add(objetoThreadSwing);
						
					}
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				monitorGeral.setText(new String("Processo interrompido pelo usuário"));
				fila.stop();
				fila = null;

				
			}
		});
		
		fila.start();
		frame.add(panel1, BorderLayout.WEST);;
		frame.add(panel2, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}

}
