package cal;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora2 {

	public static void main(String[] args) {
		
		marco_calculadora2 calc2= new marco_calculadora2();
		calc2.setVisible(true);
		calc2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}  
}
class marco_calculadora2 extends JFrame
{
	public marco_calculadora2()
	{
		Toolkit mipantalla= Toolkit.getDefaultToolkit();
		Image mi_icono= mipantalla.getImage("src/graficos/java.png");		
		setIconImage(mi_icono);
		setVisible(true);
		setBounds(300,250,300,250);//el setbounds podria ser eliminado pero lo dejo por que aparece en el punto 0,0
		setTitle("Calculadora 2");
		lami_display2 lamina_pant2= new lami_display2();
		add(lamina_pant2);
		pack();//se adapta al tamano del contenido
	}
}
class lami_display2 extends JPanel
{
	private JPanel milami3 = new JPanel();//instanciamos la lamina afuera para que todos tengan acceso a ella 
	JButton pantalla2= new JButton("0");//iniciamos la variable y la dejamos afuera para que todos puedan tener acceso a ella
	private boolean principio;//instanciamos un variable para reemplazar el valor inicial 0 en lugar de que se concatenen despued de el
							  //se debe de iniciar la variable por que toda variable booleana no iniciada es false	
	
	private double resultado;//variable donde se ejecutaran las operaciones
	private String ultima_orden;//esta varible se usara para saber cual ha sido la ultima orden que ha presionado el usuario 
	
	public lami_display2()//el constructor solo se lee al incio de iniciar nuestro programa para hacer la lamina nunca mas lo vuelve a leer
	{
		principio= true;//o podemos iniciarla al inicio del constructor
		setLayout(new BorderLayout());//primera lamina y su disposicion
		add(pantalla2, BorderLayout.NORTH);//ubicacion lamina 1
		pantalla2.setEnabled(false);//deshabilita el boton
		
		//JPanel milami3 = new JPanel();//podemos crear una nueva instacia para hacer una nueva lamina es mas simple
		milami3.setLayout(new GridLayout(4,4));//llamamos al panel y seteamos el layout aplicamos un grid layout con 4 columnas y 4 filas
		//agregamos nuestros botones utilizando el metodo que hemos creado
		
		ActionListener inserta= new inser_num();//instanciamos la clase listener para insertar el numero
		ActionListener accion= new accion_order();//instnciamos la clase listener de la accion
		
		ponerBoton("7", inserta);//recordemos que al usar el metodo debemos de enviar un string que llenara la variable rotulo
		ponerBoton("8", inserta);
		ponerBoton("9", inserta);
		ponerBoton("/", accion);//division
		
		ponerBoton("4", inserta);
		ponerBoton("5", inserta);
		ponerBoton("6", inserta);
		ponerBoton("x", accion);//multiplicacion
		
		ponerBoton("1", inserta);
		ponerBoton("2", inserta);
		ponerBoton("3", inserta);
		ponerBoton("-", accion);//resta
		
		ponerBoton("0", inserta);
		ponerBoton(".", inserta);
		ponerBoton("+", accion);//suma
		ponerBoton("=", accion);//igual
		//detalla de que aqui va una linea que es ultima_orden="=" por que el programa no funciona sin ella a mi si por elroden de las lienas de codigo 
		add(milami3, BorderLayout.CENTER);//agregamos lamina 2
		ultima_orden="=";
	}
	private void ponerBoton(String rotulo, ActionListener oyente)//creamos metodo para crear los botones automaticamente, vacio por que no devolvera nada   
	{										//agregamos el action listener para que el boton escuhe que es lo que debe de hacer y eso sera igual para todos
		JButton calc_boton= new JButton(rotulo);
		calc_boton.addActionListener(oyente);//el boton sera el que escuche
		milami3.add(calc_boton);
	}
	private class inser_num implements ActionListener//insertar numero
{
	public void actionPerformed(ActionEvent e) {
		String entrada= e.getActionCommand();
		
		if (principio)//en una varible de comparacion si esta vacia asi como se ve lo tomara como true ya lo viste en otros casos como el for each que de una vez lo hace
		{
			pantalla2.setText(" ");
			principio=false;//aqui borramos el 0
		}
		
		pantalla2.setText(pantalla2.getText() + entrada);//concatenamos una nueva pantalla2. para que vaya poniendo los valores en nuestra pantalla 
	}
	
}
	private class accion_order implements ActionListener//accion de la calculadora
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			//calcular es un metodo que haremos 
			
			String opera=e.getActionCommand();//almacenamos un string que corresponde al texto del boton para saber que opercion se efectuara
			calcular(Double.parseDouble(pantalla2.getText()));//convertirmos el valor string de pantalla a uno numerico
			
			ultima_orden=opera;//aqui se almacenara la ultima operacion que el usuario ha realizado
			principio = true;//para no concatener el siguiente numero  
			
		}
		public void calcular(double x)//este metodo sera el encargado de hacer todas las operaciones del programa, le pasaremos un parametro que sera la variable con nuestros valores 
		{
			if (ultima_orden.equals("+"))//si boton que puslamos tiene string igual al if hara lo siguiente 
			{
				resultado+=x;
			}
			else if(ultima_orden.equals("-"))
			{
				resultado-=x;
			}
			else if(ultima_orden.equals("x"))
			{
				resultado*=x;	
			}
			else if(ultima_orden.equals("/"))
			{
				resultado/=x;
				
			}
			else if(ultima_orden.equals("="))//muetra el resultado de la operacion
			{
				resultado=x;
			}
			pantalla2.setText(""+resultado);//imprimimos el resultado en la pantalla
		}
		
	}
}


