/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swing.dialog.viewmodel;

import javax.swing.Action;
import javax.swing.text.Document;
import net.sf.swinglib.actions.FieldValidationChange;

/**
 *
 * @author cameron
 */
public interface IViewModel<F extends Enum<F>,A extends Enum<A>> {
    
    void bindDoc(F fieldKey, Document doc);
    void bindValidatedDoc(F fieldKey, Document doc, FieldValidationChange fieldValidationChange);
    String getFieldInfo(F fieldKey);
    
    Action getButtonAction(A buttonKey);
    String getButtonInfo(A buttonKey);
}
