
import java.lang.Math;
 // you can use Math.random() function for assigning a random value between 0.0 - 1.0
import java.util.Random; 

 public class Matrix {
 private int r;
 private int c;
 private int[][] data;
 


 

public int getR() {
	return r;
}

public void setR(int r) {
	this.r = r;
}

public int getC() {
	return c;
}

public void setC(int c) {
	this.c = c;
}

public int[][] getData() {
	return data;
}


public void setData(int[][] data) {
	
	
	this.data=data;
	
	    }
public void setColumn(int [] column,int idx) {
	
	for(int i=0; i<r;i++)
		data[i][idx]=column[i];
}
public void setRow(int [] row,int idx) {
	
	for(int i=0; i<c;i++)
		data[idx][i]=row[i];
	
}
public void getColumn(int idx) {
	
	for(int i=0; i<r;i++)
		System.out.print(this.getData()[i][idx] + " \n");
		
}
public void getRow(int idx) {
	
	for(int i=0; i<c;i++)
		System.out.print(this.getData()[idx][i] + " | ");
	System.out.println();
	
}
	   
public Matrix() {
	super();
	this.setR(3);
	this.setC(3);
	this.data=new int[r][c];
	
	for(int i = 0; i < r; i++)
	{
	    for(int j = 0; j < c; j++)
	    {
	    	this.data[i][j]=0;
	       
	    }
	}

	
}


public Matrix(int r, int c, int[][] data) {
	super();
	this.r = r;
	this.c = c;
	this.data = data;
}




// create R-by-C matrix of 0's
public Matrix(int r, int c) {
	
	int[][] arr = new int[r][c]; 


	for(int i = 0; i < r; i++)
    {
        for(int j = 0; j < c; j++)
        {
        
           arr[i][j] = 0;
            
        }
    }

 this.setData(arr);
	this.setR(r);
	this.setC(c);
}
   





// create matrix based on 2d array
public Matrix(int[][] data) {
	
r=data.length;
c=data[0].length;
this.data=new int[r][c];

for(int i = 0; i < r; i++)
{
    for(int j = 0; j < c; j++)
    {
    	this.data[i][j]=data[i][j];
       
    }
}

	      
	}

 

 // create and return a random R-by-C matrix with values between 0 and 100
 public  Matrix random(int r, int c) {
	 
	 
	 // create instance of Random class 
     Random rand = new Random(); 

     
    	
	// create Matrix object
    Matrix mat=new Matrix(r,c);
    
    
    int[][]array =mat.getData();
   

	for(int i = 0; i < r; i++)
    {
        for(int j = 0; j < c; j++)
        {
        	// Generate random integers in range 0 to 100
            int	rand1= rand.nextInt(100)+1; 
            array[i][j]=rand1;
            
           
        }
    }
	 mat.setData(array);
	
	mat.show();
    
    return mat;
	 
 }




 // return C = A + B (matrix addition)
 public Matrix add(Matrix B) {
	 
	 int i, j;
	 int[][] sum = new int[B.getR()][B.getC()];
	 
	 
	 
	 Matrix C=new Matrix(this.getR(),this.getC());
	

if(this.getR()==B.getR() && this.getC()==B.getC()) {
	C.setR(this.r);
	C.setC(this.c);
     for (i = 0; i < this.getR(); i++) {
         for (j = 0; j < this.getC(); j++) {
        	 sum[i][j] = this.getData()[i][j]+B.getData()[i][j];
        	 
         }
         }
      
     C.setData(sum);
     
     return C;

 }
else
{
	
throw new RuntimeException("Sizes do not match!");


}
 }
 

 // return C = A - B (matrix subtraction)
public Matrix subtract(Matrix B) {
	
	int i, j;
	 int[][] sum = new int[B.getR()][B.getC()];
	 
	 
	 Matrix sub_matrix=new Matrix(this.getR(),this.getC());
	 
	 if(this.getR()==B.getR() && this.getC()==B.getC()) {

    for (i = 0; i < B.getR(); i++) {
        for (j = 0; j < B.getC(); j++) {
       	 sum[i][j] = this.getData()[i][j]-B.getData()[i][j];
       	 
        }
        }
     
    sub_matrix.setData(sum);
    
    return sub_matrix;
	 }
	 else
	 {
	 	
	 throw new RuntimeException("Sizes do not match!");

	 }
	
}


 // return C = A * B (matrix multiplication)
 public Matrix multiply(Matrix B) {
 
	 Matrix multiply_matrix=new Matrix(this.getR(),this.getC());
	 
	 multiply_matrix.setR(this.getR());
	 multiply_matrix.setC(B.getC());

     int C[][] = new int[this.getR()][B.getC()]; 
     
     
		
	// Check if multiplication is Possible 
     if (B.getR()!= this.getC()) { 

         System.out.println( 
             "\nMultiplication Not Possible"); 
         return null;
        
     } 
     else {

     // Multiply the two matrices 
     for (int i = 0; i < this.getR(); i++) { 
         for (int j = 0; j < B.getC(); j++) { 
             for (int k = 0; k < B.getR(); k++) 
                 C[i][j] += this.getData()[i][k] * B.getData()[k][j]; 
         } 
     } 

     multiply_matrix.setData(C);
     
    
		
		return multiply_matrix;

     }
	 
 }
 
 
 // print the data of a matrix
 public void show() {
	 for(int i=0;i<data.length;i++){
         for(int j=0;j<data[0].length;j++){
             System.out.print(data[i][j] + " | ");
         }
         System.out.println();
     }
 }

 
 
 // prints the fizzBuzz output for a matrix’s first row
 public void fizzBuzz() {

	 for (int i=0; i<this.r; i++)   
		 
     {
		 
         //number divisible by 15(divisible by
         // both 3 & 5), print 'FizzBuzz' in
         // place of the number
         if (this.getData()[0][i]%15==0)                                                 
             System.out.print("FizzBuzz"+" "); 
         // number divisible by 5, print 'Buzz' 
         // in place of the number
         else if (this.getData()[0][i]%5==0)     
             System.out.print("Buzz"+" "); 

         // number divisible by 3, print 'Fizz' 
         // in place of the number
         else if (this.getData()[0][i]%3==0)     
             System.out.print("Fizz"+" ");
              
         else // print the numbers
             System.out.print(this.getData()[0][i]+" ");                         
     }
 }
	 
	 
	 
 static boolean isPrime(int n)
 {

     // Check if number is less than
     // equal to 1
     if (n <= 1)
         return false;

     // Check if number is 2
     else if (n == 2)
         return true;

     
     for (int i = 2; i <n; i ++) 
     {
         if (n % i == 0)
             return false;
     }
     
     return true;
 }

	 

 // prints the extended optimusPrime output for a matrix’s first row
 public void optimusPrime() {

	 
for (int i=0; i<this.r; i++)   
		 
     {
	
         if (this.isPrime(this.getData()[0][i]))  {  
        	 
         
         if (this.getData()[0][i]%5==0  || this.getData()[0][i]%3==0)    
        	 
             System.out.print("Optimus Prime"+" "); 
         
         else
        	 System.out.print("Prime"+" "); 

         }
         else // print the numbers
             System.out.print(this.getData()[0][i]+" ");                         
     }
	 
	 
	 
	 
	 
 }
 
 public static void main(String[]args) {
	 
	 System.out.println("Matrix Constructor:"); 
	 Matrix k=new Matrix();
	 k.show();
	 System.out.println(); 
	 
	 
	 
	 System.out.println("Matrix  of 0's:"); 
	 Matrix m=new Matrix(3, 4);
	 m.show();
	 System.out.println(); 
	 
	        int mat[][] = { { 1, 2, 3 ,89},
	                        { 5, 6, 7  ,67},
	                        { 9, 10, 11 ,56 } };
	    
	 System.out.println("Matrix 2D array:"); 
	 Matrix m2=new Matrix(mat);
	 m2.show();
	 System.out.println();
	 System.out.println(); 
	 
	 System.out.println("GetColumn Method:"); 
	 m2.getColumn(3);
	 System.out.println();
	 System.out.println();
	 
	 System.out.println("GetRow Method:"); 
	m2.getRow(2);
	System.out.println();
	
	
	 System.out.println("Matrix1 with random datas:"); 
	 Matrix matrix_random=new Matrix(3,4);
	 matrix_random=matrix_random.random(3, 4);
	 System.out.println(); 
	  
	 
	 System.out.println("Matrix2 with random datas:"); 
	 Matrix matrix_random2=new Matrix(3,4);
	 matrix_random2=matrix_random2.random(3, 4); 
	 System.out.println(); 
	 
	 
	 Matrix matrix_add=new Matrix(3,4);
	 matrix_random.add(matrix_random2);
	 System.out.println("ADDITION [Matrix1] + [Matrix2] : \n"); 
	 matrix_random.add(matrix_random2).show();
	 System.out.println(); 
	 
	 
	 Matrix matrix_sub=new Matrix(3,4);
	 matrix_random.subtract(matrix_random2);
	 System.out.println("SUBSTRACTION   [Matrix1]- [Matrix2] :"+"\n");
	 matrix_random.subtract(matrix_random2).show();
	 System.out.println();
	 
	 
	 System.out.println("Matrix3 with random datas:"); 
	 Matrix matrix_random3=new Matrix(3,3);
	 matrix_random3=matrix_random3.random(3,3);
	 System.out.println(); 
	 
	 
	 
	 System.out.println("MULTIPLICATION   [Matrix3]*[Matrix2] :"+"\n");
	 matrix_random3.multiply(matrix_random2).show();
	 
	 System.out.println("\nFIZZBUZZ   OUTPUT for a [Matrix3]’s FIRST ROW  :"+"\n");
	 matrix_random3.fizzBuzz();
	 System.out.println();
	 
	 
	 System.out.println("\nOPTIMUS PRIME   OUTPUT for a [Matrix3]’s FIRST ROW  :"+"\n");
	 matrix_random3.optimusPrime();
	 
	 
 }
 
 

 
 

 }