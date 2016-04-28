package MyPackages;

public class CompilerFactory{

        private CompilerBuilder builder;
        
        public static CompilerBuilder getBuilder(String language){
            
            if(language.equals("JAVA"))
                    return new JavaCompilerBuilder();
           
            return null;
        }
}
