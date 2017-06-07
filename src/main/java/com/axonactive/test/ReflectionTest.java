/*************************************************************************
 *  Copyright (c) ChonNguyen Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to ChonNguyen Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to ChonNguyen Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from ChonNguyen Incorporated.
 *************************************************************************/
package com.axonactive.test;

import com.axonactive.model.QueryEventDTO;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nhchon on 3/22/2017 11:32 AM.
 */
public class ReflectionTest {

    public static void main(String[] args){
        Field[] fields = QueryEventDTO.class.getDeclaredFields();
        Method[] methods = QueryEventDTO.class.getMethods();
        Method returnM = null;
        for(Method m : methods){
            if(m.getName().equals("getPathogen")){
                returnM = m;
                break;
            }
            //System.out.println(m.getName());
        }

        for (Field f : fields)
        {
            //System.out.println(f.getType().isAssignableFrom(Number.class));
            //System.out.println(Number.class.isAssignableFrom(f.getType()));
            //System.out.println(f.getType().getName());
            System.out.println(f.getName());
        }

        List<Field> fieldList = Arrays.asList(QueryEventDTO.class.getDeclaredFields());
        fieldList.forEach(f ->{
            if(f.getName().equals(""))
            return;
        });

        Arrays.asList(QueryEventDTO.class.getDeclaredFields()).forEach(f -> {
            //if(f.equals("asas"))
        });
    }
}
