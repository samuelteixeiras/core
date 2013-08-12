/**
 * Copyright 2013 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.addon.stacks;

import java.util.List;

import org.jboss.jdf.stacks.client.StacksClient;
import org.jboss.jdf.stacks.model.Bom;
import org.jboss.jdf.stacks.model.BomVersion;
import org.jboss.jdf.stacks.model.MajorRelease;
import org.jboss.jdf.stacks.model.MinorRelease;
import org.jboss.jdf.stacks.model.Runtime;
import org.jboss.jdf.stacks.model.Stacks;

/**
 * 
 * @author <a href="ggastald@redhat.com">George Gastaldi</a>
 */
public class StacksTeste
{
   public static void main(String[] args) throws Exception
   {
      StacksClient stacksClient = new StacksClient();
      stacksClient.eraseRepositoryCache();
      Stacks stacks = stacksClient.getStacks();

      List<MajorRelease> majorReleases = stacks.getMajorReleases();
      for (MajorRelease majorRelease : majorReleases)
      {
         System.out.println();
         System.out.println("MAJOR RELEASE: " + majorRelease.getName()
                  + " - " + majorRelease.getVersion());
         Runtime r = majorRelease.getRecommendedRuntime();
         System.out.println("----");
         System.out.println(r.getName());
         List<BomVersion> boms = r.getBoms();
         for (BomVersion bomVersion : boms)
         {
            Bom bom = bomVersion.getBom();
            System.out.println("--> " + bom.getName() + " - "
                     + bomVersion.getVersion());
         }
      }

      List<MinorRelease> minorReleases = stacks.getMinorReleases();
      for (MinorRelease minorRelease : minorReleases)
      {
         System.out.println();
         System.out.println("MINOR RELEASE: " + minorRelease.getName()
                  + " - " + minorRelease.getVersion());
         Runtime r = minorRelease.getRecommendedRuntime();
         System.out.println("----");
         System.out.println(r.getName());
         List<BomVersion> boms = r.getBoms();
         for (BomVersion bomVersion : boms)
         {
            Bom bom = bomVersion.getBom();
            System.out.println("--> " + bom.getName() + " - "
                     + bomVersion.getVersion());
         }

      }

   }
}
