/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swing.document;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import net.sf.swinglib.actions.FieldValidationChange;

/**
 *
 * @author cameron
 */
public class DocWatcher implements DocumentListener {

    private Document _doc;
    private FieldValidationChange _fieldValidationChange;
    private DocValidator _docValidator;
    private Boolean state;
    protected javax.swing.event.EventListenerList listenerList = new javax.swing.event.EventListenerList();

    public DocWatcher(Document doc, String regex, FieldValidationChange fieldValidationChange) {
        doc.addDocumentListener(this);
        _doc = doc;
        _fieldValidationChange = fieldValidationChange;
        _docValidator = new DocValidator(_doc, regex);

        state = false;
        _fieldValidationChange.fieldValidationState(state);
        runChecks();
    }

    public void addMyEventListener(DocStateChangedEventListener listener) {
        listenerList.add(DocStateChangedEventListener.class, listener);
    }

    public void removeMyEventListener(DocStateChangedEventListener listener) {
        listenerList.remove(DocStateChangedEventListener.class, listener);
    }

    // This private class is used to fire MyEvents
    void fireMyEvent(DocStateChangedEvent evt) {
        Object[] listeners = listenerList.getListenerList();
        // Each listener occupies two elements - the first is the listener class
        // and the second is the listener instance
        for (int i = 0; i < listeners.length; i += 2) {
            if (listeners[i] == DocStateChangedEventListener.class) {
                ((DocStateChangedEventListener) listeners[i + 1]).stateChangedEventOccurred(evt);
            }
        }
    }
    
    public void refreshChecks() {
        boolean val = _docValidator.Validate();
            state = val;
            _fieldValidationChange.fieldValidationState(val);
            fireMyEvent(new DocStateChangedEvent(this, val));
    }
    
    private void runChecks() {
        boolean val = _docValidator.Validate();
        if (val != state) {
            state = val;
            _fieldValidationChange.fieldValidationState(val);
            fireMyEvent(new DocStateChangedEvent(this, val));
        }
    }

    public final boolean getIsValid() {
        return _docValidator.Validate();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        runChecks();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        runChecks();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        runChecks();
    }
}
