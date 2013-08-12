/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.stacks.facets;

import javax.inject.Inject;

import org.jboss.forge.addon.facets.AbstractFacet;
import org.jboss.forge.addon.projects.Project;
import org.jboss.forge.addon.projects.facets.DependencyFacet;
import org.jboss.forge.addon.stacks.StacksFacet;
import org.jboss.forge.addon.stacks.StacksManager;
import org.jboss.jdf.stacks.model.BomVersion;
import org.jboss.jdf.stacks.model.Runtime;

/**
 * Implementation of the stacks facet
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
public class StacksFacetImpl extends AbstractFacet<Project> implements StacksFacet
{

   @Inject
   private StacksManager stacksManager;

   private Runtime runtime;

   private BomVersion bomVersion;

   @Override
   public Runtime getRuntime()
   {
      Project project = getFaceted();
      DependencyFacet dependencyFacet = project.getFacet(DependencyFacet.class);
      // dependencyFacet.getDe
      return runtime;
   }

   @Override
   public boolean install()
   {
      return true;
   }

   @Override
   public boolean isInstalled()
   {
      return getRuntime() != null;
   }

}
