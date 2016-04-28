package MyPackages;

public class Compiler {
    
    private String code;
    private String language;
    private String input;
    private String output;
    
    private CompilerBuilder builder;
    
    Compiler(String code,String language){
        this.code = code;
        this.language = language;
        builder = CompilerFactory.getBuilder(language);
    }
    
    boolean compile(){
        return builder.compile(code);
    }
    
    boolean run(){
        return builder.run(code, input, output);
    }
}
