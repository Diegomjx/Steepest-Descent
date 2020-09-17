import java.util.Scanner;
public class ejemplo{
// como se deveria ver la funcion y el gradiente:
// f(x, y) = 2x^2+y^2
// grad f(x,y)= [4x,2y]

// g(x,y) = 5x^2+y^2+4xy-14x-6y+20
// grad g(x,y) = [10x+4y-14 , 2y+4x-6]
private static double alfa;
	public static void  main(String[] args) {
		int option = -1;
		double[] initial0 = {0,0};
		while(option!=3){
		System.out.println("//--------------------------\n1.funcion 1\n2.funcion 2\n3.exit\n//--------------------------");
        Scanner scan = new Scanner(System.in);
        try{ option = scan.nextInt();} catch(Exception e){ option = -1;}
           switch (option) {
                	case 1:
                	System.out.println("//--------------------------\n1.Step-size constante\n2.Step-size variable\n//--------------------------");
                            try{ option = scan.nextInt();} catch(Exception e){ option = -1;}
                             switch (option) {
                             	case 1: 
                             	System.out.println("valor de alfa:");
                             	try{ alfa = scan.nextDouble();} catch(Exception e){ option = -1;}
                                try{ 
                                	System.out.println("valor de x:");  
                                	initial0[0] = scan.nextDouble();
                                	System.out.println("valor de y:");  
                                	initial0[1] = scan.nextDouble();
                                	Steepest_Descent_F1_constante(initial0);

                                   } catch(Exception e){ option = -1;}
                             	

                             	break;

                             }

                	break;
                	case 2:
                	System.out.println("//--------------------------\n1.Step-size constante\n2.Step-size variable\n//--------------------------");
                            try{ option = scan.nextInt();} catch(Exception e){ option = -1;}
                             switch (option) {
                             	case 1: 
                             	System.out.println("valor de alfa:");
                             	try{ alfa = scan.nextDouble();} catch(Exception e){ option = -1;}
                                try{ 
                                	System.out.println("valor de x:");  
                                	initial0[0] = scan.nextDouble();
                                	System.out.println("valor de y:");  
                                	initial0[1] = scan.nextDouble();
                                	Steepest_Descent_F1_constante(initial0);

                                   } catch(Exception e){ option = -1;}
                             	

                             	break;

                             }
                	break;

        	
           }
        }
		
	}

	public static double[] grad_F1(double[] arreglo ){
		double[] flag = {0,0};
		double x = arreglo[0], y = arreglo[1] ;
		flag[0]= 50*x;
		flag[1]= 2*y;
		return flag;
	}

	public static double[] grad_F2(double[] arreglo ){
		double[] flag = {0,0};
		double x = arreglo[0], y = arreglo[1] ;
		flag[0]= 10*x+4*y-14;
		flag[1]= 2*y+4*x-6;
		return flag;
	}

	public static double norma(double[] gradiante){
    	return Math.sqrt(Math.pow(gradiante[0],2)+Math.pow(gradiante[1],2));
    }

    public static double[] Xk(double[] xk,double[] gradiante){
    	double[] flag = {0,0};
    	flag[0] = xk[0]-alfa*gradiante[0];
    	flag[1] = xk[1]-alfa*gradiante[1];
    	return flag;
    }

    public static void Steepest_Descent_F1_constante(double[] initial){
    	double[] gradiante = grad_F1(initial);
    	double k =0;
    	double[] xk = initial;
    	while ( k< 1000 &&  norma(gradiante) > Math.pow(10,-8)) {
    		if(alfa>0)
    			gradiante = grad_F1(xk);
    		xk=Xk(xk, gradiante);
    		k++;
    	}
    	System.out.println("\n/-------------------------------");
    	System.out.println("(a) Numero de iteracion:"+k);
    	System.out.println("(b) xk= ["+xk[0]+","+xk[1]+"]");
    	System.out.println("(c) Direccion: ["+ +gradiante[0]+","+gradiante[1]+"]");
        System.out.println("(d) Norma: "+norma(gradiante));
        System.out.println("/-------------------------------\n");
    } 
    public static void Steepest_Descent_F2_constante(double[] initial){
    	double[] gradiante = grad_F2(initial);
    	double k =0;
    	double[] xk = initial;
    	while ( k< 1000 &&  norma(gradiante) > Math.pow(10,-8)) {
    		if(alfa>0)
    			gradiante = grad_F2(xk);
    		xk=Xk(xk, gradiante);
    		k++;
    	}
    	System.out.println("\n/-------------------------------");
    	System.out.println("Numero de iteracion:"+k);
    	System.out.println("xk= ["+xk[0]+","+xk[1]+"]");
    	System.out.println("(c) Direccion: ["+ +gradiante[0]+","+gradiante[1]+"]");
    	System.out.println("Norma: "+norma(gradiante));
    	System.out.println("/-------------------------------\n");

    }
    
}