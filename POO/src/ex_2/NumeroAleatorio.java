package ex_2;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class NumeroAleatorio extends JFrame 
{
		
	public int random() {
		Random gerador = new Random();
		return gerador.nextInt(101);
	}
	
	int aleatorio = random(), aux = -1;

	public int verificarN(JTextField caixa) {
		int numero =  Integer.parseInt(caixa.getText());
		int aux2 = numero - aleatorio;

		if (numero == aleatorio) {
			return 1;
		}
		else if (aux2 > 0 ) {
			aux = aux2;
			return 2;
		}
		else {
			aux = aux2;
			return 3;
		}
	}
	
	public NumeroAleatorio() 
   {	this.setTitle("Adivinhar um numero");
		this.setSize(450,300);
		this.setVisible(true);
		
		Container c = this.getContentPane();

		JPanel painel = new JPanel();
		c.add(painel);

		JLabel label = new JLabel("Eu tenho um número entre 1 e 100, você pode adivinhá-lo? Entre com seu chute!");
		painel.add(label);
		
		JTextField caixa = new JTextField(20);
		painel.add(caixa);
		
		
		JButton b1 = new JButton("Enviar");
		painel.add(b1);
		JButton b2 = new JButton("Criar novo jogo");
		b2.setVisible(false);
		painel.add(b2);
	

		b1.addActionListener((ActionListener) new ActionListener()     
		{	public void actionPerformed(ActionEvent e)
			{			       	
				
				
				int resultado = verificarN(caixa);
				if (resultado == 1) {
			        caixa.setEditable(false);
			        JOptionPane.showMessageDialog (null, "Parabéns! Você acertou!");
			        b2.setVisible(true);
					
				}
				else if (resultado == 2) {
					painel.setBackground(Color.RED);
			        JOptionPane.showMessageDialog(null, "Atras");

				}
				else {
					painel.setBackground(Color.BLUE);
			        JOptionPane.showMessageDialog(null, "Na frente");

				}
			
		}});
	
		b2.addActionListener(new ActionListener()    	
		{	public void actionPerformed(ActionEvent e)
			{		
				aleatorio = random();
				aux = -1;
				caixa.setEditable(true);
				caixa.setText("");
				painel.setBackground(Color.GREEN);		
		}});
		
	}
    public static void main(String args[]) {
        new NumeroAleatorio();
}

}