/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.stacks;

import org.jboss.forge.addon.facets.constraints.RequiresFacet;
import org.jboss.forge.addon.projects.ProjectFacet;
import org.jboss.forge.addon.projects.facets.DependencyFacet;
import org.jboss.jdf.stacks.model.BomVersion;
import org.jboss.jdf.stacks.model.Runtime;

/**
 * Returns the configured stack for the project
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
@RequiresFacet(DependencyFacet.class)
public interface StacksFacet extends ProjectFacet
{

   /**
    * Returns the Runtime this project is configured.
    */
   Runtime getRuntime();

   /**
    * Installs the Bom dependency with the required version
    * 
    * @param bom
    */
//   void setBomVersion(BomVersion bom);
//
//   BomVersion getBomVersion();

}
