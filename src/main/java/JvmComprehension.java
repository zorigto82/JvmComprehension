
public class JvmComprehension { // jvm подгружает класс JvmComprehension, вызывая classloader. После того, как classloader отработал в metaspace появляется класс JvmComprehension.

    public static void main(String[] args) { // Затем в момент вызова метода создаётся фрейм(кадр) в стеке, внутри спец. области памяти и здесь хранится вся информация в области видимости метода.
        int i = 1;                      // 1 Когда создаётся переменная i, то т.к. является значимым типом, то создаётся в стеке.
        Object o = new Object();        // 2 Далее создаётся объект, резервируя память в куче. Сама переменная содаётся в куче, потому что она ссылочного типа, а ссылка на переменную создаётся в стеке.
        Integer ii = 2;                 // 3 Здесь создаётся переменная типа Integer в куче, а ссылка на него в стеке.
        printAll(o, i, ii);             // 4 Далее вызывается новый метод путём создания нового фрейма в стеке.
        System.out.println("finished"); // 7 Новый фрейм в стеке.
    }

    private static void printAll(Object o, int i, Integer ii) { // Здесь будут созданы ссылки, которые ссылаются на те же объекты в куче.
        Integer uselessVar = 700;                   // 5 Здесь, я думаю, создаётся переменная типа Integer и ссылка на негов стеке, не имеющая отношения к методу printAll.
        System.out.println(o.toString() + i + ii);  // 6 Здесь создастся новый фрейм в стеке, куда будут переданы ссылки на o, i, ii.
    }
}

