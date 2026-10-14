package dsl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import antlr.usecaseLexer;
import antlr.usecaseParser;
import antlr.usecaseParser.Usecase_specContext;
import metamodel.UsecaseSpecification;

public class UsecaseFileParser {

    /* 
    public UsecaseSpecification parseFile(String path) {
        String content = Files.readString(Path.of("" + path));

        return parseString(content);
    }
    */

    /**
     * Converts a .usecase file into its AST/metamodel representation.
     * 
     * Runs the string representation through the ANTLR pipeline to generate a
     * parse tree, then instantiates and calls a UsecaseParseVisitor which
     * converts each rule into an intermediate representation. After this, an
     * instantiator method is called to resolve each of these objects into its
     * corresponding metamodel class.
     * 
     * @param content The raw text of a .usecase specification.
     * @return a UsecaseSpecification class containing all use cases.
     */
    public UsecaseSpecification parseString(String content) {
        CharStream inputStream = CharStreams.fromString(content);
        usecaseLexer lexer = new usecaseLexer(inputStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        usecaseParser parser = new usecaseParser(tokens);

        // returns a Usecase_specContext
        Usecase_specContext parseTree = parser.usecase_spec();
        UsecaseParseVisitor visitor = new UsecaseParseVisitor();

        return visitor.visit(parseTree);
        }


}
