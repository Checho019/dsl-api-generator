package org.example.lexer;

import java.io.IOException;
import java.io.StringReader;
import java.util.Dictionary;
import java.util.Hashtable;

public class LexerFacade {

    /**
     * @param input Tokens
     * @return Dictionary <\Token, String> where String is the lexeme
     * @throws IOException Using StringReader
     */
    public Dictionary<String, Tokens> lex(String input) throws IOException {
        LexicalAnalyzer lexer = new LexicalAnalyzer(new StringReader(input));
        Dictionary<String, Tokens> dictionary = new Hashtable<>();
        Tokens token;

        while ((token = lexer.yylex()) != null) {
            dictionary.put(lexer.lexeme, token);
        }

        return dictionary;
    }

}
