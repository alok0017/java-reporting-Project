package view;


import java.util.List;
import java.awt.*;
import java.awt.event.*; 

import javax.swing.*;

import org.jfree.chart.plot.*;  
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import model.Classe;

public class MainFrame extends JFrame 
 {
	/**
	 * 
	 */
	private static final long serialVersionUID = -447998472145987202L;
	

	// table d'association reliant les animaux et les boutons
	//HashMap<Graphe, JButton> associationsAnimauxBoutons;
	

	// liste des composant
	JTextArea jta_textAreaRequeteSql; // une zone de texte pour la requete sql	
	private JPanel jpnl_Graph;  // un panneau pour dessiner le graphique
	private JPanel jpnl_Buttons; // un panneau pour les boutons graphiques
	private JPanel jpnl_Sql;// un panneau pour la saisie de la requete sql
	private JLabel jlb_requete;//afficher 
	
	private JButton jbtn_pie;    // bouton pour graohique camambert
	private JButton jbtn_histogram; // bouton pour histogramme
	private JButton jbtn_execute_requete; // bouton pour histogramme

	// table d'association reliant les graphique et les boutons
	List<Classe> school;
	

	public MainFrame(List<Classe> pschool ) {  
		// appel au constructeur de la classe parente JFrame
		super("Reporting tool");
		school =pschool;
		
		setSize(790, 480);  
	    setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		
		jbtn_pie=new JButton("Pie");
		jbtn_pie.setSize(20,50);

		jbtn_histogram=new JButton("Histogram");
		jbtn_histogram.setSize(20,50);

		
		
		// gestionnaire de placement de la fenetre principale
		// en GridLayout sur 2 colonnes
		// le 0 en 1er paramÃ¨tre prÃ©cise que le nb de lignes est extensible
		// on espace les composants de 5 en horizontal et 2 en vertical
		this.setLayout(new BorderLayout());
		
		//gestionnaire des placement des bouton 
		jpnl_Buttons = new JPanel();//new GridLayout(0,1));	
		jpnl_Buttons.setLayout(new GridLayout(10,1));
		jpnl_Buttons.add(jbtn_pie);
		jpnl_Buttons.add(jbtn_histogram);	
		
				
		//gastionnaire pour la requete sql
		jta_textAreaRequeteSql = new JTextArea();
		jlb_requete= new JLabel("SQL Query: ");
		jbtn_execute_requete = new JButton("Execute"); 
		jpnl_Sql= new JPanel(new BorderLayout());
		jpnl_Sql.add(jlb_requete,BorderLayout.WEST);
		jpnl_Sql.add(jta_textAreaRequeteSql,BorderLayout.CENTER);
		jpnl_Sql.add(jbtn_execute_requete ,BorderLayout.EAST);
	
		
		jpnl_Graph = new JPanel(); 
	   
	

	     
	     this.add(jpnl_Graph, BorderLayout.EAST);
	     this.add(jpnl_Buttons, BorderLayout.WEST);
	     this.add(jpnl_Sql, BorderLayout.SOUTH);
	     
	  
	     /***************ecouteurs evenements ************/
	 	jbtn_pie.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!school.isEmpty())
				  afficherPieGraphique(school);
				else 
				  JOptionPane.showConfirmDialog(null,
						  "Press the Execute key ...", "Please enter the data.",
						  javax.swing.JOptionPane.PLAIN_MESSAGE);
			}
		});
	     
	     
	 	jbtn_histogram.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!(school.isEmpty()))
				  afficherHistogrammGraphique(school);
				else
				{
					JOptionPane.showConfirmDialog(null,
							"Press the Execute key ...", "Please enter the data.",
							  javax.swing.JOptionPane.PLAIN_MESSAGE);
				}
					
			}
		});
	 	
	     
	 	jbtn_execute_requete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				school.add(new Classe("first year", 295,269));
				school.add(new Classe("second year", 190,203));
				school.add(new Classe("third year", 128,174));
			}
		});
	 	
	     // un evenement particulier, la fermeture de la fenetre principale
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		addWindowListener(new WindowAdapter() {       
				       public void windowClosing(WindowEvent e) {         
					      dispose();        
					      System.exit(0);     
				      }      
		}
	);
	}		
			
			
			
		
	/****************histogramme****************/
	public void afficherHistogrammGraphique(List<Classe> school){
	DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
	for (Classe c : school){
		  dataset.addValue(new Integer(c.getNbBoys()), c.getName(),"");   
		  dataset.addValue(new Integer(c.getNbBoys()), c.getName(),"");  
		  dataset.addValue(new Integer(c.getNbBoys()), c.getName(),"");   
		}
	    JFreeChart barChart = ChartFactory.createBarChart("Distribution of boys by class", "",       
			"number of boys", dataset, PlotOrientation.VERTICAL, true, true, false);  	
			ChartPanel cPane2 = new ChartPanel(barChart); 
			jpnl_Graph.removeAll();
			 jpnl_Graph.add(cPane2);
		     this.pack();
	}
	/**************************************************************/		
			
	/********** camembert **********/
	public void afficherPieGraphique(List<Classe> school){
		DefaultPieDataset pieDataset = new DefaultPieDataset(); 
		
		for (Classe c : school){
		  pieDataset.setValue(c.getName(), new Integer(c.getNbGirls()));   
		  pieDataset.setValue(c.getName(), new Integer(c.getNbGirls()));  
		  pieDataset.setValue(c.getName(), new Integer(c.getNbGirls()));   
		}	   
		JFreeChart pieChart = ChartFactory.createPieChart("Distribution of girls by class",pieDataset, true, true, false);     
		ChartPanel cPane1 = new ChartPanel(pieChart);
		jpnl_Graph.removeAll();
		jpnl_Graph.add(cPane1);
		this.pack();
	}
	/*********************************************/
}

