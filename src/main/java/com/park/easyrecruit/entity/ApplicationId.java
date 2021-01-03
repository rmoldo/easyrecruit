/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.park.easyrecruit.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author andrei
 */
public class ApplicationId implements Serializable {

    private Integer candidateId;
    private Integer positionId;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ApplicationId)) {
            return false;
        }

        ApplicationId other = (ApplicationId) o;
        return this.candidateId == other.candidateId
                && this.positionId == other.positionId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.candidateId);
        hash = 13 * hash + Objects.hashCode(this.positionId);
        return hash;
    }
}
