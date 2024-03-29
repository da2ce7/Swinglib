/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swinglib.field;

import javax.swing.text.Document;
import net.sf.swinglib.document.DocWatcher;
import net.sf.swinglib.actions.FieldValidationChange;

/**
 *
 * @author cameron
 */
public interface IFields<F extends Enum<F>> {
    
    void bindDoc(F key, Document doc);

    void bindValidatedDoc(F key, Document doc, FieldValidationChange _fieldValidationChange);
    
    String getFieldDocText(F fieldKey);
    
    DocWatcher getDocWatcher(F fieldKey);

    void updateFieldDoc(F fieldKey);

    void updateFieldDoc(F fieldKey, String newText);

    String getToolTipText(F fieldKey);
    
    String getFieldRegex(F fieldKey);
    
    Boolean getFieldStatus(F fieldKey);
    
    void fieldStatusChanged();
    
    void buildCheckedActions();
    
    void updateConfig();
}
