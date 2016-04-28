
package MyPackages;

import java.io.FileInputStream;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class JavaCompilerBuilder implements CompilerBuilder{

    public synchronized boolean compile(String code) {
        
        FileInputStream file;
        
        try{
            file = new FileInputStream("practise.txt");
            String fileToCompile = "practise" + java.io.File.separator +"practise.java";

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            int compilationResult = compiler.run(null, null, null, fileToCompile);
            
            file.close();
            if(compilationResult == 0){
                return true;
            }else{
                return false;
            }
        
        }catch(Exception e){
                System.out.println("Temporary writing file cannot be opened");
        }
        return false;
    }
    
    public boolean run(String code,String input,String ouput){
        
        return true;
    }
}
