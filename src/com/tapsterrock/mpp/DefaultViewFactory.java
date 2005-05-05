/*
 * file:       DefaultViewFactory.java
 * author:     Jon Iles
 * copyright:  (c) Tapster Rock Limited 2005
 * date:       Apr 7, 2005
 */
 
/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation; either version 2.1 of the License, or (at your
 * option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */

package com.tapsterrock.mpp;

import java.io.IOException;

/**
 * Default implementation of a view factory for MPP9 files.
 */
class DefaultViewFactory implements ViewFactory
{
   /**
    * @see ViewFactory#createView(byte[], Var2Data)
    */
   public View createView (byte[] fixedData, Var2Data varData)
      throws IOException
   {
      View view;
      int type = MPPUtility.getShort(fixedData, 112);
      switch (type)
      {
         case View.GANTT_CHART:
         {
            view = new GanttChartView9 (fixedData, varData);
            break;
         }
         
         default:
         {
            view = new View9 (fixedData);
            break;
         }
      }
      
      return (view);
   }
}
