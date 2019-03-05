import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericType <T> {
    private T[] array;

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    GenericType(T[] array){
        this.array = array;
    }

    public T[] changeElements(int index1, int index2){
       T object;
       T[] array = Arrays.copyOf(this.array, this.array.length);
       object = array[index1];
       array[index1] = array[index2];
       array[index2] = object;
       return array;
    }

    public void customPrintArray(){
        for (int i = 0; i < array.length; i++){
            System.out.println("<"+(i+1)+">"+" = "+ "<"+array[i].toString()+">");
        }
    }

    public void printArray(T [] array){
        System.out.println(Arrays.toString(array));
    }

    public T[] reverseArray(){
        T[] rArray = Arrays.copyOf(array,array.length);
        for (int i = 0; i < rArray.length; i++){
            rArray[i] = array[array.length-i-1];
        }
        return rArray;
    }
}

