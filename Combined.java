Prg-1
package daa_lab_set;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Prg_1 {
static final int MAX= 10005;
static int[] a= new int[MAX];
static int[] b= new int[MAX];
public static void main(String[] args) {
Scanner input= new Scanner(System.in);
//to get the number of input
System.out.print("Enter Max array size: ");
int n= input.nextInt();
//initializing the random instance
Random random= new Random();
System.out.println("enter the choice::\n1.user input\n2.random");
int ch=input.nextInt();
/*the choice is optional we can directly take the random value*/
if(ch==1) {//user input
System.out.println("Enter the array elements: ");
for(int i= 0; i< n; i++)
a[i] =input.nextInt();
}
if(ch==2) {//random
System.out.println("the input array elements are: ");
for(int i= 0; i< n; i++)
a[i] = random.nextInt(1000);
}
//copying the elts of a in b for quick sort
b=Arrays.copyOf(a, n);
//print the input values
for(int i= 0; i< n; i++)
System.out.print(a[i] + " ");
System.out.println();
//time take by merge sort
long startTime= System.nanoTime();
MergeSortAlgo(0, n-1);
long stopTime= System.nanoTime();
long elapsedTime= stopTime-startTime;
System.out.println("Time Complexity (ms) for n [Merge sort]= "+ n+ " is : "+
(double)elapsedTime/ 1000000);
//printing input values for quick sort
for(int i=0;i<n;i++)
System.out.print(b[i]+" ");
System.out.println();
//time taken for quick sort
long startTime1= System.nanoTime();
QuickSortAlgorithm(0, n-1);
long stopTime1= System.nanoTime();
long elapsedTime1= stopTime1-startTime1;
System.out.println("Time Complexity (ms) for n[quick sort] = "+ n+ " is : "+
(double)elapsedTime1/ 1000000);
//printing the time difference
double res=((double)elapsedTime/ 1000000)-((double)elapsedTime1/ 1000000);
System.out.println("the difference in time:: time(merge)-time(quick)= "+res);
//printing the sorted elements
System.out.println("Sorted Array (Merge Sort):");
for(int i= 0; i< n; i++)
{System.out.print(a[i] + " ");
}
System.out.println("\nSorted Array (quick Sort):");
for(int i= 0; i< n; i++)
{System.out.print(b[i] + " ");
}
input.close();
}
public static void MergeSortAlgo(int low, int high) //works on the array a
{
int mid;
if(low< high)
{
mid = (low + high) / 2;
MergeSortAlgo(low, mid);
MergeSortAlgo(mid+ 1, high);
Merge(low, mid, high);
}
}
public static void Merge(int low, int mid, int high)
{
int[] b= new int[MAX];
int i, h, j, k;
h= i= low;
j= mid+ 1;
while((h<= mid) && (j<= high))
if(a[h] < a[j])
b[i++] = a[h++];
else
b[i++] = a[j++];
if(h> mid)
for(k= j; k<= high; k++)
b[i++] = a[k];
else
for(k= h; k<= mid; k++)
b[i++] = a[k];
for(k= low; k<= high; k++)
a[k] = b[k];
}
public static void QuickSortAlgorithm(int p, int r) //works on array b
{
int i, j, temp, pivot;
if(p< r)
{
i= p;
j= r;
pivot= b[p];
while(true)
{
i++;
while(b[i] < pivot&& i<r)
{
i++;
}
while(b[j] > pivot)
{
j--;
}
if(i< j)
{
temp= b[i];
b[i] = b[j];
b[j] = temp;
}
else
{
break;
}
}
b[p] = b[j];
b[j] = pivot;
QuickSortAlgorithm(p, j-1);
QuickSortAlgorithm(j+ 1, r);
}
}
}
