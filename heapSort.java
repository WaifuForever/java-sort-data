import java.util.Arrays;
public class heapSort {

    public static void main(String[] args) {
          
           int[] dados = {16,7,22,3,19,9,36,11};

           heapSort heap = new heapSort();
               heap.sort(dados,dados.length);
           System.out.println(Arrays.toString(dados));
    }
    public void sort(int[] dados, int size) {
           for(int i= size/2-1;i>=0;i--) {
              montar(dados,size,i);
          }
           for(int i=size-1;i>=0;i--) {
                int time = dados[0];
                dados[0] = dados[i];
                dados[i] = time;
              montar(dados, i,0);
          }
    }
    public void montar(int[] dados, int size, int i) {  
           int largest = i; 
           int left = (2*i)+1; 
           int right = (2*i)+2; 

           if(left<size && dados[left]> dados[largest]) { 
                largest = left; 
          }
           if(right<size && dados[right]> dados[largest]) {
                largest = right; 
          }
           if(largest!= i) {
                int time = dados[i];
                dados[i] = dados[largest];
                dados[largest] = time;   
              montar(dados, size, largest); 
          }
    }
}