/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.stacks;

import org.jboss.forge.addon.dependencies.Dependency;
import org.jboss.forge.furnace.services.Exported;
import org.jboss.jdf.stacks.model.Stacks;

/**
 * Easy access to the stacks
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
@Exported
public interface StacksManager
{
   /**
    * Returns the stack, configuring the StacksClient class with the configured proxy options
    */
   public Stacks getStacks();

   /**
    * Returns true if this dependency is a BOM and is contained in the Stacks.yaml file
    * 
    * @param dependency
    * @return
    */
   public boolean isStackBOM(Dependency dependency);
}
