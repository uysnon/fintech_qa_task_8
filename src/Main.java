import java.util.Scanner;

public class Main {
    final  static private Integer[] INTEGER_ARRAY = {-34, 43, 3, 54, 23, 5, 234 ,91110397, -4};
    final static private Double[] DOUBLE_ARRAY = {46.34, -34345.35, 88.1, 83.0};
    final static private String[] STRING_ARRAY = {"Кто", "Когда", "Куда", "Откуда", "Почему", "Зачем", "и", "Как", "?"};
    final static private Boolean [] BOOLEAN_ARRAY = {true, false, false, false, true, false, true, true};
    final static private CustomType[] CUSTOM_TYPE_ARRAY = {new CustomType(), new CustomType("Что-то"), new CustomType("И еще что-нибудь")};
    public static void main(String[] args) {
        int numVariation = 0;
        Scanner scanner = new Scanner(System.in);
        while (numVariation != 6) {
            System.out.println("Выберите тип данных для массива :" +
                    "\n1. Integer" +
                    "\n2. Double" +
                    "\n3. String" +
                    "\n4. Boolean" +
                    "\n5. CustomType" +
                    "\n6. Выход");
            do {
                numVariation = scanner.nextInt();
            }while (numVariation < 1 || numVariation > 6);
            if (numVariation == 1){
                GenericType<Integer> genObject = new GenericType<>(INTEGER_ARRAY);
                outPutInfoGeneric(genObject);
                outPutChangeElementsArray(genObject,scanner);
            }
            if (numVariation == 2){
                GenericType<Double>genObject = new GenericType<>(DOUBLE_ARRAY);
                outPutInfoGeneric(genObject);
                outPutChangeElementsArray(genObject,scanner);
            }
            if (numVariation == 3){
                GenericType<String> genObject = new GenericType<>(STRING_ARRAY);
                outPutInfoGeneric(genObject);
                outPutChangeElementsArray(genObject,scanner);
            }
            if (numVariation == 4){
                GenericType<Boolean> genObject = new GenericType<>(BOOLEAN_ARRAY);
                outPutInfoGeneric(genObject);
                outPutChangeElementsArray(genObject,scanner);
            }
            if (numVariation == 5){
                GenericType<CustomType> genObject = new GenericType<>(CUSTOM_TYPE_ARRAY);
                outPutInfoGeneric(genObject);
                outPutChangeElementsArray(genObject,scanner);
            }

        }
        scanner.close();
    }

    private static void outPutInfoGeneric(GenericType genericType){
        System.out.println("1.Кастомный вывод массива:");
        genericType.customPrintArray();
        System.out.println();
        System.out.println("2. Вывод обратного массива:");
        genericType.printArray(genericType.reverseArray());
        System.out.println();
    }

    private static void outPutChangeElementsArray(GenericType genObject, Scanner scanner){
        int index1 = -1;
        int index2 = -1;
        System.out.println("Напиши индексы (1..размер массива) элелментов, которые требуется поменять местами ( размер массива: "+genObject.getArray().length+")");
        System.out.println("Индекс1:");
        do {
            index1 = scanner.nextInt();
        }while (index1 <= 0 || index1 > genObject.getArray().length);
        System.out.println("Индекс2:");
        do {
            index2 = scanner.nextInt();
        }while (index2 <= 0 || index2 > genObject.getArray().length);
        System.out.println("Исходный массив:");
        genObject.printArray(genObject.getArray());
        System.out.println("Измененный массив:");
        genObject.printArray(genObject.changeElements(index1-1,index2-1));
        System.out.println("\n");
    }
}
