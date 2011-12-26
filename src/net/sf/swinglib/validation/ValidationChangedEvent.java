/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swinglib.validation;

import java.util.EventObject;

/**
 *
 * @author cameron
 */
public class ValidationChangedEvent extends EventObject {
            private Boolean _newState;

        public ValidationChangedEvent(Object source, Boolean newState) {
            super(source);
            _newState = newState;
        }

        public Boolean getNewState() {
            return _newState;
        }
}
