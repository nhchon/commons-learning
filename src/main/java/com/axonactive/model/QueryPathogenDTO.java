/*************************************************************************
 *  Copyright (c) Metabiota Incorporated - All Rights Reserved
 *------------------------------------------------------------------------
 *  This material is proprietary to Metabiota Incorporated. The
 *  intellectual and technical concepts contained herein are proprietary
 *  to Metabiota Incorporated. Reproduction or distribution of this
 *  material, in whole or in part, is strictly forbidden unless prior
 *  written permission is obtained from Metabiota Incorporated.
 *************************************************************************/
package com.axonactive.model;

/**
 * Created by nhchon on 3/1/2017 10:26 AM.
 */
public class QueryPathogenDTO {
    private String name;

    public QueryPathogenDTO(){
    }

    public QueryPathogenDTO(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "[ " + name + "]";
    }

    @Override
    public boolean equals(Object q2){
        QueryPathogenDTO q22 = (QueryPathogenDTO) q2;

        return q22.getName().equals(this.name);
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }
}
