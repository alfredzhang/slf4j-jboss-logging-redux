/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.slf4j;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.helpers.MessageFormatter;
import org.slf4j.spi.LocationAwareLogger;

/**
 * A wrapper over {@link org.jboss.logging.Logger org.jboss.logging.Logger}
 * in conformance with the {@link Logger} interface.
 *
 * Adapted from the corresponding slf4j-log4j adapter.
 * 
 * @author <a href="mailto:dimitris@jboss.org">Dimitris Andreadis</a>
 * @version <tt>$Revision: 2784 $</tt>
 */
public final class JBossLoggerAdapter extends MarkerIgnoringBase
   implements LocationAwareLogger
{
   private static final long serialVersionUID = -1855332334983449117L;

   final org.jboss.logging.Logger logger;
  
   private static final String LOGGER_FQCN = JBossLoggerAdapter.class.getName();

   // package access so that only JBossLoggerFactory be able to create one.
   JBossLoggerAdapter(org.jboss.logging.Logger logger)
   {
      this.logger = logger;
   }

   public String getName()
   {
      return logger.getName();
   }

   public boolean isTraceEnabled()
   {
      return logger.isTraceEnabled();
   }

   public void trace(String msg)
   {
      logger.trace(LOGGER_FQCN, msg, null);
   }

   public void trace(String format, Object arg)
   {
      if (logger.isTraceEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
         logger.trace(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }

   public void trace(String format, Object arg1, Object arg2)
   {
      if (logger.isTraceEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
         logger.trace(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }
  
   public void trace(String format, Object[] argArray)
   {
      if (logger.isTraceEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.arrayFormat(format, argArray);
         logger.trace(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }

   public void trace(String msg, Throwable t)
   {
      logger.trace(LOGGER_FQCN, msg, t);
   }

   public boolean isDebugEnabled()
   {
      return logger.isDebugEnabled();
   }

   public void debug(String msg)
   {
      logger.debug(LOGGER_FQCN, msg, null);
   }

   public void debug(String format, Object arg)
   {
      if (logger.isDebugEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
         logger.debug(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }

   public void debug(String format, Object arg1, Object arg2)
   {
      if (logger.isDebugEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
         logger.debug(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }
  
   public void debug(String format, Object[] argArray)
   {
      if (logger.isDebugEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.arrayFormat(format, argArray);
         logger.debug(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }

   public void debug(String msg, Throwable t)
   {
      logger.debug(LOGGER_FQCN, msg, t);
   }

   public boolean isInfoEnabled()
   {
      return logger.isInfoEnabled();
   }

   public void info(String msg)
   {
      logger.info(LOGGER_FQCN, msg, null);
   }

   public void info(String format, Object arg)
   {
      if (logger.isInfoEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
         logger.info(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }

   public void info(String format, Object arg1, Object arg2)
   {
      if (logger.isInfoEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
         logger.info(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }

   public void info(String format, Object[] argArray)
   {
      if (logger.isInfoEnabled())
      {
         FormattingTuple formattingTuple = MessageFormatter.arrayFormat(format, argArray);
         logger.info(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
      }
   }

   public void info(String msg, Throwable t)
   {
      logger.info(LOGGER_FQCN, msg, t);
   }

   public boolean isWarnEnabled()
   {
      // not supported by jboss-logging-spi
      return true;
   }
  
   public void warn(String msg)
   {
      logger.warn(LOGGER_FQCN, msg, null);
   }

   public void warn(String format, Object arg)
   {
      FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
      logger.warn(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
   }

   public void warn(String format, Object arg1, Object arg2)
   {
      FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
      logger.warn(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
   }

   public void warn(String format, Object[] argArray)
   {
      FormattingTuple formattingTuple = MessageFormatter.arrayFormat(format, argArray);
      logger.warn(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
   }

   public void warn(String msg, Throwable t)
   {
      logger.warn(LOGGER_FQCN, msg, t);
   }

   public boolean isErrorEnabled()
   {
      // not supported by jboss-logging-spi
      return true;
   }

   public void error(String msg)
   {
      logger.error(LOGGER_FQCN, msg, null);
   }

   public void error(String format, Object arg)
   {
      FormattingTuple formattingTuple = MessageFormatter.format(format, arg);
      logger.error(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
   }

   public void error(String format, Object arg1, Object arg2)
   {
      FormattingTuple formattingTuple = MessageFormatter.format(format, arg1, arg2);
      logger.error(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
   }

   public void error(String format, Object[] argArray)
   {
      FormattingTuple formattingTuple = MessageFormatter.arrayFormat(format, argArray);
      logger.error(LOGGER_FQCN, formattingTuple.getMessage(), formattingTuple.getThrowable());
   }

   public void error(String msg, Throwable t)
   {
      logger.error(LOGGER_FQCN, msg, t);
   }

   public void log(Marker marker, String callerFQCN, int level, String msg, Throwable t)
   {
      switch(level)
      {
         case LocationAwareLogger.TRACE_INT:
            logger.trace(callerFQCN, msg, t);
            break;
            
         case LocationAwareLogger.DEBUG_INT:
            logger.debug(callerFQCN, msg, t);
            break;
            
         case LocationAwareLogger.INFO_INT:
            logger.info(callerFQCN, msg, t);
            break;
            
         case LocationAwareLogger.WARN_INT:
            logger.warn(callerFQCN, msg, t);
            break;
            
         case LocationAwareLogger.ERROR_INT:
            logger.error(callerFQCN, msg, t);
            break;
            
         default:
            throw new IllegalStateException("Level number " + level + " is not recognized.");
      }
   }

   public void log(Marker marker, String callerFQCN, int level, String msg, Object[] argArray, Throwable t)
   {
      String formattedMessage = MessageFormatter.arrayFormat(msg, argArray).getMessage();
      switch(level)
      {
         case LocationAwareLogger.TRACE_INT:
            logger.trace(callerFQCN, formattedMessage, t);
            break;

         case LocationAwareLogger.DEBUG_INT:
            logger.debug(callerFQCN, formattedMessage, t);
            break;

         case LocationAwareLogger.INFO_INT:
            logger.info(callerFQCN, formattedMessage, t);
            break;

         case LocationAwareLogger.WARN_INT:
            logger.warn(callerFQCN, formattedMessage, t);
            break;

         case LocationAwareLogger.ERROR_INT:
            logger.error(callerFQCN, formattedMessage, t);
            break;

         default:
            throw new IllegalStateException("Level number " + level + " is not recognized.");
      }
   }
}
