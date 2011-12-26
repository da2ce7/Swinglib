/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swing.document;

import java.util.EventObject;

/**
 *
 * @author cameron
 */
public class DocStateChangedEvent extends EventObject {
    
        private Boolean _newState;

        public DocStateChangedEvent(Object source, Boolean newState) {
            super(source);
            _newState = newState;
        }

        public Boolean getNewState() {
            return _newState;
        }
}
