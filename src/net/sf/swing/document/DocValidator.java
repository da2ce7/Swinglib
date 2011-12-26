/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swing.document;

import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author cameron
 */
public class DocValidator {

    Document doc;
    Pattern patten;

    public DocValidator(Document doc, String regex) {
        this.doc = doc;
        this.patten = Pattern.compile(regex);
    }

    public boolean Validate() {
        try {
            String text = doc.getText(0, doc.getLength());
            if (text.equals("")) {
                return false;
            }
            return patten.matcher(text).matches();
        } catch (BadLocationException e) {
            //Todo: make exception
            return false;
        }
    }
}
