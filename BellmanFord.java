import java.util.*;
public class BellmanFord {
	int D[]=new int [20];
	static int A[][]=new int [20][20];
	static int n;
	static final int MAX=999;
	public void findShortestPath(int s)
	{
		for(int i=1;i<=n;i++)
		{
			D[i]=999;
		}
		D[s]=0;
		int i,j,k;
		for(i=1;i<=n;i++)
		System.out.println(D[i]);
		for(k=1;k<=n-1;k++)
		{
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					if(A[i][j]!=999)
					{
						if(D[j]>D[i]+A[i][j])
						{
							D[j]=D[i]+A[i][j];
						}
					}
				}
			}
		}
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n;j++)
				{
					if(A[i][j]!=999)
					{
						if(D[j]>D[i]+A[i][j])
						{
							System.out.println("Graph contains negative edge cycle");
							return;
						}
					}
				}
			}
		System.out.println("The shortest  path information from source "+s);
		for(i=1;i<=n;i++)
			System.out.println("from "+s+" "+"to "+i+"="+D[i]);
		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of nodes");
		n=sc.nextInt();
		System.out.println("Enter the elements");
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				A[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		BellmanFord b=new BellmanFord();
		System.out.println("Enter the source");
		int s=sc.nextInt();
		b.findShortestPath(s);
	}
}
