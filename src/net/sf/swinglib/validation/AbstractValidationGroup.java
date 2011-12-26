/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swinglib.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.swing.event.EventListenerList;

/**
 *
 * @author cameron
 */
public abstract class AbstractValidationGroup<Group extends Enum<Group>> {
    
    private Boolean _state;
    protected Set<Group> validationItems;
    protected Map<Group,Boolean> validationItemsStates;
    protected EventListenerList listenerList = new EventListenerList();
    
    public AbstractValidationGroup(Set<Group> validationItems, Map<Group,Boolean> validationItemsStates)
    {
        this.validationItems =  validationItems;
        this.validationItemsStates = validationItemsStates;
    }
    
    public void addItemToCheck(Group group)
    {
        validationItems.add(group);
    }
    
    public abstract void getFreshValues();
    
    public void refreshValidationGroup()
    {
        getFreshValues();
        Boolean newstate = Boolean.TRUE;
        for (Boolean val : validationItemsStates.values())
        {
            if (val == null) val = false;
            newstate = val;
            if (!newstate) break;
        }
        if (_state != newstate){
            _state = newstate;
            fireValidationChangedEvent(new ValidationChangedEvent(this, _state));
            System.out.println("fieldStatusChanged!!");
        }
    }

    public void addValidationChangedEventListener(ValidationChangedEventListener listener) {
        listenerList.add(ValidationChangedEventListener.class, listener);
    }

    public void removeValidationChangedEventListener(ValidationChangedEventListener listener) {
        listenerList.remove(ValidationChangedEventListener.class, listener);
    }

    // This private class is used to fire MyEvents
    protected void fireValidationChangedEvent(ValidationChangedEvent evt) {
        //Lets use a set, so that we don't fire any events more than once; and keep it type-safe :)
        Set<ValidationChangedEventListener> listeners = new HashSet<ValidationChangedEventListener>();
        listeners.addAll(Arrays.asList(listenerList.getListeners(ValidationChangedEventListener.class)));

        for (ValidationChangedEventListener listener : listeners) {
            listener.validationChangedEventOccurred(evt);
        }
    }
}
