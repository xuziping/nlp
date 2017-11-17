import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@Slf4j
public class TestCglib {
    public static  void main(String args[]) throws Exception{
dd();

        log.info("Finish");
    }

    public static   void dd() throws Exception{
       Type t =  Cglib2.class.getMethod("doSomething").getGenericReturnType();
        Type type = ((ParameterizedType) t).getActualTypeArguments()[0];
      Class cls =  Class.forName(type.getTypeName());
        System.out.println(t);
        System.out.println(t.getClass().getName());
    }
}  