package org.example.cup;

import java_cup.runtime.Symbol;

import java.io.StringReader;

public class SyntaxFacade {

    public Syntax syntax;

    /**
     * A syntax analyzer function
     * @param code Code to be analyzed
     * @throws Exception The code doesn't comply with the rules
     */
    public Symbol parse(String code) throws Exception {
        syntax = new Syntax(new DSLCup(new StringReader(code)));
        return syntax.parse();
    }

}
