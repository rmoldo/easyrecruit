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

    public ApplicationId() {
    }

    public ApplicationId(int positionId, int candidateId) {
        this.position = positionId;
        this.candidate = candidateId;
    }

    private int candidate;
    private int position;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof ApplicationId)) {
            return false;
        }

        ApplicationId other = (ApplicationId) o;
        return this.candidate == other.candidate
                && this.position == other.position;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.candidate);
        hash = 13 * hash + Objects.hashCode(this.position);
        return hash;
    }
}
