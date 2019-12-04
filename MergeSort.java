import java.util.Stack;

public class MergeSort {
    private  static class function{
        public boolean isMerge;
        public int start;
        public int end;

    }

    private Stack<function> stack=new Stack<>();
    void Merge(int []A, int start, int middle, int end)
    {

        int n1,n2,i,j,k;
        n1= middle - start + 1;
        n2= end - middle;
        int []L=new int[n1];
        int []R=new int[n2];
        for(i=0;i<n1;i++)
        {
            L[i]=A[start + i];
        }
        for(j=0;j<n2;j++)
        {
            R[j]=A[middle + j + 1];
        }
        i=0;
        j=0;

        for(k=start; i < n1 && j < n2; k++)
        {
            if(L[i]<R[j])
            {
                A[k]=L[i++];
            }
            else
            {
                A[k]=R[j++];
            }
        }

        while(i<n1)
        {
            A[k++]=L[i++];
        }

        while(j<n2)
        {
            A[k++]=R[j++];
        }

    }
    void execution(int []arr, function f )
    {
        if(f.isMerge==true || f.end-f.start<=1)Merge(arr, f.start, (f.start+f.end)/2, f.end);
        else if(f.end==f.start)return;
        else PushToStack(f);
    }

    void PushToStack(function f)
    {
        int middle;
        middle= (f.start + f.end) / 2;

        function f1=new function();
        function f2=new function();
        function f3=new function();


        f1.end=middle;
        f1.start=f.start;
        f1.isMerge=false;

        f2.end=f.end;
        f2.start=middle+1;
        f2.isMerge=false;

        f3.end=f.end;
        f3.start=f.start;
        f3.isMerge=true;
        this.stack.push(f3);
        this.stack.push(f2);
        this.stack.push(f1);

    }
    void mergeSort(int []Arr, int start, int end)
    {
        function f=new function();
        f.start=start;
        f.end=end;
        f.isMerge=false;

        this.stack.push(f);
        function load=null;
        while(!this.stack.empty()){
        load=stack.peek();
        stack.pop();
        execution(Arr, load);

    }

    }
    public static void main(String arg[])
    {
        MergeSort m=new MergeSort();
        int []arr={3,6,9,10,5,2,1,4,7,10};
        int end=arr.length-1;
        m.mergeSort(arr, 0, end);
       for (int i=0; i<end+1; i++)
            System.out.print(arr[i]+ " ");
    }

}
