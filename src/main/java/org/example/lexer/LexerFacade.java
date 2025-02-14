package org.example.lexer;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class LexerFacade {

    /**
     * @param input Tokens
     * @return Dictionary <\Token, String> where String is the lexeme
     * @throws IOException Using StringReader
     */
    public List<Token> lex(String input) throws IOException {
        LexicalAnalyzer lexer = new LexicalAnalyzer(new StringReader(input));
        List<Token> tokens = new ArrayList<>();
        Tokens token;

        while ((token = lexer.yylex()) != null) {
            tokens.add(new Token(lexer.lexeme, token));
        }

        return tokens;
    }

}
