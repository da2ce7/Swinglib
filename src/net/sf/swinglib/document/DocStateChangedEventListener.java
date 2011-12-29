/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swinglib.document;

import java.util.EventListener;

/**
 *
 * @author cameron
 */
public interface DocStateChangedEventListener extends EventListener {

    public void stateChangedEventOccurred(DocStateChangedEvent evt);
}
