/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swinglib.validation;

import java.util.EventListener;

/**
 *
 * @author cameron
 */
public interface ValidationChangedEventListener extends EventListener {

    public void validationChangedEventOccurred(ValidationChangedEvent evt);
}
