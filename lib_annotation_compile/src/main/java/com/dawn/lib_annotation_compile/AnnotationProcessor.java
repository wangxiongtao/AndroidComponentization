package com.dawn.lib_annotation_compile;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;


@AutoService(Processor.class)//把这个类标记成注解生成器
public class AnnotationProcessor extends AbstractProcessor {

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return processingEnv.getSourceVersion();
    }

//    /**
//     * 声明注解处理器处理的注解
//     * @return
//     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
                "getSupportedAnnotationTypes " +
                        "found on " + this.getClass().getName() +
                        ", returning an empty set.");
        Set<String> stringSet=new HashSet<>();
        stringSet.add(BindPath.class.getCanonicalName());
        return stringSet;
    }

    /**
     * 编译时被调用
     * @param annotations
     * @param roundEnv
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Filer filer=processingEnv.getFiler();
        Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(BindPath.class);//获取注解标记的内容
        //类节点TypeElement
        //方法节点ExecutableElement
        Map<String,String>map=new HashMap<>();
        for (Element element : elementsAnnotatedWith) {
            TypeElement typeElement= (TypeElement) element;
            //得到包名加类名
            String activityName=typeElement.getQualifiedName().toString();
            //获取注解的值
            String path=typeElement.getAnnotation(BindPath.class).path();
            map.put(path,activityName+".class");

        }
//        messager.printMessage(Diagnostic.Kind.ERROR,"=process=list==>"+list.size());

        if(map.size()>0){
            Writer writer=null;

            generateCode(map);


//            String className="ActivityUtil"+System.currentTimeMillis();
//            try {
//                JavaFileObject sourceFile=filer.createSourceFile("com.dawn.util."+className);
//                writer=sourceFile.openWriter();
//                StringBuilder buffer=new StringBuilder();
//                buffer.append("package com.dawn.util;\n")
//                        .append("public class "+className+"{\n")
//                        .append("}");
//                writer.write(buffer.toString());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//                if(writer!=null){
//                    try {
//                        writer.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
        }
        return false;
    }



    private void generateCode(Map<String,String>map){
        MethodSpec.Builder builder=MethodSpec.methodBuilder("putAllActivity")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .returns(void.class);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String path=entry.getKey();
            String value=entry.getValue();
            String code="com.jetpack.baselib.router.AppRouter.getInstance().putActivity(\""+entry.getKey()+"\","+entry.getValue()+");\n";
            builder.addCode(code);
        }

        String className="ActivityUtil"+System.currentTimeMillis();
        TypeSpec helloWorld = TypeSpec.classBuilder(className)//创建类
                .addModifiers(Modifier.PUBLIC)//定义修饰符为 public final
                .addMethod(builder.build())//添加方法
//                    .addJavadoc("@  此方法由apt自动生成")//定义方法参数
                .build();

        JavaFile javaFile = JavaFile.builder("com.dawn.apt", helloWorld).build();// 生成源   代码

        try {
            javaFile.writeTo(processingEnv.getFiler());//// 在 app module/build/generated/source/apt 生成一份源代码
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
