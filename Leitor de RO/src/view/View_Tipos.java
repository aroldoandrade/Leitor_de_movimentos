package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controle.Controle;
import model.Arquivo;
import model.Arquivo_10;

public class View_Tipos extends JFrame {
	private JLabel labelLinha;
	private JEditorPane editorPane;
	private JLabel numeroLinhas;
	

	public View_Tipos(Arquivo arquivo, boolean relativo) {

		
		super(arquivo.getNome());
		getContentPane().setBackground(new Color(51, 102, 153));
		
		
		numeroLinhas = new JLabel("");
		numeroLinhas.setBounds(71, 14, 46, 14);
		getContentPane().add(numeroLinhas);
	
		
		labelLinha = new JLabel("Linhas:");
		labelLinha.setBounds(20, 14, 176, 14);
		getContentPane().add(labelLinha);
		
		labelLinha.setText("Linhas: "+arquivo.getContagem());
		
		
		
		editorPane = new JEditorPane();
		editorPane.setBackground(new Color(102, 153, 204));
		editorPane.setEditable(false);
		//editorPane.setBounds(20, 39, 320, 311);
		editorPane.setText("Nome do Arquivo:\n"+arquivo.getNome()+"\n\n"+arquivo.getResumo());
		
		final JScrollPane scrollPane = new JScrollPane(editorPane);
		scrollPane.setBounds(20, 39, 320, 411);
		getContentPane().add(scrollPane);
		
		
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(10, 10, 370, 500);
		if(relativo)
		setLocationRelativeTo(null);
		else {}
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Exportar Excel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Controle.getInstance().MontarExcel(arquivo);

			}
		});
		btnNewButton.setBounds(210, 10, 130, 23);
		getContentPane().add(btnNewButton);
		
		JButton Copy = new JButton("Nome");
		Copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				 String text = arquivo.getNome();
				 StringSelection selection = new StringSelection(text);
				 clipboard.setContents(selection, null);

			}
		});
		Copy.setBounds(120, 10, 80, 23);
		getContentPane().add(Copy);
		
		
		setResizable(false);
		setVisible(true);
		
		
	}
	
	
}
