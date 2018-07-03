package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import controle.Controle;
import controle.Controle_validador;

public class View extends JFrame {
	
	private JButton botaoImportar;
	private JButton botaoCriar;
	private JButton botaoValidar;
	private static UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();
	private static String look = looks[3].getClassName();
	private JLabel label = new JLabel("A.C.A");
	private JLabel img;
	private File cacheFolder = null;

	public View() {
		
		getContentPane().setBackground(new Color(51, 102, 153));
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(View.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		
		try {
			UIManager.setLookAndFeel(look);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		
		
		getContentPane().setLayout(null);
		
		botaoCriar = new JButton("Criar Movimento");
		botaoCriar.setBackground(new Color(102, 153, 204));
		botaoCriar.addActionListener(null);
		botaoCriar.setBounds(10, 10, 200, 30);
		getContentPane().add(botaoCriar);
		
		botaoImportar = new JButton("Ler Movimento");
		botaoImportar.setBackground(new Color(102, 153, 204));
		botaoImportar.setActionCommand("importar");
		botaoImportar.addActionListener(new BotaoAcao());
		botaoImportar.setBounds(10, 50, 200, 30);
		getContentPane().add(botaoImportar);
		
		botaoValidar = new JButton("Validar Movimento");
		botaoValidar.setBackground(new Color(102, 153, 204));
		botaoValidar.setActionCommand("validar");
		botaoValidar.addActionListener(new BotaoAcao());
		botaoValidar.setBounds(10, 90, 200, 30);
		getContentPane().add(botaoValidar);
		
	
		
		label.setFont(new Font("Calibri", 1, 11));
		label.setToolTipText("V2.0");
		label.setBounds(500, 120,100, 10);
		
		
		ImageIcon logo = new ImageIcon(this.getClass().getResource("/excelsior.png"));
		
		
		img = new JLabel(logo);
		
		img.setBounds(250, 30, 241, 79);
		
	
		getContentPane().add(label);
		getContentPane().add(img);
		
		setBounds(10, 10, 540, 160);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
	}
	
	 class BotaoAcao implements ActionListener {

		private JFileChooser file;

		@Override
		public void actionPerformed(ActionEvent act) {
			
			file = new JFileChooser(); 
			file.setFileSelectionMode(JFileChooser.FILES_ONLY);
			file.setMultiSelectionEnabled(true);
			if(cacheFolder != null) file.setCurrentDirectory(cacheFolder);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos Txt (*.txt)", "txt");
			file.addChoosableFileFilter(filter);
			file.setAcceptAllFileFilterUsed(false);  
			int i = file.showOpenDialog(null);
			
			
			if (i==1){
				JOptionPane.showMessageDialog(null, "Nenhum arquivo selecionado.");
				}else{
				  File arquivo[] = file.getSelectedFiles();
				  cacheFolder = file.getSelectedFile();
				 // enderecoRo.setText(Controle.retornaConteudo(arquivo.getPath()));
				  
				  for (File file : arquivo) {
					
					  
					  if(file.isFile()){
						  
					 		Controle.getInstance().receberArquivo(file, act.getActionCommand());
					 		
					  }else{
						  JOptionPane.showMessageDialog(null, "Arquivo não existe!");
					 
				  }
				  }
				}
		
		}
		
	}
}
