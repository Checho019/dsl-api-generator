package lexer;


import org.example.lexer.LexerFacade;
import org.example.lexer.Tokens;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Iterator;

public class LexerTest {

    private LexerFacade lexerFacade;
    private Dictionary<String, Tokens> expectedTokens;

    @Before
    public void setUp() {
        lexerFacade = new LexerFacade();
        expectedTokens = new Hashtable<>() {{
            put("DEFINE", Tokens.DEFINE);
            put("AS", Tokens.AS);
            put("FOR", Tokens.FOR);
            put("ENTITY", Tokens.ENTITY);
            put("CONTROLLER", Tokens.CONTROLLER);
            put("DTO", Tokens.DTO);
            put("VALIDATIONS", Tokens.VALIDATIONS);
            put("CONFIGURE", Tokens.CONFIGURE);
            put("RELATIONSHIP", Tokens.RELATIONSHIP);
            put("DATASOURCE", Tokens.DATASOURCE);
            put("IS", Tokens.IS);
            put("NOT", Tokens.NOT);
            put("NULL", Tokens.NULL);
            put("GREATER_THAN", Tokens.GREATER_THAN);
            put("LESS_THAN", Tokens.LESS_THAN);
            put("EQUALS_TO", Tokens.EQUALS_TO);
            put("UNIQUE", Tokens.UNIQUE);
            put("ID", Tokens.ID);
            put("ONE_TO_ONE", Tokens.ONE_TO_ONE);
            put("ONE_TO_MANY", Tokens.ONE_TO_MANY);
            put("MANY_TO_MANY", Tokens.MANY_TO_MANY);
            put("TO", Tokens.TO);
            put("PATH", Tokens.PATH);
            put("METHODS", Tokens.METHODS);
            put("GET", Tokens.GET);
            put("POST", Tokens.POST);
            put("PUT", Tokens.PUT);
            put("DELETE", Tokens.DELETE);
            put("WITH", Tokens.WITH);
            put("EXCLUDE", Tokens.EXCLUDE);
            put("URL", Tokens.URL);
            put("USERNAME", Tokens.USERNAME);
            put("PASSWORD", Tokens.PASSWORD);
            put("DRIVER", Tokens.DRIVER);
            put("STRING", Tokens.STRING);
            put("INTEGER", Tokens.INTEGER);
            put("LONG", Tokens.LONG);
            put("BOOLEAN", Tokens.BOOLEAN);
            put("FLOAT", Tokens.FLOAT);
            put("student", Tokens.IDENTIFIER);
            put("car", Tokens.IDENTIFIER);
            put("phone_number", Tokens.IDENTIFIER);
            put("master54", Tokens.IDENTIFIER);
            put("_var", Tokens.IDENTIFIER);
            put("-45", Tokens.NUMBER);
            put("-12.5", Tokens.NUMBER);
            put("12", Tokens.NUMBER);
            put("23.54", Tokens.NUMBER);
            put("Hello World", Tokens.STRING_LITERAL);
            put("A beautiful day", Tokens.STRING_LITERAL);
            put("An empty scroll", Tokens.STRING_LITERAL);
            put("{", Tokens.LBRACE);
            put("}", Tokens.RBRACE);
            put("(", Tokens.LPAREN);
            put(")", Tokens.RPAREN);
            put("[", Tokens.LBRACKET);
            put("]", Tokens.RBRACKET);
            put(":", Tokens.COLON);
            put(",", Tokens.COMMA);
            put("=", Tokens.EQUALS);
            put("/", Tokens.ERROR);
            put("&", Tokens.ERROR);
            put("!", Tokens.ERROR);
            put("%", Tokens.ERROR);
            put("\"", Tokens.ERROR);
            put("1car", Tokens.ERROR);
        }};
    }

    @Test
    public void testLexer() throws IOException {
        String stringTest = """
            DEFINE AS FOR ENTITY CONTROLLER DTO VALIDATIONS CONFIGURE RELATIONSHIP DATASOURCE IS NOT NULL GREATER_THAN
            LESS_THAN EQUALS_TO UNIQUE ID ONE_TO_ONE ONE_TO_MANY MANY_TO_MANY TO PATH METHODS GET POST PUT DELETE WITH
            EXCLUDE URL USERNAME PASSWORD DRIVER STRING INTEGER LONG BOOLEAN FLOAT student car phone_number master54
            _var -45 -12.5 12 23.54 "Hello World" 'A beautiful day' "An empty scroll" { } ( ) [ ] : , = / & ! % " 1car
        """;

        Dictionary<String, Tokens> lexerResul = lexerFacade.lex(stringTest);
        compareTokens(lexerResul);
    }

    private void compareTokens(Dictionary<String, Tokens> lexerResul) {
        assertThat("The size of the dictionaries aren't the same", lexerResul.size(), equalTo(expectedTokens.size()));

        Iterator<String> keysIterator = expectedTokens.keys().asIterator();
        while (keysIterator.hasNext()) {
            String lexeme = keysIterator.next();
            Tokens expected = expectedTokens.get(lexeme);
            Tokens actual = lexerResul.get(lexeme);
            assertEquals("Token error: " + lexeme + " is not " + actual, expected, actual);
        }

        keysIterator = expectedTokens.keys().asIterator();
        while (keysIterator.hasNext()) {
            String lexeme = keysIterator.next();
            assertNotNull("Unexpected token: " + lexeme, lexerResul.get(lexeme));
        }
    }

}
