/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.swinglib.actions;

import javax.swing.Action;
import net.sf.swinglib.dialog.IDialog;

/**
 *
 * @author cameron
 */
public interface IActions<K extends Enum<K>> {
    public Action getAction(K key);
    public IDialog getDialog();
    public void setConfig();
    public void setActionEnabled(K key, boolean enabled);
}
