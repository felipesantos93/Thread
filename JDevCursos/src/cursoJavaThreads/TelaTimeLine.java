package cursoJavaThreads;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.InsetsUIResource;

public class TelaTimeLine extends JDialog {
	
	private JPanel jPanel = new  JPanel(new GridBagLayout()); // painel de componentes
	

	
	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("E-mail");
	private JTextField mostraTempo2 = new JTextField();
	
	private JButton botao = new JButton("Add Lista");
	private JButton botao2 = new JButton("Stop");
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	
	
	
	public TelaTimeLine() {
		setTitle("Tela Inicial");
		setSize(new Dimension(240,240));
		setLocationRelativeTo(null);
		setResizable(false);
		//Primeira parte concluida
		
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();  // controlador de posicionamento de botões na tela
		gridBagConstraints.gridx = 0 ;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.WEST;
		gridBagConstraints.insets = new InsetsUIResource(5, 10, 5, 5); 
		gridBagConstraints.gridwidth = 2;
	
		
		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora , gridBagConstraints);
		
		mostraTempo.setPreferredSize(new Dimension(200, 25));
	
		gridBagConstraints.gridy ++; // faz movimentar componente (nesse caso como é y faz ir para baixo tipo um coluna de excel)
		jPanel.add(mostraTempo, gridBagConstraints);
		
		
		descricaoHora2.setPreferredSize(new Dimension(200,25));
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoHora2, gridBagConstraints);
		
		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		
		gridBagConstraints.gridy ++;
		jPanel.add(mostraTempo2, gridBagConstraints);	
		
		gridBagConstraints.gridwidth = 1;
		
		
		botao.setPreferredSize(new Dimension (92,25));
		gridBagConstraints.gridy ++ ;
		jPanel.add(botao, gridBagConstraints);
		
		botao2.setPreferredSize( new Dimension(92,25));
		gridBagConstraints.gridx ++;
		jPanel.add(botao2 , gridBagConstraints);
		
		//executa a rotina Start
		botao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { // executa evento no botão
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				filaThread.setNome(mostraTempo.getText());
				filaThread.setEmail(mostraTempo2.getText());
				
				fila.add(filaThread);
			}
		});
		
		//executa a rotina Stop
		botao2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			
			}
		});
		
	
		fila.start(); 
		
		add(jPanel, BorderLayout.WEST);
		//Sempre será o ultimo comando
		setVisible(true);// torna a tela visivel
		
		
	}
	
		
		
		
	

}
