/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.ui.impl;

import java.util.concurrent.Callable;

import javax.enterprise.inject.Vetoed;

import org.jboss.forge.convert.Converter;
import org.jboss.forge.facets.BaseFaceted;
import org.jboss.forge.ui.facets.HintsFacet;
import org.jboss.forge.ui.input.InputComponent;
import org.jboss.forge.ui.input.UIInput;
import org.jboss.forge.ui.util.Callables;

/**
 * Implementation of a {@link UIInput} object
 * 
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 * 
 * @param <VALUETYPE>
 */
@Vetoed
@SuppressWarnings("unchecked")
public abstract class UIInputComponentBase<IMPLTYPE extends InputComponent<IMPLTYPE, VALUETYPE>, VALUETYPE> extends BaseFaceted<HintsFacet>
         implements InputComponent<IMPLTYPE, VALUETYPE>
{
   private final String name;

   private String label;
   private Callable<Boolean> enabled = Callables.returning(Boolean.TRUE);
   private Callable<Boolean> required = Callables.returning(Boolean.FALSE);
   private String requiredMessage;

   private Class<VALUETYPE> type;
   private Converter<String, VALUETYPE> valueConverter;

   public UIInputComponentBase(String name, Class<VALUETYPE> type)
   {
      this.name = name;
      this.type = type;
   }

   @Override
   public String getLabel()
   {
      return label;
   }

   @Override
   public String getName()
   {
      return name;
   }

   @Override
   public Class<VALUETYPE> getValueType()
   {
      return type;
   }

   @Override
   public boolean isEnabled()
   {
      return Callables.call(enabled);
   }

   @Override
   public boolean isRequired()
   {
      return Callables.call(required);
   }

   @Override
   public IMPLTYPE setEnabled(boolean enabled)
   {
      this.enabled = Callables.returning(enabled);
      return (IMPLTYPE) this;
   }

   @Override
   public IMPLTYPE setEnabled(Callable<Boolean> callback)
   {
      enabled = callback;
      return (IMPLTYPE) this;
   }

   @Override
   public IMPLTYPE setLabel(String label)
   {
      this.label = label;
      return (IMPLTYPE) this;
   }

   @Override
   public IMPLTYPE setRequired(boolean required)
   {
      this.required = Callables.returning(required);
      return (IMPLTYPE) this;
   }

   @Override
   public IMPLTYPE setRequired(Callable<Boolean> required)
   {
      this.required = required;
      return (IMPLTYPE) this;
   }

   @Override
   public boolean supports(HintsFacet type)
   {
      return true;
   }

   @Override
   public String getRequiredMessage()
   {
      return requiredMessage;
   }

   @Override
   public IMPLTYPE setRequiredMessage(String requiredMessage)
   {
      this.requiredMessage = requiredMessage;
      return (IMPLTYPE) this;
   }

   @Override
   public Converter<String, VALUETYPE> getValueConverter()
   {
      return valueConverter;
   }

   @Override
   public IMPLTYPE setValueConverter(Converter<String, VALUETYPE> converter)
   {
      this.valueConverter = converter;
      return (IMPLTYPE) this;
   }

}