package org.example.cup;

import java.io.StringReader;

public class SyntaxFacade {

    /**
     * A syntax analyzer function
     * @param code Code to be analyzed
     * @throws Exception The code doesn't comply with the rules
     */
    public void parse(String code) throws Exception {
        Syntax syntax = new Syntax(new DSLCup(new StringReader(code)));
        syntax.parse();
    }

}
