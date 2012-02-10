/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swinglib.validation;


import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractAction;

/**
 *
 * @author cameron
 */
public abstract class AbstractValidatedAction extends AbstractAction {
    
    private Boolean _state;
    protected Set<IValidationGroup> boundValidationGroups;
    
    public AbstractValidatedAction(String label)
    {
        super(label);
        boundValidationGroups =  new  HashSet<IValidationGroup>();
        _state = true;
    }
    
    public void addValidationGroup(IValidationGroup validationGroup)
    {
        boundValidationGroups.add(validationGroup);
    }
    
    public void refreshActionValidation()
    {
        for (IValidationGroup validationGroups : boundValidationGroups)
        {
            _state = validationGroups.IsValid();
            if (!_state) break;
        }
        this.setEnabled(_state);
    }
    
}
